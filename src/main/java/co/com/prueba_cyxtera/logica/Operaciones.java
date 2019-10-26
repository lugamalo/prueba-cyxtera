package co.com.prueba_cyxtera.logica;

import java.util.ArrayList;

/**
 * 
 * @author Luis Gabriel
 *
 */

public class Operaciones {
	
	public int suma(ArrayList<Integer> lOperandos) {
		lOperandos.forEach((n) -> System.out.println(n));
    	int resultado = lOperandos.stream()
    			  .reduce(0, (a, b) -> a + b);
    	return resultado; 
	}
	
	public int resta(ArrayList<Integer> lOperandos) {
		int resultado = 0;
		int count =0;
    	for (int i = 0; i < lOperandos.size(); i++) {
			System.out.println(lOperandos.get(i));
			if ( count == 0 ) {
				resultado = lOperandos.get(i);
				count++;
			}
			else {
				Integer n = lOperandos.get(i);
    			resultado = resultado - n;
			}
    	}	
    	return resultado;
	}
	
	public int multiplicacion(ArrayList<Integer> lOperandos) {
		lOperandos.forEach((n) -> System.out.println(n));
    	int resultado = lOperandos.stream()
    			  .reduce(1, (a, b) -> a * b);
    	return resultado; 
	}
	
	public double potenciacion(ArrayList<Double> lOperandos) {
		double resultado = 0;
		int count =0;
    	for (int i = 0; i < lOperandos.size(); i++) {
			System.out.println(lOperandos.get(i));
			if ( count == 0 ) {
				resultado = lOperandos.get(i);
				count++;
			}
			else {
				double n = lOperandos.get(i);
    			resultado = Math.pow(resultado,n);
			}
    	}
    	return resultado;
	}
	
	public double division(ArrayList<Double> lOperandos) {
		double resultado = 0;
		int count =0;
    	for (int i = 0; i < lOperandos.size(); i++) {
			System.out.println(lOperandos.get(i));
			if ( count == 0 ) {
				resultado = lOperandos.get(i);
				count++;
			}
			else {
				double n = lOperandos.get(i);
    			resultado = resultado / n;
			}
    	}
    	return resultado;
	}
	
	public int potenciacion1(ArrayList<Integer> lOperandos) {
		int resultado = 0;
		int count =0;
    	for (int i = 0; i < lOperandos.size(); i++) {
			System.out.println(lOperandos.get(i));
			if ( count == 0 ) {
				resultado = lOperandos.get(i);
				count++;
			}
			else {
				int n = lOperandos.get(i);
				//System.out.println("obtien n" + n);
				resultado = potencia(resultado, n);
			}
    	}
    	return resultado;
	}
	
	 static int potencia(int base, int exponente){
	        int result;
	        if(exponente == 0){
	            result = 1;
	        }
	        else{
	            result = base * potencia(base, exponente - 1);
	        }      
	        return result;
	    }

}
