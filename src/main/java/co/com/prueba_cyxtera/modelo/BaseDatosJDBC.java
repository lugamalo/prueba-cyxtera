package co.com.prueba_cyxtera.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import co.com.prueba_cyxtera.utilidades.CargarArchivo;

public class BaseDatosJDBC {
	final static Logger logger = Logger.getLogger(BaseDatosJDBC.class);

	/**
	 * Connect to the test.db database
	 *
	 * @return the Connection objectO
	 */
	private Connection connect() {
		logger.info("Construye la cadena de conexion con la BD Sqlite ");
		CargarArchivo propiedad = new CargarArchivo();
		Properties p = propiedad.leerArchivo();
		String path= p.getProperty("db.url");
		String url = "jdbc:sqlite:" + path;
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	/**
	 * Este metodo inserta la auditoria de las operaciones matematicas
	 * 
	 * @param audit
	 */
	public void insert(Auditoria audit) {
		logger.info("ingreso metodo insert datos auditoria");
		String sql = "INSERT INTO auditoria_operaciones(id_session, fecha_operacion, tipo_operacion, operacion,resultado ) VALUES(?,?,?,?,?)";

		try {
			Connection conn = this.connect();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, audit.getIdSession());
			pstmt.setString(2, audit.getFechaCreacion());
			pstmt.setString(3, audit.getTipoOperacion());
			pstmt.setString(4, audit.getOperacion());
			pstmt.setInt(5, audit.getResultadoOperacion());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Este metodo obtiene un registro dado el id de session
	 * @param id identificador de session
	 * @return objeto auditoria
	 */
	public Auditoria getAuditoriaByID(int id) {
		logger.info("ingreso metodo obtener datos auditoria por id");
		String sql = "SELECT * FROM auditoria_operaciones where id_session=?";
		Auditoria audit = new Auditoria();
		try {
			Connection conn = this.connect();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				audit.setFechaCreacion(rs.getString("fecha_operacion"));
				audit.setTipoOperacion(rs.getString("tipo_operacion"));
				audit.setOperacion(rs.getString("operacion"));
				audit.setResultadoOperacion(rs.getInt("resultado"));
				System.out.println(rs.getInt("id_session") + "\t" + rs.getString("fecha_operacion") + "\t"
						+ rs.getString("tipo_operacion") + "\t" + rs.getString("operacion") + "\t"
						+ rs.getInt("resultado"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return audit;
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		BaseDatosJDBC app = new BaseDatosJDBC();
		Auditoria a = app.getAuditoriaByID(1483724044);
		System.out.println("Fecha de creacion " + a.getFechaCreacion());
		System.out.println("Tipo de Operacion " + a.getTipoOperacion());
		System.out.println("Operacion " + a.getOperacion());
		System.out.println("Resultado " + a.getResultadoOperacion());
	}

}
