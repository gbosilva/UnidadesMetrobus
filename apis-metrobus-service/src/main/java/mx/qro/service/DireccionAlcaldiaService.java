package mx.qro.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.qro.model.Direccion;
import mx.qro.repository.IDireccionAlcaldiaRepository;

/**
* Queretaro Mexico<br>
* <br><b>Project:</b> apis-metrobus-service
* <br><b>Class:</b> AlcaldiaService.java
* <br><b>Description:</b>
* Interface para consumir el api de geocoding
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
public class DireccionAlcaldiaService implements IDireccionAlcaldiaService {

	/**
	 * Variable LOGGER de tipo Logger
	 */
	public static final Logger LOG = 
			LoggerFactory.getLogger(DireccionAlcaldiaService.class);
	
	/**
	 * Es la instancia del repositorio de consultar direcciones
	 */
	@Autowired
	public IDireccionAlcaldiaRepository iAlcaldiaRepository;
	
	/**
	 * Es key del api
	 */
	@Value("${api.geocoding.uri}")
	private String uri;

	/**
	 * Es key del api
	 */
	@Value("${api.geocoding.key}")
	private String key;
	
	/**
	 * Metodo para hacer la consulta de una direccion buscando por
	 * latitud y longitud
	 * @return El objeto json con la respuesta
	 */
	@Override
	public Direccion consultaAlcaldiaPorAPI(String latlng) {

		final String url = uri + "latlng=" + latlng + "&key=" + key;
		Direccion direccion = iAlcaldiaRepository.consultaAlcaldia(url);

		return direccion;
	}
}
