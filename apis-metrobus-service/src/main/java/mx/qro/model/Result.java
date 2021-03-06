package mx.qro.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* Queretaro Mexico<br>
* <br><b>Project:</b> apis-metrobus-service
* <br><b>Class:</b> Result.java
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
public class Result implements Serializable {

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = -307925579925986339L;
	
	/**
	 * Arreglo de direcciones
	 */
	@JsonProperty("address_components")
	private List<AdressComponent> adressComponents;
	
	/**
	 * La direccion en formato
	 */
	@JsonProperty("formatted_address")
	private String formattedAddress;
	
}
