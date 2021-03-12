package mx.qro.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Clase que contendra los datos referentes a las alcaldias 
 * @author Gabriel Silva
 *
 */
@Entity
@Table(name = "TB_UBICACIONES")
@Getter
@Setter
@ToString
public class UbicacionMetrobus implements Serializable {

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 2364456598555946070L;

	/**
	 * El id
	 */
	@Id
	@Column(name = "id")
	private Long id;
	
	/**
	 * Fecha de actualizacion
	 */
	@Column(name = "date_updated")
	private String dateUpdated;
	
	/**
	 * El id del vehiculo
	 */
	@Column(name = "vehicle_id")
	private Integer vehicleId;
	
	/**
	 * La etiqueta del vehiculo
	 */
	@Column(name = "vehicle_label")
	private Integer vehicleLabel;
	
	/**
	 * El estatus del vehiculo
	 */
	@Column(name = "vehicle_current_status")
	private Integer vehicleCurrentStatus;
	
	/**
	 * La latitud de la unidad
	 */
	@Column(name = "position_latitude")
	private Double positionLatitude;
	
	/**
	 * La longitud de la unidad
	 */
	@Column(name = "position_longitude")
	private Double positionLongitude;
	
	/**
	 * El punto geografico
	 */
	@Column(name = "geographic_point")
	private String geographicPoint;
	
	/**
	 * La posicion de velocidad
	 */
	@Column(name = "position_speed")
	private Integer positionSpeed;
	
	/**
	 * El odometro
	 */
	@Column(name = "position_odometer")
	private Integer positionOdometer;
	
	/**
	 * Objeto Status
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_alcaldia", referencedColumnName = "id_alcaldia")
	private Alcaldia alcaldia;
}
