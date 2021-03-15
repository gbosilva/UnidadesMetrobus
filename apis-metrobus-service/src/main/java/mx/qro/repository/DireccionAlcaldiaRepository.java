package mx.qro.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import mx.qro.model.Direccion;

/**
* Queretaro Mexico<br>
* <br><b>Project:</b> apis-metrobus-service
* <br><b>Class:</b> AlcaldiaRepository.java
* <br><b>Description:</b>
* Interface para consumir el api de geocoding
*
* @author FSW Jose Gabriel Silva Bustamante
* @company JGSB
* @created 7/03/2021
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0 7/03/2021 FSW joga Creacion de repositorio
*
* @category Repository
*
*/
@Repository
public class DireccionAlcaldiaRepository implements IDireccionAlcaldiaRepository {

	/**
	 * Variable LOGGER de tipo Logger
	 */
	public static final Logger LOG = 
			LoggerFactory.getLogger(DireccionAlcaldiaRepository.class);
	
	/**
	 * Objeto para consumo de recursos
	 */
	RestTemplate restTemplate = new RestTemplate();
	
	/**
	 * Metodo para hacer el consumo del api de geocoding
	 * @param key key para consumo del api
	 * @param request Objeto con los headers y el body
	 * 
	 * @retun response objeto con la respuesta de la consulta
	 */
	@Override
	public Direccion consultaAlcaldia(String url) {
		LOG.info("-->>	Inicia consumo del api");
		
		Direccion direccion = restTemplate.getForObject(url, Direccion.class);
		return direccion;
	}
}
