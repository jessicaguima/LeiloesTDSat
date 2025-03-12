import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {
    private conectaDAO conexao;
    private Connection conn;
    
    /*Constructor*/
    public ProdutosDAO() {
        this.conexao = new conectaDAO();
        this.conn = this.conexao.getConexao();              
    }    
    
    /*Método para cadastro*/
    public boolean cadastro(ProdutosDTO produto) {
        String sql = "INSERT INTO produtos(nome, valor, status) VALUES"
        + "(?,?,?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, Integer.toString(produto.getValor()));
            stmt.setString(3, produto.getStatus());
            stmt.execute();
            return true;
        }catch (Exception e) {
            System.out.println("Erro ao inserir empresa: " + e.getMessage());
            return false;
        }
    }
    
    /* Método para listagem  */
    public List<ProdutosDTO> getProdutos(){
        String sql = "SELECT produtos.id as id, nome, valor, status FROM produtos;";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<ProdutosDTO> lista = new ArrayList<>();
            
            while(rs.next()){
                ProdutosDTO produtosdto = new ProdutosDTO();
                produtosdto.setId(rs.getInt("id"));
                produtosdto.setNome(rs.getString("nome"));
                produtosdto.setValor(rs.getInt("valor"));
                produtosdto.setStatus(rs.getString("status"));
                
                lista.add(produtosdto);
            }
            return lista;
        }catch (Exception e){
            return null;
        }
    }
     
}

