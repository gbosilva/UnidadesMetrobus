package mx.qro.model;

import java.io.Serializable;
import java.util.List;

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
public class Direccion implements Serializable {

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 341700927361586970L;

	/**
	 * Contenido con la direccion
	 */
	private List<Result> results;
}
