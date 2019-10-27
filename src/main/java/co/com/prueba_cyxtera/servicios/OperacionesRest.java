package co.com.prueba_cyxtera.servicios;

import static spark.Spark.get;
import static spark.Spark.port;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import co.com.prueba_cyxtera.utilidades.OperacionesEnum;
import co.com.prueba_cyxtera.utilidades.ValidarNumero;

/**
 * Esta clase define la implementacion de los servicios REST requeridos para probar la aplicacion de negocio
 * @author Luis Gabriel
 *
 */
public class OperacionesRest {

	public static ArrayList<Integer> operandos = new ArrayList<Integer>();
	private static final String SESSION_NAME = "listadoOperandos";
	private static final String SESSION_ID = "id";
	private static final String SESSION_RESULTADO = "resultado";
	private static final String SESSION_OPERACION = "operacion";
	private static final String SESSION_OPERANDO = "operando";
	private static final String SESSION_MENSAJES_ERROR = "mensajes";

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// Start embedded server at this port
		port(8081);
		// servicio rest encargado de destruir session
	    get("/clear", (request, response) -> {

            request.session().removeAttribute(SESSION_NAME);
            request.session().removeAttribute(SESSION_ID);
            request.session().removeAttribute(SESSION_OPERACION);
            request.session().removeAttribute(SESSION_OPERANDO);
            request.session().removeAttribute(SESSION_RESULTADO);
            request.session().removeAttribute(SESSION_MENSAJES_ERROR);
            operandos.clear();
            response.redirect("/menu");

            return null;

        });
	    // carga el menu principal de la aplicación
	    get("/menu", (request, response) -> {

            //String name = request.session().attribute(SESSION_NAME);
            String identificador = request.session().attribute(SESSION_ID);

            if (identificador == null) {
            	 Random random = new Random();
            	int id = random.nextInt(Integer.MAX_VALUE);
            	request.session().attribute(SESSION_ID, String.valueOf(id));
            	System.out.println("identificador " + id);
            	
            	StringBuffer sbMenuInicial = new StringBuffer();
            	sbMenuInicial.append("<html>\r\n" + 
            			"	<body>\r\n" + 
            			"	<h2>Bienvenidos a la aplicación de operaciones matematicas</h2>\r\n" + 
            			"	<h4>Digite un número y pulse el boton Agregar Operando. Para iniciar a usar la aplicación</h4>\r\n" +
            			"	<form action=\"http://localhost:8081/adicionOperando\" method=\"GET\">\r\n" + 
            			"		<h2>\r\n" + 
            			"		<input type=\"text\" name=\"operando\"/>\r\n" + 
            			"		<input type=\"submit\" value=\"Agregar Operando\"/>\r\n" + 
            			"		</h2>\r\n" + 
    					"	</form>\r\n" + 
    					"	</body>\r\n" + 
    					"</html>");
            	return sbMenuInicial;
            } else {
            	// se cargan variables de sesion para obtener la informacion
            	 String ultimoNumeroCargado = request.session().attribute(SESSION_OPERANDO);
            	 String ultimoTipoOperacion = request.session().attribute(SESSION_OPERACION);
            	 String ultimoResultado = request.session().attribute(SESSION_RESULTADO);
            	 String id1 = request.session().attribute(SESSION_ID);
            	 String mensajeError = request.session().attribute(SESSION_MENSAJES_ERROR);
            	 
            	Object oOperandos = request.session().attribute(SESSION_NAME);
            	StringBuffer sbOperandos = new StringBuffer();
            	if ( oOperandos != null ) {
	            	ArrayList<Integer> alOperandos = new ArrayList<Integer>();
	    			alOperandos = (ArrayList<Integer>) oOperandos;
	    			sbOperandos.append("	<ul>\r\n");
	    			 for (Iterator iterator = alOperandos.iterator(); iterator.hasNext();) {
						Integer iOperando = (Integer) iterator.next();
						sbOperandos.append("<li>"+ String.valueOf(iOperando) + "</li>\r\n"); 
					}
	    			 sbOperandos.append("	</ul>\r\n");
            	}
            	 StringBuffer sMenu = new StringBuffer();
            	 sMenu.append("<html>\r\n" + 
            	 		"	<body>\r\n" + 
            	 		"	<h2>Bienvenidos a la aplicación de operaciones matematicas</h2>\r\n" + 
            	 		"	<h4>Digite un número y pulse el boton Agregar Operando, tantas veces como desee</h4>\r\n");
		            	 if ( mensajeError != null ) {
		            		 sMenu.append("	<h4><p style=\"color:#FF0000\";>" + mensajeError + "</p></h4>\r\n"); 
		     			}
		            	 sMenu.append( 
            	 		"	<form action=\"/adicionOperando\" method=\"GET\">\r\n" + 
            	 		"		<h2>\r\n" + 
            	 		"		<input type=\"text\" name=\"operando\"/>\r\n" + 
            	 		"		<input type=\"submit\" value=\"Agregar Operando\"/>\r\n" + 
            	 		"		</h2>\r\n" + 
            	 		"	</form>\r\n" + 
            	 		"	<p><b>Operandos Cargados</b>\r\n");
            	 
            	 sMenu.append(sbOperandos);
            	 sMenu.append(
            	 		"	</p>\r\n" + 
            	 		"	\r\n" + 
            	 		"	<form action=\"/operaciones\" method=\"GET\">\r\n" + 
            	 		"  		<h4>Seleccione la operación a ejecutar y pulse el boton Realizar Operación</h4>\r\n" + 
            	 		"		<select name=\"operacion\">\r\n" + 
            	 		"    			<!-- Opciones de la lista -->\r\n" + 
            	 		"    			<option value=\"suma\">Suma</option>\r\n" + 
            	 		"    			<option value=\"resta\">Resta</option>\r\n" + 
            	 		"    			<option value=\"multiplicacion\">Multiplicación</option>\r\n" + 
            	 		"			<option value=\"division\">División</option>\r\n" + 
            	 		"			<option value=\"potenciacion\">Potenciación</option>\r\n" + 
            	 		"  		</select>\r\n" + 
            	 		"		<input type=\"submit\" value=\"Realizar Operacion\"/>\r\n" + 
            	 		"	</form>\r\n" + 
            	 		"	<p>\r\n" + 
            	 		"		Ultimo Número cargado ->" + ultimoNumeroCargado + "</br>  \r\n");
            	 		if ( ultimoResultado != null ) {
            	 			sMenu.append(
            	 					"		Resultado Acumulado ->" + ultimoResultado + "</br> \r\n" + 
            	 	            	"		Ultima operación ->" + ultimoTipoOperacion + "\r\n");		
            	 		}
            	 		sMenu.append(
            	 		"	</p>\r\n" + 
            	 		"	<form action=\"/clear\" method=\"GET\">\r\n" + 
            	 		"		<h4>Si desea destruir la session actual y terminar la aplicacion, pulse el boton destruir Session</h4>\r\n" + 
            	 		"		<input type=\"submit\" value=\"Destruir Session\"/>\r\n" + 
            	 		"	</form>\r\n" + 
            	 		"	</body>\r\n" + 
            	 		"</html>");
            	 
            	 return sMenu;
            }

        });
		// servicio rest de adicion de operando
		get("/adicionOperando", (request, response) -> {

			String operando = request.queryParams("operando");
			boolean esNumero = ValidarNumero.isNumeric(operando);
			String mensajeError= null;
			if ( !esNumero ) {
				mensajeError = "El caracter ingresado <b> "+ operando + " no es un número. Por favor ingresar solo numeros";
				request.session().attribute(SESSION_MENSAJES_ERROR, mensajeError);
				response.redirect("/menu");
				return null;
			}
			else {
				int numero = Integer.valueOf(operando);
				if (numero < 1) {
					mensajeError = "Los numeros ingresados deben ser positivos y mayores a 0 ";
					request.session().attribute(SESSION_MENSAJES_ERROR, mensajeError);
					response.redirect("/menu");
					return null;
				}
			}
			operandos.add(new Integer(operando));
			
			request.session().attribute(SESSION_OPERANDO, operando);
			request.session().attribute(SESSION_NAME, operandos);
			request.session().attribute(SESSION_MENSAJES_ERROR, null);
			
			response.redirect("/menu");
			return null;

		});
		// servicio rest de ejecucion de operacion
		get("/operaciones", (request, response) -> {

			String operacion = request.queryParams("operacion");
			System.out.println("operacion matematica " + operacion);
			Object oOperandos = request.session().attribute(SESSION_NAME);

			if (oOperandos == null) {

				return "<html><body>What's your name?: <form action=\"/entry\" method=\"POST\"><input type=\"text\" name=\"name\"/><input type=\"submit\" value=\"go\"/></form></body></html>";

			} else {
				ArrayList<Integer> lOp = new ArrayList<Integer>();
				lOp = (ArrayList<Integer>) oOperandos;

				// Invoca la ejecucion de las operaciones matematicas
				ServiciosOperaciones sOperaciones = new ServiciosOperaciones();
				int resultOperacion = 0;
				if (operacion.equals("suma")) {
					System.out.println("Ingreso suma");
					resultOperacion = sOperaciones.realizarOperacion(lOp, OperacionesEnum.SUMA);
					System.out.println("resultado de la suma =" + resultOperacion);
				}
				if (operacion.equals("multiplicacion")) {
					System.out.println("Ingreso multiplo");
					resultOperacion = sOperaciones.realizarOperacion(lOp, OperacionesEnum.MULTIPLICACION);
				}
				
				if (operacion.equals("resta")) {
					System.out.println("Ingreso a la Resta");
					resultOperacion = sOperaciones.realizarOperacion(lOp, OperacionesEnum.RESTA);
				}
				
				if (operacion.equals("division")) {
					System.out.println("Ingreso a division");
					resultOperacion = sOperaciones.realizarOperacion(lOp, OperacionesEnum.DIVISION);
				}
				
				if (operacion.equals("potenciacion")) {
					System.out.println("Ingreso a Potenciacion");
					resultOperacion = sOperaciones.realizarOperacion(lOp, OperacionesEnum.POTENCIACION);
				}
				
				// limpia el arreglo inicial de elementos y se prepara para ejecutar una nueva operacion matematica
				operandos.clear();
				operandos.add(new Integer(resultOperacion));
				request.session().attribute(SESSION_NAME, operandos);
				request.session().attribute(SESSION_RESULTADO, String.valueOf(resultOperacion));
				request.session().attribute(SESSION_OPERACION, operacion);
				
				response.redirect("/menu");
				return null;
			}
		});
	}

}
