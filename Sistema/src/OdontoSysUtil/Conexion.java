package OdontoSysUtil;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion{
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/odontosys";
    
    private static final String usuario = "root";
    private static final String clave = "odontosys";
    private static Connection con;
    public static Statement st;

    public static void conectar(){
        try {
                Class.forName("com.mysql.jdbc.Driver");
                String urlTotal = url;
                con = DriverManager.getConnection(urlTotal, usuario, clave);
                st = con.createStatement();
                
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void cerrar(){
        try {
            st.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getCon() {
        return con;
    }    
}