package mx.qro.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.qro.model.CodigoPostal;

/**
* Queretaro Mexico<br>
* <br><b>Project:</b> apis-metrobus-service
* <br><b>Class:</b> ICodigoPostalRepository.java
* <br><b>Description:</b>
* Interface Repository para acceder a los datos de los codigos postales
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
public interface ICodigoPostalRepository extends CrudRepository<CodigoPostal, Long> {

	/**
	 * Metodo para buscar un codigo postal
	 * @param codigoPostal
	 * @return
	 */
	@Query(value = "SELECT distinct(cp.idCodigoPostal) FROM CodigoPostal cp "
			+ "WHERE cp.rangoInicial < :codigoPostal "
			+ "AND cp.rangoFinal > :codigoPostal")
	CodigoPostal encuentraCP(@Param("codigoPostal") String codigoPostal);
	
}
