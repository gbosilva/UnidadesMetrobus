package mx.qro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.qro.model.Alcaldia;
import mx.qro.model.UbicacionMetrobus;

/**
* Queretaro Mexico<br>
* <br><b>Project:</b> apis-metrobus-service
* <br><b>Class:</b> IUbicacionMetrobusRepository.java
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
* @category Repository
*
*/
@Repository
public interface IUbicacionMetrobusRepository extends CrudRepository<UbicacionMetrobus, Long> {

	/**
	 * Metodo que consulta una lista de ubicaciones con estatus = 1, Activo
	 * @return Lista de ubicaciones
	 */
	@Query(value = "SELECT u FROM UbicacionMetrobus u "
			+ "WHERE u.vehicleCurrentStatus = 1 ")
	List<UbicacionMetrobus> buscaUnidadesDisponibles();

	/**
	 * Metodo que consulta un objeto de ubicacion
	 * @return objeto de ubicacion
	 */
	@Query(value = "SELECT u FROM UbicacionMetrobus u "
			+ "WHERE u.vehicleId =  :vehicleId")
	List<UbicacionMetrobus> buscaUnidadPorVehicleId(@Param("vehicleId") Integer vehicleId);

	/**
	 * Metodo que consulta unidades por alcaldia
	 * @return Lista unidades
	 */
	@Query(value = "SELECT u FROM UbicacionMetrobus u "
			+ "WHERE u.alcaldia =  (SELECT a.idAlcaldia FROM Alcaldia a "
			+ "WHERE a.nombre = :nombre)")
	List<UbicacionMetrobus> buscaUnidadPorAlcaldia(@Param("nombre") String nombre);
	
	/**
	 * Metodo que consulta las unidades que no tienen una alcaldia identificada
	 * @return Lista unidades
	 */
	@Query(value = "SELECT u FROM UbicacionMetrobus u "
			+ "WHERE u.alcaldia is null")
	List<UbicacionMetrobus> buscaUnidadesSinAlcaldia();
	
	/**
	 * Metodo para buscar alcaldias disponibles, es decir,
	 * busca todas las ubicaciones y revisa cuales ya tienen una alcaldia
	 * asignada 
	 * @return Lista de alcaldias
	 */
	@Query(value = "SELECT a FROM UbicacionMetrobus u "
			+ "JOIN u.alcaldia a "
			+ "WHERE a IS NOT NULL "
			+ "GROUP BY a.idAlcaldia")
	List<Alcaldia> encuentraAlcaldiasDisponibles();
	
	/**
	 * Metodo para buscar alcaldias disponibles, es decir,
	 * busca todas las ubicaciones y revisa cuales ya tienen una alcaldia
	 * asignada 
	 * @return Lista de alcaldias
	 */
	@Query(value = "SELECT COUNT(u) FROM UbicacionMetrobus u "
			+ "JOIN u.alcaldia a "
			+ "WHERE a.idAlcaldia =  :id")
	Integer cuentaAlcaldias(@Param("id") Integer id);
	
}
