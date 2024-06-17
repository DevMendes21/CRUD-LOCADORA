//CTRL + SHIFT + P - Java Create a Java Project
//Selecionar Maven
//Opcao no Archetype
//Grupo ID (id do projeto)
//Nome do Projeto
//Selecione aonde vai ser instalado e boa

//Criar uma pasta chamada lib (Significado: Livraria importada de fora / Library)
//Baixar o MySQL Connector no Product Version: 8.0.30 e Operating System: Platform Independent (Architecture Independent), ZIP Archive
//Colocar ele na pasta lib dentro do projeto criado pelo Mavem

//COMANDOS PARA COMPILAR O CODIGO:
//javac -cp .\lib\mysql-connector-java-8.0.30.jar -d bin .\src\BancoDeDados\DbConfig.java .\src\Main\Main.java .\src\Rotas\Associados.java .\src\Rotas\Veiculos.java .\src\Rotas\TabelaPrecos.java
//java -cp "bin;lib/mysql-connector-java-8.0.30.jar" locadora.Main

/*============================================ Importações ============================================*/

package locadora;
import java.sql.Connection; // Possui a função de conectar ao banco de dados e traz o resultado dentro do import java.sql.Statement.
import java.sql.ResultSet; // Traz consigo os resultados de pesquisa do Banco de dados, como SELECT, INSERT, DELETE, USE, UPDATE, ETC...
import java.sql.Statement; // Passa os paraemtros SQL e instruções para o banco de dados. (passa o insert e etc...)
import java.util.Scanner; // Entrada de dados pelo usuário via console.

/*============================================ Menu Principal ============================================*/

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para ler a entrada do usuário.
    while (true) { // Loop infinito para exibir o menu principal até o usuário escolher sair.
      System.out.println("\nMenu Principal:");
      System.out.println("1. Menu Associados");
      System.out.println("2. Menu Veículos");
      System.out.println("3. Menu Tabela de Preços");
      System.out.println("4. Sair");
      System.out.print("Escolha uma opção: ");
      int escolha = scanner.nextInt(); // Lê a escolha do usuário.
      scanner.nextLine(); // Usa a nova linha deixada pelo nextInt().

      switch (escolha) {
        case 1:
          menuAssociados(scanner); // Chama o menu de associados.
          break;
        case 2:
          menuVeiculos(scanner); // Chama o menu de veículos.
          break;
        case 3:
          menuTabelaPrecos(scanner); // Chama o menu da tabela de preços.
          break;
        case 4:
          System.out.println("Saindo...");
          scanner.close(); // Fecha o Scanner.
          System.exit(0); // Encerra o programa.
        default:
          System.out.println("Opção inválida. Tente novamente.");
      }
    }
  }

