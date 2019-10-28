package co.com.prueba_cyxtera.utilidades;

/**
 * Enumeraciones para elegir el tipo de operacion matematica
 */
public enum OperacionesEnum {
	
	 /**
     * Representa la operacion de suma.
     */
    SUMA("+"),

    /**
     * Representa la operacion de resta.
     */
    RESTA("-"),

    /**
     * Representa la operacion de multiplicacion.
     */
    MULTIPLICACION("*"),
    
    /**
     * Representa la operacion de division.
     */
    DIVISION("/"),
    
    /**
     * Representa la operacion de potenciacion.
     */
    POTENCIACION("^");
	
	private String simbolo;
	
	OperacionesEnum(String simbolo){
		this.simbolo = simbolo;
	}
	public String getSimbolo() {
		return simbolo;
	}
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	
	

}
