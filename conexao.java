import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {

    private static final String USUARIO = "root";
    private static final String SENHA = "110698";
    private static final String URL = "jdbc:mysql://localhost:3306/projeto_clube";

    private static Connection conexao;

    /**
     * Obtém uma conexão com o banco de dados.
     *
     * @return A conexão com o banco de dados.
     */
    public static Connection obterConexao() {
        try {
            if (conexao == null) {
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
                return conexao;
            } else {
                return conexao;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Abre uma nova conexão com o banco de dados.
     *
     * @return A nova conexão com o banco de dados.
     */
    public static Connection abrir() {
        return obterConexao();
    }

    /**
     * Fecha a conexão com o banco de dados.
     *
     * @param conn A conexão a ser fechada.
     */
    public static void fechar(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

