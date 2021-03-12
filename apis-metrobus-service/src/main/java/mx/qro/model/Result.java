package mx.qro.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Clase que contendra los datos referentes a la direccion
 * @author Gabriel Silva
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
	 * La direccion en formato
	 */
	@JsonProperty("formatted_address")
	private String formattedAddress;
	
}
