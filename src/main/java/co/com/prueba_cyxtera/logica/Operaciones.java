package co.com.prueba_cyxtera.logica;

import java.util.ArrayList;

/**
 * Esta clase ejecuta la implementacion de las operaciones matematicas
 * 
 * @author Luis Gabriel
 *
 */

public class Operaciones {

	/**
	 * Este metodo realiza la suma de operandos dado un arreglo de numeros
	 * @param lOperandos
	 * @return Resultado de la suma de una lista de numeros
	 */
	public synchronized int suma(ArrayList<Integer> lOperandos) {
		lOperandos.forEach((n) -> System.out.println(n));
		int resultado = lOperandos.stream().reduce(0, (a, b) -> a + b);
		return resultado;
	}

	/**
	 * Este metodo realiza la resta de operandos dado un arreglo de numeros
	 * @param lOperandos
	 * @return Resultado de la resta de una lista de numeros
	 */
	public synchronized int resta(ArrayList<Integer> lOperandos) {
		int resultado = 0;
		int count = 0;
		for (int i = 0; i < lOperandos.size(); i++) {
			System.out.println(lOperandos.get(i));
			if (count == 0) {
				resultado = lOperandos.get(i);
				count++;
			} else {
				Integer n = lOperandos.get(i);
				resultado = resultado - n;
			}
		}
		return resultado;
	}

	/**
	 * Este metodo realiza la multiplicacion de operandos dado un arreglo de numeros
	 * 
	 * @param lOperandos
	 * @return Resultado de la multiplicacion de una lista de numeros
	 */
	public synchronized int multiplicacion(ArrayList<Integer> lOperandos) {
		lOperandos.forEach((n) -> System.out.println(n));
		int resultado = lOperandos.stream().reduce(1, (a, b) -> a * b);
		return resultado;
	}

	/**
	 * Este metodo realiza la division de operandos dado un arreglo de numeros
	 * 
	 * @param lOperandos
	 * @return
	 */
	public synchronized double division(ArrayList<Double> lOperandos) {
		double resultado = 0;
		int count = 0;
		for (int i = 0; i < lOperandos.size(); i++) {
			System.out.println(lOperandos.get(i));
			if (count == 0) {
				resultado = lOperandos.get(i);
				count++;
			} else {
				double n = lOperandos.get(i);
				resultado = resultado / n;
			}
		}
		return resultado;
	}

	/**
	 * Este metodo realiza la potenciacion de operandos dado un arreglo de numeros
	 * 
	 * @param lOperandos
	 * @return Resultado de la potenciacion de una lista de numeros
	 */
	public synchronized int potenciacion(ArrayList<Integer> lOperandos) {
		int resultado = 0;
		int count = 0;
		for (int i = 0; i < lOperandos.size(); i++) {
			System.out.println(lOperandos.get(i));
			if (count == 0) {
				resultado = lOperandos.get(i);
				count++;
			} else {
				int n = lOperandos.get(i);
				// System.out.println("obtien n" + n);
				resultado = potencia(resultado, n);
			}
		}
		return resultado;
	}
	
	/**
	 * Este metodo recursivo realiza el calculo de obtener la potencia de un numero a partir de una base 
	 */
	static int potencia(int base, int exponente) {
		int result;
		if (exponente == 0) {
			result = 1;
		} else {
			result = base * potencia(base, exponente - 1);
		}
		return result;
	}

}
