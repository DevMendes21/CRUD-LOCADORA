package locadora;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

//PASSAR OS PARAMETROS DE ACESSO DO USUARIO AO BANCO
public class DbConfig {
  private static final String url = "jdbc:mysql://localhost:3306/locadoradeveiculos"; // "URL DO BANCO"
  private static final String user = "root"; // "Login para o banco (Usuario)"
  private static final String password = "Ya@1456789"; // "Login para o banco (Senha)"

  
  /** 
   * @return Connection
   * @throws SQLException
   */
  public static Connection getConnection() throws SQLException{
    return DriverManager.getConnection(url, user, password);
  }
}
