public class Projeto {
    public static void main(String[] args) {
       conectaDAO c = new conectaDAO();
       c.getConexao();
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastroVIEW().setVisible(true);
            }
        });

    }
}
