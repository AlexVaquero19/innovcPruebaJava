import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class Conexion {
	public static Connection conectar() {
		Connection con = null;
		
		String password = "root";
		String usuario = "root";
		String url = "jdbc:mysql://localhost:3306/user?user=" + usuario
				+ "&password=" + password;
		try {
			con = DriverManager.getConnection(url);
			if (con != null) {
				System.out.println("Conectado");
			}
		} catch (SQLException e) {
			System.out.println("Error en la Conexeión");
			e.printStackTrace();
		}
		return con;
	}
}