import java.util.List;

public interface IUser {	
	public boolean registrar(User user);
	public List<User> obtener(User user);
    public List<User> obtenerTodos();
	public boolean actualizar(User user);
	public boolean eliminar(User user);
}