import java.sql.Connection;
import java.sql.DriverManager;

public class conectaDAO {
    /* Método para conectar */
    /* Variáveis */
    Connection conn; //Conexão
    
    public Connection getConexao(){                
        try {        
            Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/leiloes", //linha de conexão
            "root", //usuário do mysql
            "papainoel"
            ); //senha do mysql
            return conn;  
            
        }catch (Exception e){
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }            
    }    
}
