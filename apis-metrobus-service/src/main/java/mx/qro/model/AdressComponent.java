package mx.qro.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import mx.qro.model.Enum.Type;

/**
* Queretaro Mexico<br>
* <br><b>Project:</b> apis-metrobus-service
* <br><b>Class:</b> AdressComponent.java
* <br><b>Description:</b>
* Clase que contendra los datos referentes a la direccion
*
* @author FSW Jose Gabriel Silva Bustamante
* @company JGSB
* @created 14/03/2021
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0 14/03/2021 FSW joga Creacion de entity
*
* @category Entity
*
*/
@Getter
@Setter
@ToString
public class AdressComponent implements Serializable {
	
	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 2608007267600265820L;
	
	/**
	 * Nombre largo
	 */
	@JsonProperty("long_name")
	private String longName;
	
	/**
	 * Nombre corto
	 */
	@JsonProperty("short_name")
	private String shortName;
	
	/**
	 * Enum types
	 */
	private List<Type> types;

}
