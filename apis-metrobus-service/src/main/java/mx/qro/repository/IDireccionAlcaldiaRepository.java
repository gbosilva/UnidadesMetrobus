package mx.qro.repository;

import mx.qro.model.Direccion;

/**
* Queretaro Mexico<br>
* <br><b>Project:</b> apis-metrobus-service
* <br><b>Class:</b> IAlcaldiaRepository.java
* <br><b>Description:</b>
* Interface para consumir el api de geocoding
*
* @author FSW Jose Gabriel Silva Bustamante
* @company JGSB
* @created 7/03/2021
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0 7/03/2021 FSW joga Creacion de interface
*
* @category Interface
*
*/
public interface IDireccionAlcaldiaRepository {

	/**
	 * Metodo para hacer el consumo del api de geocoding
	 * @param key key para consumo del api
	 * @param request Objeto con los headers y el body
	 * 
	 * @retun response objeto con la respuesta de la consulta
	 */
	Direccion consultaAlcaldia(String url);
}
