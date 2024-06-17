package locadora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TabelaPrecos {

  // Método para buscar todos os preços
  public void buscarPrecos() {
    try {
      Connection connection = DbConfig.getConnection();
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM locadoradeveiculos.tabelaprecos");

      while (resultSet.next()) {
        System.out.println("\nID " + resultSet.getInt("id"));
        System.out.println("Categoria " + resultSet.getString("categoria"));
        System.out.println("Preço por dia " + resultSet.getDouble("preco_por_dia"));
      }
      connection.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  
  /** 
   * @param categoria
   * @param preco_por_dia
   */
  // Método para criar um novo preço
  public void criarPreco(String categoria, double preco_por_dia) {
    try {
      Connection connection = DbConfig.getConnection();
      String sql = "INSERT INTO locadoradeveiculos.tabelaprecos (categoria, preco_por_dia) VALUES (?, ?)";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, categoria);
      preparedStatement.setDouble(2, preco_por_dia);
      preparedStatement.executeUpdate();

      connection.close();
      System.out.println("Preço criado com sucesso!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  
  /** 
   * @param id
   * @param categoria
   * @param preco_por_dia
   */
  // Método para atualizar um preço existente
  public void atualizarPreco(int id, String categoria, double preco_por_dia) {
    try {
      Connection connection = DbConfig.getConnection();
      String sql = "UPDATE locadoradeveiculos.tabelaprecos SET categoria = ?, preco_por_dia = ? WHERE id = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, categoria);
      preparedStatement.setDouble(2, preco_por_dia);
      preparedStatement.setInt(3, id);
      preparedStatement.executeUpdate();

      connection.close();
      System.out.println("Preço atualizado com sucesso!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  
  /** 
   * @param id
   */
  // Método para deletar um preço
  public void deletarPreco(int id) {
    try {
      Connection connection = DbConfig.getConnection();
      String sql = "DELETE FROM locadoradeveiculos.tabelaprecos WHERE id = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();

      connection.close();
      System.out.println("Preço deletado com sucesso!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
