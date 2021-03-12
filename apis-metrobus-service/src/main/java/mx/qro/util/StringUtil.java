package mx.qro.util;

import java.text.Normalizer;

/**
* Queretaro Mexico<br>
* <br><b>Project:</b> apis-metrobus-service
* <br><b>Class:</b> StringUtil.java
* <br><b>Description:</b>
* Clase utilidad para componentes que necesiten ciertos metodos
* comunes de funcionalidad con <code>Strings</code>.
*
* @author FSW Jose Gabriel Silva Bustamante
* @company JGSB
* @created 8/03/2021
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0 8/03/2021 FSW joga Creacion de Controller
*
* @category Util
*
*/
public final class StringUtil {
	
	/**
	 * Constructor privado.
	 */
	private StringUtil() {
		super();
	}
	
	/**
	 * Concatena los objetos dados en una representacion de <code>String</code>.
	 * @param objs los objetos a concatenar
	 * @return el <code>String</code> generado
	 */
	public static String concat(Object ... objs) {
		if (objs == null) {
			return "null";
		}
		StringBuilder sBuilder = new StringBuilder();
		for (Object obj : objs) {
			sBuilder.append(obj);
		}
		return sBuilder.toString();
	}
		
	
	/**
	 * Metodo para parsear un valor numerico de cadena a intero
	 * @param cadena valor a parsear
	 * @return valor de tipo numero
	 */
	public static int parseStringToInt(String cadena) {
		int numero = 0;
		try {
			numero = Integer.parseInt(cadena);
		} catch (NumberFormatException nfe){
			numero = -1;
		}
		return numero;
	}
	
	/**
	 * Metodo para validar espacios en blanco
	 * @param string el objeto a validar
	 * @return validacion del objeto
	 */
	public static boolean isBlank(String string) {
	    return string == null || string.trim().isEmpty();
	}
	
	/**
	 * Quita acentos en una cadena
	 * @param texto cadena con acentos
	 * @return cadena sin acentos
	 */
	public static String cleanString(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return texto;
    }
	
}
