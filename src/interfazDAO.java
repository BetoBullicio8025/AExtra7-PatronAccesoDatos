import java.io.ObjectStreamException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface interfazDAO {
    public abstract boolean insertar(Object obj) throws SQLException;
    public abstract boolean uptade(Object obj) throws SQLException;
    public abstract boolean delete(String obj) throws SQLException;
    public abstract ArrayList obtenerTodo() throws SQLException;
    public abstract Object buscarPorID(String obj) throws SQLException;

}
