import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutosDAO {
    private conectaDAO conexao;
    private Connection conn;
    
    /*Constructor*/
    public ProdutosDAO() {
        this.conexao = new conectaDAO();
        this.conn = this.conexao.getConexao();              
    }
    
    /*Método para cadastro*/
    public void cadastro(ProdutosDTO produto) {
        String sql = "INSERT INTO produtos(nome, valor, status) VALUES"
        + "(?,?,?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, Integer.toString(produto.getValor()));
            stmt.setString(3, produto.getStatus());
            stmt.execute();
        }catch (Exception e) {
            System.out.println("Erro ao inserir empresa: " + e.getMessage());
        }
    }
    
               
              
}

