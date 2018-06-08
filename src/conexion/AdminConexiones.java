package conexion;

import java.io.IOException;
import java.util.Map;
import java.util.Vector;

import almacenamiento.AlmacenamientoConexiones;
import controlador.AdminInfo;
import controlador.AdminMensajes;
import controlador.AdminTabla;

public class AdminConexiones {

	private static AdminConexiones instancia = null;
	private AlmacenamientoConexiones almacenamiento;
	private AdminMensajes adminMensajes = AdminMensajes.getInstancia();
	
	private AdminConexiones() {
		almacenamiento = new AlmacenamientoConexiones();
	}
	
	public static AdminConexiones getInstancia() {
		if(instancia == null) {
			instancia = new AdminConexiones();
		}
		return instancia;
	}
	
	public void guardarConexion(String nombre, String ip, String id) {
		almacenamiento.guardarConexion(nombre, ip, id);
	}
	
	public String[] getNombreConexiones() {
		Map<String, Vector<String>> mapeo = almacenamiento.getConexiones();
		String[] conexiones = new String[mapeo.size()];
		int i = 0;
		for(String clave: mapeo.keySet()) {
			conexiones[i] = clave;
			i++;
		}
		return conexiones;
	}

	public Vector<String> getConexion(String nombreConexion) {
		Map<String, Vector<String>> mapeo = almacenamiento.getConexiones();
		return mapeo.get(nombreConexion);
		
	}

}
