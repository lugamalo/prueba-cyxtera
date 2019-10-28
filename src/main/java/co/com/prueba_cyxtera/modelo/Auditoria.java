package co.com.prueba_cyxtera.modelo;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.log4j.Logger;

/**
 * Esta clase contiene todos los elementos requeridos para insertar la transaccionalidad de las operaciones en la base de datos
 * @author Luis Gabriel
 *
 */
public class Auditoria {
	
	final static Logger logger = Logger.getLogger(Auditoria.class);
	
	private int idSession;
	private String fechaCreacion;
	private int resultadoOperacion;
	private String tipoOperacion;
	private String operacion;
	private ArrayList<Integer> listadoOperandos;
	

	public ArrayList<Integer> getListadoOperandos() {
		return listadoOperandos;
	}
	public void setListadoOperandos(ArrayList<Integer> listadoOperandos) {
		this.listadoOperandos = listadoOperandos;
	}
	public int getIdSession() {
		return idSession;
	}
	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public int getResultadoOperacion() {
		return resultadoOperacion;
	}
	public void setResultadoOperacion(int resultadoOperacion) {
		this.resultadoOperacion = resultadoOperacion;
	}
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	
	/**
	 * Este metodo permite realizar la insercion de las transacciones en la base de datos
	 * @param audit
	 * @param simboloOperacion
	 * @return
	 */
	public synchronized int insertarAuditoria(Auditoria audit, String simboloOperacion) {
		logger.info("insertarAuditoria ");
		ArrayList<Integer> lOperandos = new ArrayList<Integer>();
		lOperandos = audit.getListadoOperandos();
		StringBuffer sbOperandos = new StringBuffer();
		for (Object element : lOperandos) {
			Integer integer = (Integer) element;
			sbOperandos.append(String.valueOf(integer) + simboloOperacion);
			
		}
		// Info insertar en la auditoria
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		logger.info("Elementos de auditoria");
		logger.info("Id session " + audit.getIdSession());
		audit.setFechaCreacion(timestamp.toString());
		logger.info("Fecha " + timestamp );
		logger.info("Tipo Operacion " + audit.getTipoOperacion() );
		audit.setOperacion(sbOperandos.toString());
		logger.info("Operacion " + audit.getOperacion() );
		logger.info("Resultado de la operacion " + audit.getResultadoOperacion());
		
		// insertar informacion de auditoria en la base de datos
		BaseDatosJDBC app = new BaseDatosJDBC();
		app.insert(audit);
		return 1;
	}
}
