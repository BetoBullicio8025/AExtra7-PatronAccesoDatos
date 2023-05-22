import java.sql.SQLException;

public class main {
    public static void main(String[] args) {
        libroDAO ldao = new libroDAO();
        try {
            if (ldao.delete(("11"))) {
                System.out.println("Eliminado correctamente");
            } else {
                System.out.println("No se pudo eliminar");
            }
        }catch (SQLException sqle){
            System.out.println("Error...");
        }


        /*Libro libro = new Libro(0, "Piensa en Java", "Bruce Eckel");
        try {
            if (ldao.insertar(Libro)){
                System.out.println("Se modificó correctamente");
            }else {
                System.out.println("No se pudo insertar...");
            }
        }catch (SQLException sqle){
            System.out.println("Error al insertar");
        }

    */
    }
}
