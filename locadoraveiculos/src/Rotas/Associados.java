package locadora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Associados {
  
  // Método para buscar todos os associados
  public void buscarAssociados() {
    try {
      Connection connection = DbConfig.getConnection(); // Tentativa de conexão
      Statement statement = connection.createStatement(); // Criando um Statement (Status(200/401) / Resultado (O que trouxe de pesquisa))
      ResultSet resultSet = statement.executeQuery("SELECT * FROM locadoradeveiculos.associado"); // SELECIONE *(tudo) DA locadoradeveiculos.TABELA
      
      //Primeiro nome como você deseja que apareça o Segundo deve ser idêntico ao que você quer que puxe do banco
      while (resultSet.next()) {
        System.out.println("\nID " + resultSet.getInt("id"));
        System.out.println("Nome " + resultSet.getString("nome"));
        System.out.println("Telefone " + resultSet.getString("telefone"));
        System.out.println("E-mail " + resultSet.getString("email"));
        System.out.println("CPF " + resultSet.getString("cpf"));
      }
      //Fechando a conexão
      connection.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  
  /** 
   * @param nome
   * @param telefone
   * @param email
   * @param cpf
   */
  // Criar novo Associado
  public void criarAssociado(String nome, String telefone, String email, String cpf) {
    try {
      Connection connection = DbConfig.getConnection();
      String sql = "INSERT INTO locadoradeveiculos.associado (nome, telefone, email, cpf) VALUES (?, ?, ?, ?)";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, nome);
      preparedStatement.setString(2, telefone);
      preparedStatement.setString(3, email);
      preparedStatement.setString(4, cpf);
      preparedStatement.executeUpdate();

      connection.close();
      System.out.println("Associado criado com sucesso!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  
  /** 
   * @param id
   * @param nome
   * @param telefone
   * @param email
   * @param cpf
   */
  // Atualizar Associado no BD
  public void atualizarAssociado(int id, String nome, String telefone, String email, String cpf) {
    try {
      Connection connection = DbConfig.getConnection();
      String sql = "UPDATE locadoradeveiculos.associado SET nome = ?, telefone = ?, email = ?, cpf = ? WHERE id = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, nome);
      preparedStatement.setString(2, telefone);
      preparedStatement.setString(3, email);
      preparedStatement.setString(4, cpf);
      preparedStatement.setInt(5, id);
      preparedStatement.executeUpdate();

      connection.close();
      System.out.println("Associado atualizado com sucesso!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  
  /** 
   * @param id
   */
  // Deletar um associado
  public void deletarAssociado(int id) {
    try {
      Connection connection = DbConfig.getConnection();
      String sql = "DELETE FROM locadoradeveiculos.associado WHERE id = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();

      connection.close();
      System.out.println("Associado deletado com sucesso!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}