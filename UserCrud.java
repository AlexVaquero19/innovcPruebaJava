import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
public class UserCrud implements IUser {	
	
	@Override
	public boolean registrar(User user) {
		boolean registrar = false;
		
		Statement stm= null;
		Connection con=null;
		
		String sql="INSERT INTO user values (NULL,'"+user.getNombre()+"','"+user.getBirthdate()+"')";
		
		try {			
			con=Conexion.conectar();
			stm= con.createStatement();
			stm.execute(sql);
			registrar=true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: al Registrar User");
			e.printStackTrace();
		}
		return registrar;
	}
 
	@Override
	public List<User> obtenerTodos(User user) {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM USER ORDER BY ID";
		
		List<User> listaUsers= new ArrayList<User>();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				User c=new User();
				c.setId(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setBirthdate(rs.getDate(3));
				listaUsers.add(c);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error al Devolver Users");
			e.printStackTrace();
		}
		
		return listaUsers;
	}

    @Override
	public List<User> obtener(User user) {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM USER WHERE ID="+user.getId();
		
		List<User> listaUsers= new ArrayList<User>();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				User c=new User();
				c.setId(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setBirthdate(rs.getDate(3));
				listaUsers.add(c);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error al Devolver Users");
			e.printStackTrace();
		}
		
		return listaUsers;
	}
 
	@Override
	public boolean actualizar(User user) {
		Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
				
		String sql="UPDATE USER SET nombres='"+user.getNombre()+"', apellidos='"+user.getApellido()+"' birthdate='"+user.getBirthdate()+"'" +" WHERE ID="+user.getId();
		try {
			connect=Conexion.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			actualizar=true;
		} catch (SQLException e) {
			System.out.println("Error al actualizar user");
			e.printStackTrace();
		}		
		return actualizar;
	}
 
	@Override
	public boolean eliminar(User user) {
		Connection connect= null;
		Statement stm= null;
		
		boolean eliminar=false;
				
		String sql="DELETE FROM USER WHERE ID="+user.getId();
		try {
			connect=Conexion.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			eliminar=true;
		} catch (SQLException e) {
			System.out.println("Error al eliminar user");
			e.printStackTrace();
		}		
		return eliminar;
	}
 
}