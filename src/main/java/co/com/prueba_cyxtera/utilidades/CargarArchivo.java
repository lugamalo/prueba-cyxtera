package co.com.prueba_cyxtera.utilidades;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CargarArchivo {
	
	public Properties leerArchivo() {
		Properties prop = new Properties();
		try (InputStream input = CargarArchivo.class.getClassLoader().getResourceAsStream("config.properties")) {
	        if (input == null) {
	            System.out.println("No puedo localizar el achivo");
	            return null;
	        }

	        //load a properties file from class path, inside static method
	        prop.load(input);

	        //get the property value and print it out
	        System.out.println(prop.getProperty("db.url"));

	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
		return prop;
	}


}
