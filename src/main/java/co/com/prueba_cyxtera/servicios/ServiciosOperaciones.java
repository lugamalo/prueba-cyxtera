package co.com.prueba_cyxtera.servicios;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import co.com.prueba_cyxtera.logica.Operaciones;
import co.com.prueba_cyxtera.utilidades.OperacionesEnum;

/**
 * Esta clase permite direccionar hacia que tipo de operacion se debe ejecutar
 * @author Luis Gabriel
 *
 */
public class ServiciosOperaciones {
	
	final static Logger logger = Logger.getLogger(ServiciosOperaciones.class);
	public int operando;
	 
	 private ArrayList<Integer> operandos;
	
	
	 public ServiciosOperaciones() {
		 operandos = new ArrayList<Integer>();
	 }
	
	  public ArrayList<Integer> agregarOperando(int numero) {
		  operandos.add(numero);
		  return operandos; 
	  }
	 
	/**
	 * Esta clase controla el acceso y enrutamiento a la logica que permite ejecutar las operaciones matematicas
	 * @param lOperandos se carga la lista de operandos o numeros que sirven para ejecutar la operacion
	 * @param eOperacion elige que tipo de operacion matematica se va ejecutar
	 * @return resultado de la operacion matematica
	 */
	public synchronized int realizarOperacion(ArrayList<Integer> lOperandos, OperacionesEnum eOperacion) {
		logger.info("Ingreso metodo realizarOperacion:: ");
		int resultado =0;
		switch(  eOperacion )
        {
            case SUMA:
            {
            	logger.info("Ingreso ejecutar operacion Suma: ");
            	Operaciones operaciones = new Operaciones();
            	resultado = operaciones.suma(lOperandos);
                break;
            }
            case RESTA:
            {
            	logger.info("Ingreso ejecutar operacion Rest: ");
            	Operaciones operaciones = new Operaciones();
            	resultado = operaciones.resta(lOperandos);			 
                break;
            }
            case MULTIPLICACION:
            {
            	logger.info("Ingreso ejecutar operacion Multiplicacion: ");
            	Operaciones operaciones = new Operaciones();
            	resultado = operaciones.multiplicacion(lOperandos);
                break;
            }
            case DIVISION:
            {
            	logger.info("Ingreso ejecutar operacion Division: ");
            	Operaciones operaciones = new Operaciones();
            	resultado = operaciones.division(lOperandos);

                break;
            }
            case POTENCIACION:
            {
            	logger.info("Ingreso ejecutar operacion Potenciacion: ");
            	Operaciones operaciones = new Operaciones();
            	resultado = operaciones.potenciacion(lOperandos);
                break;
            }
        }
		return resultado;
	}

}
