package locadora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Veiculos {

  // Método para buscar todos os veículos
  public void buscarVeiculos() {
    try {
      Connection connection = DbConfig.getConnection();
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM locadoradeveiculos.veiculos");

      while (resultSet.next()) {
        System.out.println("\nID " + resultSet.getInt("id"));
        System.out.println("Marca " + resultSet.getString("marca"));
        System.out.println("Modelo " + resultSet.getString("modelo"));
        System.out.println("Ano " + resultSet.getInt("ano"));
        System.out.println("Placa " + resultSet.getString("placa"));
        System.out.println("Disponivel " + resultSet.getBoolean("disponivel"));
        System.out.println("Categoria " + resultSet.getString("categoria"));
        System.out.println("Imagem " + resultSet.getString("url_veiculo"));
        System.out.println("Preço por dia " + resultSet.getDouble("preco"));
      }
      connection.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Método para criar um novo veículo
  public void criarVeiculo(String marca, String modelo, int ano, String placa, boolean disponivel, String categoria, String url_veiculo, double preco) {
    try {
      Connection connection = DbConfig.getConnection();
      String sql = "INSERT INTO locadoradeveiculos.veiculos (marca, modelo, ano, placa, disponivel, categoria, url_veiculo, preco) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, marca);
      preparedStatement.setString(2, modelo);
      preparedStatement.setInt(3, ano);
      preparedStatement.setString(4, placa);
      preparedStatement.setBoolean(5, disponivel);
      preparedStatement.setString(6, categoria);
      preparedStatement.setString(7, url_veiculo);
      preparedStatement.setDouble(8, preco);
      preparedStatement.executeUpdate();

      connection.close();
      System.out.println("Veículo criado com sucesso!");
    } catch (Exception e) {
      e.printStackTrace();
    }
}

// Método para atualizar um veículo existente
public void atualizarVeiculo(int id, String marca, String modelo, int ano, String placa, boolean disponivel, String categoria, String url_veiculo, double preco) {
  try {
      Connection connection = DbConfig.getConnection();
      String sql = "UPDATE locadoradeveiculos.veiculos SET marca = ?, modelo = ?, ano = ?, placa = ?, disponivel = ?, categoria = ?, url_veiculo = ?, preco = ? WHERE id = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, marca);
      preparedStatement.setString(2, modelo);
      preparedStatement.setInt(3, ano);
      preparedStatement.setString(4, placa);
      preparedStatement.setBoolean(5, disponivel);
      preparedStatement.setString(6, categoria);
      preparedStatement.setString(7, url_veiculo);
      preparedStatement.setDouble(8, preco);
      preparedStatement.setInt(9, id);
      preparedStatement.executeUpdate();

      connection.close();
      System.out.println("Veículo atualizado com sucesso!");
  } catch (Exception e) {
      e.printStackTrace();
  }
}

  // Método para deletar um veículo
  public void deletarVeiculo(int id) {
    try {
      Connection connection = DbConfig.getConnection();
      String sql = "DELETE FROM locadoradeveiculos.veiculos WHERE id = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();

      connection.close();
      System.out.println("Veículo deletado com sucesso!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}