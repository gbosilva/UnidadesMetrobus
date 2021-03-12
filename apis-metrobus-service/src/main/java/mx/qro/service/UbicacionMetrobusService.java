package mx.qro.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.qro.model.Alcaldia;
import mx.qro.model.CodigoPostal;
import mx.qro.model.Direccion;
import mx.qro.model.Result;
import mx.qro.model.UbicacionMetrobus;
import mx.qro.repository.IAlcaldiaRepository;
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
	 * Metodo para buscar todas las ubidades disponibles
	 * @return Lista de objetos UbicacionMetrobus
	 */
	@Override
	public List<UbicacionMetrobus> buscaUnidadesDisponibles() {
		List<UbicacionMetrobus> unidadesList = 
				iUbicacionMetrobusRepository.buscaUnidadesDisponibles();
		LOGGER.info("-->>	Unidades encontradas: {}", unidadesList);
		return unidadesList;
	}
	
	/**
	 * Metodo para buscar una unidad filtrando por el id
	 * @param ubicacionMetrobus objeto de transporte de datos
	 * @return objeto UbicacionMetrobus
	 */
	@Override
	public UbicacionMetrobus buscaPorId(UbicacionMetrobus ubicacionMetrobus) {
		ubicacionMetrobus = iUbicacionMetrobusRepository
				.buscaUnidadPorId(ubicacionMetrobus.getId());
		LOGGER.info("-->>	Unidad localizada");
		return ubicacionMetrobus;
	}

	/**
	 * Metodo para buscar una lista de unidades que pertenezcan a la 
	 * alcaldia establecida por parametro ya sea por id o por nombre
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
		
		//Lista para guardado de direcciones --> FormattedAddress
		List<Direccion> direccionList = new ArrayList<>();
		
		//Lista para validacion previa al consumo del api
		List<UbicacionMetrobus> alcaldiasList = iUbicacionMetrobusRepository
				.buscaUnidadPorAlcaldia(nombre);
		if(alcaldiasList.size() == 0) {
			//Recorre la lista de unidades para obtener latitud y longitud
			recorreDireccionesDeUnidades(
					unidadesList, ubicacionesList, direccionList, nombre);
		} else {
			LOGGER.info("-->>	Unidades por alcaldia encontradas desde la bd");
			return alcaldiasList;
		}
		
		LOGGER.info("-->>	Unidades por alcaldia encontradas por consumo del api: {}", ubicacionesList);
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
			, List<UbicacionMetrobus> ubicacionesList
			, List<Direccion> direccionList, String nombre) {
		
		int consultasAPI = 0;
		int cuentaMatch = 0;
		for (UbicacionMetrobus ubicacionMetrobus : unidadesList) {
			consultasAPI ++;
			Direccion direccion = new Direccion();
			//Toma latitud y longitud y los pasa como parametro para
			//consultar la alcaldia en la que se ecuentra cada unidad
			direccion = iAlcaldiaService.consultaAlcaldiaPorAPI(
					ubicacionMetrobus.getGeographicPoint());
			//Guarda direcciones
			direccionList.add(direccion);
			LOGGER.info("-->> -->>	Valida Direcciones");
			for (Result result : direccion.getResults()) {
				
				LOGGER.info("-->> -->> -->>	Inicia validacion de nombre");
				//Si direccion contiene el nombre (rango de codigos postales) de la alcaldia
				//entonces agrega esa unidad a la lista de retorno
				if(buscaNombreEnDireccion(result.getFormattedAddress(), nombre)) {
//				if(result.getFormattedAddress().contains(nombre)) {
					ubicacionesList.add(ubicacionMetrobus);
					//Si encontro nombre, entonces busca el objeto alcaldia
					//y se lo agrega al objeto ubicacion para guardar en bd
					Alcaldia alcaldia = iAlcaldiaRepository.findByNombre(nombre);
					ubicacionMetrobus.setAlcaldia(alcaldia);
					iUbicacionMetrobusRepository.save(ubicacionMetrobus);
					cuentaMatch ++;
					LOGGER.info(" -->> -->> -->> -->>	Direccion guardada ");
					break;
				}
				LOGGER.info("-->> -->> -->>	Valor no valido: {}", result.getFormattedAddress());
				
			}
			LOGGER.info("-->> -->>	Validando siguiente direccion");
		}
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
	public Boolean buscaNombreEnDireccion(String formattedAddress, String nombre) {
		
		//Busca el codigo postal correspondiente a la alcaldia por nombre
		CodigoPostal postalCode = iAlcaldiaRepository.encuentraCPPorNombreAlcaldia(nombre);
		LOGGER.info("-->> -->>  Codigo Postal :{} de la alcaldia: {}", postalCode.toString(), nombre);
		
		//Codigo postal a validar
		String codigoPostal = buscaCodigoPostal(formattedAddress);
		if(codigoPostal != null) {
			LOGGER.info("-->> -->> Codigo Postal encontrado: {}", codigoPostal);
			
			Integer codigoPostalEnNumero = Integer.parseInt(codigoPostal);
			if(codigoPostalEnNumero >= Integer.parseInt(postalCode.getRangoInicial()) 
					&& codigoPostalEnNumero <= Integer.parseInt(postalCode.getRangoFinal())) {
				LOGGER.info("-->> -->> LOCALIZADO: {}", codigoPostal);
				return true;
			}
			
//			String alcaldia = iAlcaldiaRepository.encuentraAlcaldia(postalCode.getIdCodigoPostal());
//			LOGGER.info("-->> -->>	Alcaldia encontrada: {}", alcaldia);

		} else {
			return false;
		}
		return false;
	}

	/**
	 * Metodo que busca un codigo postal de 5 digitos de longitud dentro de una
	 * cadena de caracteres o una direccion 
	 * @param formattedAddress la direccion
	 * @return true or false
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
	
}
