package mx.qro.service;

import mx.qro.model.Direccion;

/**
* Queretaro Mexico<br>
* <br><b>Project:</b> apis-metrobus-service
* <br><b>Class:</b> IAlcaldiaService.java
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
* @category Interface
*
*/
public interface IDireccionAlcaldiaService {

	/**
	 * Metodo para hacer la consulta de una direccion buscando por
	 * latitud y longitud
	 * @param latlng latitud y longitud
	 * @return El objeto json con la respuesta
	 */
	Direccion consultaAlcaldiaPorAPI(String latlng);
}
