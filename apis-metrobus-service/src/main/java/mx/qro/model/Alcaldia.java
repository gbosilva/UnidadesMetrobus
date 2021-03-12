package mx.qro.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Clase que contendra los datos referentes a las alcaldias 
 * @author Gabriel Silva
 *
 */
@Entity
@Table(name = "CT_ALCALDIAS")
@Getter
@Setter
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Alcaldia implements Serializable {

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = -6036161776187055031L;
	
	/**
	 * El idAlcaldia
	 */
	@Id
	@Column(name = "id_alcaldia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAlcaldia;
	
	/**
	 * El nombre de la Alcaldia
	 */
	@Column
	private String nombre;
	
	/**
	 * Coleccion de codigos popstales
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_alcaldia")
	private Set<CodigoPostal> codigosPostales;

}
