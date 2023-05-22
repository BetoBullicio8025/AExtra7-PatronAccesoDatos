import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class libroDAO implements interfazDAO{

    public libroDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sql = "INSERT INTO libros(titulo, autor) VALUES(?, ?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("Libros.db").getConnected;
        pstm.setString(1, ((Libro)obj).getTitulo());
        pstm.setString(2, ((Libro)obj).getAutor());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean uptade(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE libros SET titulo = ?, autor = ? WHERE id = ? ; ";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("Libros.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((Libro)obj).getTitulo());
        pstm.setString(2, ((Libro)obj).getAutor());
        pstm.setInt(3, ((Libro)obj).getId());

        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean delete(String obj) throws SQLException {
        String sqlDelete = "DELETE FROM libros WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSigleton.getInstance("Libros.db").getConnetion().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sqlDelete = "SELECT * FROM libros WHERE id = ? ; ";
        ArrayList<libro> resultado = new ArrayList<>();

        PreparedStatement pstm = ConexionSigleton.getInstance("Libros.db").getConnetion().createStatement();
        ResultSet rst = pstm.executeQuery(sql);
        while (rst.next()){
            resultado.add(new Libro(rst.getInt(1), rst.getString(2), rst.getString(3)));
        }
        return resultado;
    }

    @Override
    public Object buscarPorID(String id) throws SQLException {
        String sqlDelete = "SELECT * FROM libros WHERE id = ? ; ";
        Libro libro = null;
            PreparedStatement pstm = ConexionSigleton.getInstance("Libros.db").getConnetion().prepareStatement(sqlDelete);
            pstm.setInt(1, Integer.parseInt(id));
            ResultSet rst = pstm.executeQuery();
            if (rst.next()) {
                libro = new Libro(rst.getInt(1, rst.getString(2), rst.getString(3)));
            }
        return null;
    }
}
