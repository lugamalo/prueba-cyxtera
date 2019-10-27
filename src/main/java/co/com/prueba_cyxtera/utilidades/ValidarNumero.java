package co.com.prueba_cyxtera.utilidades;

import org.apache.log4j.Logger;

/**
 * Esta clase utilitaria permite validar si el numero ingresado es un numero
 * @author Luis Gabriel
 *
 */
public class ValidarNumero {
	
	final static Logger logger = Logger.getLogger(ValidarNumero.class);
	
	public static boolean isNumeric(String operando) {
		logger.info("Ingreso metodo isNumeric::" + operando);
        boolean resultado;

        try {
            Integer.parseInt(operando);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

}
