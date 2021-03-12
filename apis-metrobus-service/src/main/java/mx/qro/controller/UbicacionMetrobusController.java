package mx.qro.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.qro.model.UbicacionMetrobus;
import mx.qro.service.IUbicacionMetrobusService;
import mx.qro.util.StringUtil;

/**
* Queretaro Mexico<br>
* <br><b>Project:</b> apis-metrobus-service
* <br><b>Class:</b> UbicacionMetrobusController.java
* <br><b>Description:</b>
* Clase controladora para manejo de ubicaciones de unidades
*
* @author FSW Jose Gabriel Silva Bustamante
* @company JGSB
* @created 7/03/2021
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0 7/03/2021 FSW joga Creacion de Controller
*
* @category Controller
*
*/
@RestController
@RequestMapping("/ubicaciones")
public class UbicacionMetrobusController {

	/**
	 * Variable LOGGER de tipo Logger
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(UbicacionMetrobusController.class);
	
	/**
	 * Es la instancia del servicio de ubicaciones
	 */
	@Autowired
	private IUbicacionMetrobusService iUbicacionMetrobusService;
	
	/**
	 * Metodo para consultar todas las Unidades disponibles
	 * @return ResponseEntity<Object> con la lista del objeto
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET
			, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> consultaCuentas(){
		LOGGER.info("-->	Operacion consultar unidades disponibles iniciada");
		//Objeto de respuesta
		ResponseEntity<Object> response = null;
		//Objeto para estatus Http
		HttpStatus estatus = HttpStatus.NOT_FOUND;
		List<UbicacionMetrobus> listResult = new ArrayList<UbicacionMetrobus>();
		listResult = iUbicacionMetrobusService.buscaUnidadesDisponibles();
		if(listResult != null) {
			estatus = HttpStatus.OK;
			//Se inicializa el objeto de respuesta
			response = ResponseEntity.status(estatus).body(listResult);
		}
		return response;
	}
	
	/**
	 * Metodo para consultar el historial de una unidad
	 * @param id identificador unico de la unidad
	 * @return ResponseEntity<Object> con el objeto
	 */
	@RequestMapping(value = "/unidad/{id}", method = RequestMethod.GET
			, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> consultaUnidad(
			@PathVariable(value = "id") Long id) {
		//Objeto de respuesta
		ResponseEntity<Object> response = null;
		LOGGER.info("-->	Operacion consultar unidad por id iniciada");
		//Objeto para estatus Http
		HttpStatus estatus = null;
		//Objeto AccountDTO
		UbicacionMetrobus unidad = new UbicacionMetrobus();
		unidad.setId(id);
		unidad = iUbicacionMetrobusService.buscaPorId(unidad);
		if(unidad.getId() != null) {
			//Estatus http ok
			estatus = HttpStatus.OK;
			response = ResponseEntity.status(estatus).body(unidad);
			return response;
		}
		return response;
	}
	
	/**
	 * Metodo para consultar las unidades dentro de una alcaldia
	 * @param id de la alcaldia
	 * @param nombre nombre de la alcaldia
	 * @return ResponseEntity<Object> con el objeto
	 */
	@RequestMapping(value = "/alcaldia/{nombre}",method = RequestMethod.GET
			, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> consultaPorFiltro(
			@PathVariable(value = "nombre") String nombre) {
		LOGGER.info("Operacion consultar unidades por alcaldia iniciada");
		//Objeto de respuesta
		ResponseEntity<Object> response = null;
		List<UbicacionMetrobus> unidadesList = new ArrayList<>();
		unidadesList = iUbicacionMetrobusService
				.buscaPorNombre(StringUtil.cleanString(nombre));
		if(unidadesList.size() != 0) {
			response = ResponseEntity.status(HttpStatus.OK).body(unidadesList);
			return response;
		}
		return response;
	}
}
