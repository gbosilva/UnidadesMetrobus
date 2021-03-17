package mx.qro.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.qro.model.AdressComponent;
import mx.qro.model.Alcaldia;
import mx.qro.model.CodigoPostal;
import mx.qro.model.Direccion;
import mx.qro.model.Result;
import mx.qro.model.UbicacionMetrobus;
import mx.qro.repository.IAlcaldiaRepository;
import mx.qro.repository.ICodigoPostalRepository;
import mx.qro.repository.IUbicacionMetrobusRepository;

/**
* Queretaro Mexico<br>
* <br><b>Project:</b> apis-metrobus-service
* <br><b>Class:</b> UbicacionMetrobusService.java
* <br><b>Description:</b>
* Interface Repository para acceder a los datos de las ubicaciones
*
* @author FSW Jose Gabriel Silva Bustamante
* @company JGSB
* @created 7/03/2021
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0 7/03/2021 FSW joga Creacion de service
*
* @category Service
*
*/
@Service
public class UbicacionMetrobusService implements IUbicacionMetrobusService {

	/**
	 * Variable LOGGER de tipo Logger
	 */
	private static final Logger LOGGER = LoggerFactory.
			getLogger(UbicacionMetrobusService.class);
	
	/**
	 * Es la instancia del repositorio de ubicaciones
	 */
	@Autowired
	private IUbicacionMetrobusRepository iUbicacionMetrobusRepository;

	/**
	 * Es la instancia del repositorio de alcaldias
	 */
	@Autowired
	private IAlcaldiaRepository iAlcaldiaRepository;

	/**
	 * Es la instancia del servicio de direcciones de alcaldias
	 */
	@Autowired
	private IDireccionAlcaldiaService iAlcaldiaService;

	/**
	 * Es la instancia del servicio de codigos postales
	 */
	@Autowired
	private ICodigoPostalRepository iCodigoPostalRepository;
	
	/**
	 * Metodo para buscar todas las ubidades disponibles
	 * @return Lista de objetos UbicacionMetrobus
	 */
	@Override
	public List<UbicacionMetrobus> buscaUnidadesDisponibles() {
		List<UbicacionMetrobus> unidadesList = 
				iUbicacionMetrobusRepository.buscaUnidadesDisponibles();
		LOGGER.info("-->>	Unidades localizadas");
		return unidadesList;
	}
	
	/**
	 * Metodo para buscar una unidad filtrando por el id
	 * @param vehicleId de la unidad a buscar
	 * @return objeto UbicacionMetrobus
	 */
	@Override
	public List<UbicacionMetrobus> buscaPorId(Integer vehicleId) {
		List<UbicacionMetrobus> unidadesList = iUbicacionMetrobusRepository
				.buscaUnidadPorVehicleId(vehicleId);
		LOGGER.info("-->>	Unidades localizadas");
		return unidadesList;
	}
	
	/**
	 * Metodo para buscar una lista de alcaldias disponibles
	 * @return objeto Alcaldia
	 */
	@Override
	public List<Alcaldia> buscaAlcaldiasDisponibles() {
		//Busca unidades que no tengan una alcaldia guardada 
		List<UbicacionMetrobus> unidadesList = 
				iUbicacionMetrobusRepository.buscaUnidadesSinAlcaldia();
		
		List<Direccion> direccionList = new ArrayList<>();
		int consultasAPI = 0;
		int cuentaMatch = 0;
		for (UbicacionMetrobus ubicacionMetrobus : unidadesList) {
			consultasAPI ++;
			Direccion direccion = new Direccion();
			//Toma latitud y longitud y los pasa como parametro para
			//consultar la alcaldia en la que se ecuentra cada unidad
			direccion = iAlcaldiaService.consultaAlcaldiaPorAPI(
					ubicacionMetrobus.getGeographicPoint());
			direccionList.add(direccion);
			for (Result result : direccion.getResults()) {
				
				//Si direccion contiene el nombre (rango de codigos postales) de la alcaldia
				//entonces agrega esa unidad a la lista de retorno
				Integer codigoPostal = buscaCodigoPostalEnDireccion(result);
				if(codigoPostal != 0) {
					cuentaMatch ++;
					//Si encontro nombre, entonces busca el objeto alcaldia
					//y se lo agrega al objeto ubicacion para guardar en bd
					Alcaldia alcaldia = iAlcaldiaRepository
							.encuentraAlcaldiaPorCodigoPostal(codigoPostal);
					ubicacionMetrobus.setAlcaldia(alcaldia);
					iUbicacionMetrobusRepository.save(ubicacionMetrobus);
					break;
				}
			}
		}
		//Actualiza total de unidades en alcaldias
		actualizaTotal();
		
		LOGGER.info("Consultas al api: {}", consultasAPI);
		LOGGER.info("Consultas encontradas: {}", cuentaMatch);
//		LOGGER.info("Direcciones: {}", direccionList);
		List<Alcaldia> alcaldiaList = 
				iUbicacionMetrobusRepository.encuentraAlcaldiasDisponibles();
		LOGGER.info("-->>	Alcaldias localizadas");
		return alcaldiaList;
	}
	
