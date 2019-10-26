package co.com.prueba_cyxtera;

import java.util.ArrayList;

import co.com.prueba_cyxtera.logica.Operaciones;

public class TestOperaciones {

	public static void main(String[] args) {

		/*
		 * Prueba de la operacion matematica potenciacion
		 */
		
		System.out.println(" ************ Operacion Matematica Potenciacion *********************");
		Operaciones op = new Operaciones();
		
		ArrayList<Integer> lOperandosPotencia = new ArrayList<Integer>();
		lOperandosPotencia.add(2);
		lOperandosPotencia.add(3);
		lOperandosPotencia.add(2);

		int resultPotencia = op.potenciacion1(lOperandosPotencia);
		System.out.println("Resultado Potenciacion = " + resultPotencia);
		
		
		/*
		 * Prueba de la operacion matematica resta
		 */
		System.out.println(" ************ Operacion Matematica Resta *********************");
		Operaciones oResta = new Operaciones();
		
		ArrayList<Integer> lOperandosResta = new ArrayList<Integer>();
		lOperandosResta.add(12);
		lOperandosResta.add(5);
		lOperandosResta.add(4);
		lOperandosResta.add(3);
		lOperandosResta.add(4);

		
		int resultResta = oResta.resta(lOperandosResta);
		System.out.println("Resultado resta = " + resultResta);
		
		
		/*
		 * Prueba de la operacion matematica Suma
		 */
		System.out.println(" ************ Operacion Matematica Suma *********************");
		Operaciones oSuma = new Operaciones();
		
		ArrayList<Integer> lOperandosSuma = new ArrayList<Integer>();
		lOperandosSuma.add(12);
		lOperandosSuma.add(5);
		lOperandosSuma.add(4);
		lOperandosSuma.add(3);
		lOperandosSuma.add(4);
		
		int resultSuma = oSuma.suma(lOperandosSuma);
		System.out.println("Resultado Suma = " + resultSuma);
		
		/*
		 * Prueba de la operacion matematica multiplicacion
		 */
		System.out.println(" ************ Operacion Matematica Multiplicacion *********************");
		Operaciones oMultiplicacion = new Operaciones();
		
		ArrayList<Integer> lOperandosMultipli = new ArrayList<Integer>();
		lOperandosMultipli.add(12);
		lOperandosMultipli.add(5);
		lOperandosMultipli.add(4);
		lOperandosMultipli.add(1);
		
		int resultMultipli = oMultiplicacion.multiplicacion(lOperandosMultipli);
		System.out.println("Resultado Multiplicacion = " + resultMultipli);
		
		
		/*
		 * Prueba de la operacion matematica division
		 */
		System.out.println(" ************ Operacion Matematica Division *********************");
		Operaciones oDivision = new Operaciones();
		ArrayList<Double> lOperandosDivision = new ArrayList<Double>();
		lOperandosDivision.add(new Double(9));
		lOperandosDivision.add(new Double(2));
		lOperandosDivision.add(new Double(3));
		
		double resultDivision= oDivision.division(lOperandosDivision);
		System.out.println("Resultado Division = " + resultDivision);
		

	}

}