/*============================================ Menu Associados ============================================*/

  // Exibir o menu de associados
  public static void menuAssociados(Scanner scanner) {
    Associados associados = new Associados(); // Cria um objeto da classe Associados.
    while (true) {
      System.out.println("\nMenu Associados:");
      System.out.println("1. Buscar todos os associados");
      System.out.println("2. Criar um novo associado");
      System.out.println("3. Atualizar um associado existente");
      System.out.println("4. Deletar um associado");
      System.out.println("5. Voltar ao menu principal");
      System.out.print("Escolha uma opção: ");
      int escolha = scanner.nextInt(); // Lê a escolha do usuário.
      scanner.nextLine(); // Usa a nova linha deixada pelo nextInt().

      switch (escolha) {
        case 1:
          associados.buscarAssociados(); // Chama o método para buscar todos os associados.
          break;
        case 2:
          System.out.print("\nSistema de Criação de Associado");
          // Coleta dados para criar um novo associado.
          System.out.print("\nNome: ");
          String nome = scanner.nextLine();
          System.out.print("Telefone: ");
          String telefone = scanner.nextLine();
          System.out.print("E-mail: ");
          String email = scanner.nextLine();
          System.out.print("CPF: ");
          String cpf = scanner.nextLine();
          associados.criarAssociado(nome, telefone, email, cpf); // Chama o método para criar um novo associado.
          break;
        case 3:
          System.out.print("\nSistema de Atualização de Associado");
          // Coleta dados para atualizar um associado existente.
          System.out.print("\nID do associado a ser atualizado: ");
          int idAtualizar = scanner.nextInt();
          scanner.nextLine(); // Use a nova linha deixada pelo nextInt().
          System.out.print("Novo nome: ");
          String novoNome = scanner.nextLine();
          System.out.print("Novo telefone: ");
          String novoTelefone = scanner.nextLine();
          System.out.print("Novo e-mail: ");
          String novoEmail = scanner.nextLine();
          System.out.print("Novo CPF: ");
          String novoCpf = scanner.nextLine();
          associados.atualizarAssociado(idAtualizar, novoNome, novoTelefone, novoEmail, novoCpf); // Chama o método para atualizar o associado.
          break;
        case 4:
          System.out.print("\nSistema de Exclusão de Associado");
          System.out.print("\nID do associado a ser deletado: ");
          int idDeletar = scanner.nextInt();
          scanner.nextLine(); // Usa a nova linha deixada pelo nextInt().
          associados.deletarAssociado(idDeletar); // Chama o método para deletar o associado.
          break;
        case 5:
          return; // Volta ao menu principal.
        default:
          System.out.println("Opção inválida. Tente novamente.");
      }
    }
  }

