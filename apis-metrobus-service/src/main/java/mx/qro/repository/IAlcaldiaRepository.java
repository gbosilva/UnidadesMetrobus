package mx.qro.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.qro.model.Alcaldia;
import mx.qro.model.CodigoPostal;

/**
* Queretaro Mexico<br>
* <br><b>Project:</b> apis-metrobus-service
* <br><b>Class:</b> IAlcaldiaRepository.java
* <br><b>Description:</b>
* Interface Repository para acceder a los datos de las alcaldias
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
public interface IAlcaldiaRepository extends CrudRepository<Alcaldia, Long> {

	/**
	 * Metodo para buscar una alcaldia por nombre
	 * @param nombre de la alcaldia
	 * @return alcaldia objeto de transporte
	 */
	Alcaldia findByNombre(String nombre);
	
	/**
	 * Metodo para buscar una alcaldia por codigo postal
	 * @param codigoPostal
	 * @return  alcaldia
	 */
	@Query(value = "SELECT a FROM Alcaldia a "
			+ "JOIN a.codigosPostales cp "
			+ "WHERE cp.idCodigoPostal = :codigoPostal")
	Alcaldia encuentraAlcaldiaPorCodigoPostal(@Param("codigoPostal") Integer codigoPostal);

	/**
	 * Metodo para buscar un codigo postal por nombre de alcaldia
	 * @param nombre
	 * @return
	 */
	@Query(value = "SELECT cp FROM Alcaldia a "
			+ "JOIN a.codigosPostales cp "
			+ "WHERE a.nombre = :nombre")
	CodigoPostal encuentraCPPorNombreAlcaldia(@Param("nombre") String nombre);
	
}
