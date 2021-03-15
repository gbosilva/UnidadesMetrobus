package mx.qro.model.Enum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.Getter;
import lombok.ToString;

/**
* Queretaro Mexico<br>
* <br><b>Project:</b> apis-metrobus-service
* <br><b>Class:</b> Type.java
* <br><b>Description:</b>
* Clase que contendra los datos referentes a la direccion
*
* @author FSW Jose Gabriel Silva Bustamante
* @company JGSB
* @created 14/03/2021
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0 14/03/2021 FSW joga Creacion de enum
*
* @category Enum
*
*/
@Getter
@ToString
//@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Type {
	
//	route,
//	political,
//	sublocality,
//	sublocality_level_1,
//	locality,
//	postal_code;
	
	ROUTE("route"),
	POLITICAL("political"),
	SUBLOCALITY("sublocality"),
	SUBLOCALITY_LEVEL_1("sublocality_level_1"),
	LOCALITY("locality"),
	POSTAL_CODE("postal_code");
	
	private String type;
	
	private Type(String type) {
		this.type = type;
	}
//	
//	@JsonValue
//	public String getType() {
//		return type;
//	}
	
	@JsonCreator
	public static Type fromNode(JsonNode node) {
		if (!node.has("name"))
			return null;
		
		String name = node.get("name").asText();
		
		return Type.valueOf(name);
	}
	
}
