package mascota;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorBDM {
	protected static final String DATABASE_FILE = "resources/db/databaseItems.db";
	protected static final String CONNECTION_STRING = "jdbc:sqlite:" + DATABASE_FILE;
	public void crearBBDD() {
		//Se abre la conexión y se obtiene el Statement
		//Al abrir la conexión, si no existía el fichero, se crea la base de datos
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING)) {
			
	        String sql = "CREATE TABLE IF NOT EXISTS ITEMS (\n"
	                   + " ID INTEGER PRIMARY KEY AUTOINCREMENT,\n"
	                   + " NOMBRE TEXT NOT NULL,\n"
	                   + " BENEFICIO TEXT NOT NULL,\n"
	                   + " PRECIO INT NOT NULL,\n"
	                   + " ALMACEN INT NOT NULL\n"
	                   + ");";
	        try(PreparedStatement stmt = con.prepareStatement(sql)){
	        if (!stmt.execute()) {
	        	System.out.println("- Se ha creado la tabla items");
	        }
	        }
		} catch (Exception ex) {
			System.err.format("* Error al crear la BBDD: %s", ex.getMessage());
			ex.printStackTrace();			
		}
	}
	
	public void cargarItems(ArrayList<Item> items) {

	    String sql = "INSERT INTO ITEMS (NOMBRE, BENEFICIO, PRECIO, ALMACEN) VALUES (?, ?, ?, ?)";

	    try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        for (Item i : items) {
	            stmt.setString(1, i.getNombre());
	            stmt.setString(2, i.getBeneficio().toString());
	            stmt.setInt(3, i.getPrecio());
	            stmt.setInt(4, i.getAlmacen());
	            stmt.executeUpdate();
	        }

	        System.out.println("Items cargados correctamente.");

	    } catch (SQLException ex) {
	        System.err.println("Error al cargar los items: " + ex.getMessage());
	        ex.printStackTrace();
	    }
	}

	
}