/*============================================ Menu Veiculos ============================================*/

  // Método para exibir o menu de veículos
  public static void menuVeiculos(Scanner scanner) {
    Veiculos veiculos = new Veiculos(); // Cria um objeto da classe Veiculos.
    while (true) {
      System.out.println("\nMenu Veículos:");
      System.out.println("1. Buscar todos os veículos");
      System.out.println("2. Criar um novo veículo");
      System.out.println("3. Atualizar um veículo existente");
      System.out.println("4. Deletar um veículo");
      System.out.println("5. Voltar ao menu principal");
      System.out.print("Escolha uma opção: ");
      int escolha = scanner.nextInt(); // Lê a escolha do usuário.
      scanner.nextLine(); // Usa a nova linha deixada pelo nextInt().

      switch (escolha) {
        case 1:
            veiculos.buscarVeiculos(); // Chama o método para buscar todos os veículos.
            break;
        case 2:
            System.out.print("\nSistema de Criação de Veiculo");
            // Coleta dados para criar um novo veículo.
            System.out.print("\nModelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Marca: ");
            String marca = scanner.nextLine();
            System.out.print("Ano: ");
            int ano = scanner.nextInt();
            scanner.nextLine(); // Usa a nova linha
            System.out.print("Placa: ");
            String placa = scanner.nextLine();
            System.out.print("Disponível (true/false): ");
            boolean disponivel = scanner.nextBoolean();
            scanner.nextLine(); // Usa a nova linha
            System.out.print("Categoria: (Seda, Hatch, Picape, Esportivo, SUV)");
            String categoria = scanner.nextLine();
            System.out.print("Imagem do Veículo: ");
            String url_veiculo = scanner.nextLine();
            System.out.print("Preço: ");
            double preco = scanner.nextDouble();
            scanner.nextLine(); // Usa a nova linha
            veiculos.criarVeiculo(modelo, marca, ano, placa, disponivel, categoria, url_veiculo, preco); // Usa o método para criar um novo veículo.
            break;
        case 3:
            System.out.print("\nSistema de Atualização de Veiculo");
            // Coleta dados para atualizar um veículo existente.
            System.out.print("\nID do veículo a ser atualizado: ");
            int idAtualizar = scanner.nextInt();
            scanner.nextLine(); // Usa a nova linha
            System.out.print("Modelo: ");
            String modeloNovo = scanner.nextLine();
            System.out.print("Marca: ");
            String marcaNovo = scanner.nextLine();
            System.out.print("Ano: ");
            int anoNovo = scanner.nextInt();
            scanner.nextLine(); // Usa a nova linha
            System.out.print("Placa: ");
            String placaNovo = scanner.nextLine();
            System.out.print("Disponível (true/false): ");
            boolean disponivelNovo = scanner.nextBoolean();
            scanner.nextLine(); // Usa a nova linha
            System.out.print("Categoria: ");
            String categoriaNovo = scanner.nextLine();
            System.out.print("Imagem do Veículo: ");
            String url_veiculoNovo = scanner.nextLine();
            System.out.print("Preço: ");
            double precoNovo = scanner.nextDouble();
            scanner.nextLine(); // Usa a nova linha
            veiculos.atualizarVeiculo(idAtualizar, modeloNovo, marcaNovo, anoNovo, placaNovo, disponivelNovo, categoriaNovo, url_veiculoNovo, precoNovo); // Chama o método para atualizar o veículo.
            break;
        case 4:
            System.out.print("\nSistema de Exclusão de Veiculo");
            System.out.print("\nID do veículo a ser deletado: ");
            int idDeletar = scanner.nextInt();
            scanner.nextLine(); // Usa a nova linha
            veiculos.deletarVeiculo(idDeletar); // Chama o método para deletar o veículo.
            break;
        case 5:
            return; // Volta ao menu principal.
        default:
            System.out.println("Opção inválida. Tente novamente.");
      }
    }
  }
    

  /*============================================ Menu Tabela Preços ============================================*/

  // Método para exibir o menu da tabela de preços
  public static void menuTabelaPrecos(Scanner scanner) {
    TabelaPrecos tabelaPrecos = new TabelaPrecos(); // Cria um objeto da classe TabelaPrecos.
    while (true) {
      System.out.println("\nMenu Tabela de Preços:");
      System.out.println("1. Buscar todos os preços");
      System.out.println("2. Criar um novo preço");
      System.out.println("3. Atualizar um preço existente");
      System.out.println("4. Deletar um preço");
      System.out.println("5. Voltar ao menu principal");
      System.out.print("Escolha uma opção: ");
      int escolha = scanner.nextInt(); // Lê a escolha do usuário.
      scanner.nextLine(); // Usa a nova linha deixada pelo nextInt().

      switch (escolha) {
        case 1:
          tabelaPrecos.buscarPrecos(); // Chama o método para buscar todos os preços.
          break;
        case 2:
        System.out.print("\nSistema de Criação de Preço");
          // Coleta dados para criar um novo preço.
          System.out.print("\nCategoria: ");
          String descricao = scanner.nextLine();
          System.out.print("Valor: ");
          double valor = scanner.nextDouble();
          scanner.nextLine(); // Usa a nova linha deixada pelo nextDouble().
          tabelaPrecos.criarPreco(descricao, valor); // Chama o método para criar um novo preço.
          break;
        case 3:
        System.out.print("\nSistema de Atualização de Preço");
          // Coleta dados para atualizar um preço existente.
          System.out.print("\nID do preço a ser atualizado: ");
          int idAtualizar = scanner.nextInt();
          scanner.nextLine(); // Usa a nova linha deixada pelo nextInt().
          System.out.print("Nova Categoria: ");
          String novaDescricao = scanner.nextLine();
          System.out.print("Novo valor: ");
          double novoValor = scanner.nextDouble();
          scanner.nextLine(); // Usa a nova linha deixada pelo nextDouble().
          tabelaPrecos.atualizarPreco(idAtualizar, novaDescricao, novoValor); // Chama o método para atualizar o preço.
          break;
        case 4:
          System.out.print("\nSistema de Exclusão de Preço");
          System.out.print("\nID do preço a ser deletado: ");
          int idDeletar = scanner.nextInt();
          scanner.nextLine(); // Usa a nova linha deixada pelo nextInt().
          tabelaPrecos.deletarPreco(idDeletar); // Chama o método para deletar o preço.
          break;
        case 5:
          return; // Volta ao menu principal.
        default:
          System.out.println("Opção inválida. Tente novamente.");
      }
    }
  }
}