	/**
	 * Metodo para buscar una lista de unidades que pertenezcan a la 
	 * alcaldia establecida por parametro nombre
	 * de la alcaldia
	 * @param nombre de la alcaldia a buscar
	 * @return objeto UbicacionMetrobus
	 */
	@Override
	public List<UbicacionMetrobus> buscaPorNombre(String nombre) {
		
		//Busca unidades que no tengan una alcaldia guardada 
		List<UbicacionMetrobus> unidadesList = 
				iUbicacionMetrobusRepository.buscaUnidadesSinAlcaldia();
		
		//Lista de retorno
		List<UbicacionMetrobus> ubicacionesList = new ArrayList<>();
		
		//Lista para validacion previa al consumo del api
		List<UbicacionMetrobus> alcaldiasList = iUbicacionMetrobusRepository
				.buscaUnidadPorAlcaldia(nombre);
		if(alcaldiasList.size() == 0) {
			//Recorre la lista de unidades para obtener latitud y longitud
			recorreDireccionesDeUnidades(unidadesList, ubicacionesList, nombre);
		} else {
			LOGGER.info("-->>	Unidades localizadas desde la bd");
			return alcaldiasList;
		}
		
		LOGGER.info("-->>	Unidades localizadas");
		return ubicacionesList;
	}
	
	/**
	 * Metodo que recorre las unidades en busca de latitud y longitud para 
	 * enviarlas al api para que haga la traduccion a direccion
	 * @param unidadesList lista de unidades en bd
	 * @param ubicacionesList	lista de unidades encontradas
	 * @param direccionList		lista de las direcciones de cada unidad
	 * @param nombre
	 */
	public void recorreDireccionesDeUnidades(List<UbicacionMetrobus> unidadesList
			, List<UbicacionMetrobus> ubicacionesList, String nombre) {
		
		int consultasAPI = 0;
		int cuentaMatch = 0;
		for (UbicacionMetrobus ubicacionMetrobus : unidadesList) {
			consultasAPI ++;
			Direccion direccion = new Direccion();
			//Toma latitud y longitud y los pasa como parametro para
			//consultar la alcaldia en la que se ecuentra cada unidad
			direccion = iAlcaldiaService.consultaAlcaldiaPorAPI(
					ubicacionMetrobus.getGeographicPoint());
			for (Result result : direccion.getResults()) {
				
				//Si direccion contiene el nombre (rango de codigos postales) de la alcaldia
				//entonces agrega esa unidad a la lista de retorno
				if(buscaCPEnDireccion(result.getFormattedAddress(), nombre)) {
					cuentaMatch ++;
					ubicacionesList.add(ubicacionMetrobus);
					//Si encontro nombre, entonces busca el objeto alcaldia
					//y se lo agrega al objeto ubicacion para guardar en bd
					Alcaldia alcaldia = iAlcaldiaRepository.findByNombre(nombre);
					ubicacionMetrobus.setAlcaldia(alcaldia);
					iUbicacionMetrobusRepository.save(ubicacionMetrobus);
					break;
				}
				
			}
		}
		//Actualiza total de unidades en alcaldias
		actualizaTotal();
		LOGGER.info("Consultas al api: {}", consultasAPI);
		LOGGER.info("Consultas encontradas: {}", cuentaMatch);
	}
	
