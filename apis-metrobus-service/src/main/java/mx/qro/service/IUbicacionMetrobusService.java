package mx.qro.service;

import java.util.List;

import mx.qro.model.UbicacionMetrobus;

/**
* Queretaro Mexico<br>
* <br><b>Project:</b> apis-metrobus-service
* <br><b>Class:</b> IUbicacionMetrobusService.java
* <br><b>Description:</b>
* Interface Repository para acceder a los datos de las ubicaciones
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
public interface IUbicacionMetrobusService {

	/**
	 * Metodo para buscar todas las ubidades disponibles
	 * @return Lista de objetos UbicacionMetrobus
	 */
	List<UbicacionMetrobus> buscaUnidadesDisponibles();
	
	/**
	 * Metodo para buscar una unidad filtrando por el id
	 * @param ubicacionMetrobus objeto de transporte de datos
	 * @return objeto UbicacionMetrobus
	 */
	UbicacionMetrobus buscaPorId(UbicacionMetrobus ubicacionMetrobus);

	/**
	 * Metodo para buscar una lista de unidades que pertenezcan a la 
	 * alcaldia establecida por parametro ya sea por id o por nombre
	 * de la alcaldia
	 * @param nombre de la alcaldia a buscar
	 * @return objeto UbicacionMetrobus
	 */
	List<UbicacionMetrobus> buscaPorNombre(String nombre);
}
