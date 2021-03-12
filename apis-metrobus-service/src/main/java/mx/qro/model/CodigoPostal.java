package mx.qro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Clase que contendra los datos referentes a los codigos postales 
 * @author Gabriel Silva
 *
 */
@Entity
@Table(name = "CT_CP")
@Getter
@Setter
@ToString
public class CodigoPostal implements Serializable {

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = -6831349265041516145L;

	/**
	 * El idCodigoPostal
	 */
	@Id
	@Column(name = "id_codigo_postal")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCodigoPostal;
	
	/**
	 * Rango inicial del codigo postal
	 */
	@Column(name = "rango_inicial")
	private String rangoInicial;

	/**
	 * Rango final del codigo postal
	 */
	@Column(name = "rango_final")
	private String rangoFinal;

}