	/**
	 * Metodo que valida si un codigo postal le pertenece a una alcaldia
	 * buscando el rango de codigos postales por nombre de alcaldia
	 * y comparando cps
	 * @param formattedAddress la direccion
	 * @param nombre a validar
	 * @return
	 */
	public Boolean buscaCPEnDireccion(String formattedAddress, String nombre) {
		
		//Busca el codigo postal correspondiente a la alcaldia por nombre
		CodigoPostal postalCode = iAlcaldiaRepository.encuentraCPPorNombreAlcaldia(nombre);
		
		//Codigo postal a validar
		String codigoPostal = buscaCodigoPostal(formattedAddress);
		if(codigoPostal != null) {
			
			Integer codigoPostalEnNumero = Integer.parseInt(codigoPostal);
			if(codigoPostalEnNumero >= Integer.parseInt(postalCode.getRangoInicial()) 
					&& codigoPostalEnNumero <= Integer.parseInt(postalCode.getRangoFinal())) {
				return true;
			}
			
		}
		return false;
	}
	
	/**
	 * Metodo que valida si un codigo postal le pertenece a una alcaldia
	 * buscando el rango de codigos postales
	 * y comparando cps
	 * @param result la direccion
	 * @return
	 */
	public Integer buscaCodigoPostalEnDireccion(Result result) {
		
		//Busca el codigo postal correspondiente a la alcaldia por nombre
		List<CodigoPostal> codigoPostalList = 
				(List<CodigoPostal>) iCodigoPostalRepository.findAll();
		
		//Codigo postal a validar
		String codigoPostal = buscaCodigoPostal(result.getAdressComponents());
		if(codigoPostal != null) {
			
			Integer codigoPostalEnNumero = Integer.parseInt(codigoPostal);
			for(CodigoPostal cp : codigoPostalList) {
				
				if(codigoPostalEnNumero >= Integer.parseInt(cp.getRangoInicial()) 
						&& codigoPostalEnNumero <= Integer.parseInt(cp.getRangoFinal())) {
					return cp.getIdCodigoPostal();
				}
			}
			
		}
		return 0;
	}
	
	/**
	 * Metodo para actualizar el numero total de unidades por alcaldia
	 */
	public void actualizaTotal() {
		//Actualiza total de unidades en alcaldias
		List<Alcaldia> alcaldialist = (List<Alcaldia>) iAlcaldiaRepository.findAll();
		Integer id = 1;
		for (Alcaldia alcaldia : alcaldialist) {
			
			Integer total = iUbicacionMetrobusRepository.cuentaAlcaldias(id);
			alcaldia.setTotal(total);
			iAlcaldiaRepository.save(alcaldia);
			id ++;
		}
	}

	/**
	 * Metodo que busca un codigo postal de 5 digitos de longitud dentro de una
	 * cadena de caracteres o una direccion 
	 * @param formattedAddress la direccion
	 * @return cadena codigo postal
	 */
	public String buscaCodigoPostal(String formattedAddress) {
		
		//Lee la cadena en busca digitos y los guarda en lista de caracteres
		List<Character> lista = new ArrayList<>();
        for(int i = 0; i< formattedAddress.length(); i ++) {
            if(Character.isDigit(formattedAddress.charAt(i))) {
            	lista.add(formattedAddress.charAt(i));
            }
        }
        
        //Convierte la lista encontrada a String
        StringBuffer address = new StringBuffer();
        for (int i = 0; i <lista.size(); i++) {
        	address = address.append(lista.get(i));
        }
        
        //Si el arreglo tiene longitud 5, entonces lo retorna
        if(address.length() == 5) {
        	return address.toString();
        } else {
        	return null;
        }
	}
	
	/**
	 * Metodo que busca un codigo postal de 5 digitos de longitud dentro del
	 * arreglo de AddressComponent
	 * @param formattedAddress la direccion
	 * @return cadena codigo postal
	 */
	public String buscaCodigoPostal(List<AdressComponent> adressComponents) {
		
		List<Character> lista = new ArrayList<>();
		//Recorre el arreglo de direcciones
		//Lee la cadena en busca digitos y los guarda en lista de caracteres
		for(AdressComponent address : adressComponents) {
			if(address.getLongName().length() == 5) {
				
				for(int i = 0; i< address.getLongName().length(); i ++) {
					if(Character.isDigit(address.getLongName().charAt(i))) {
						lista.add(address.getLongName().charAt(i));
					}
				}
			}
		}

		StringBuffer address = new StringBuffer();
		if(lista.size() != 0) {
			//Convierte la lista encontrada a String
			for (int i = 0; i <lista.size(); i++) {
				address = address.append(lista.get(i));
			}
		}
        
        //Si el arreglo tiene longitud 5, entonces lo retorna
        if(address.length() == 5) {
        	return address.toString();
        } else {
        	return null;
        }
	}
	
}
