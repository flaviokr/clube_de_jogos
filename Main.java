import controladores.*;
import modelos.*;
import gerenciadores.*;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    GerenciamentoClubeJogosInterface g = new GerenciamentoClubeJogosInterface();
    while (true) {
      System.out.println("\nO que deseja fazer?");
      System.out.println("(1) Gerenciar Usuários");
      System.out.println("(2) Gerenciar Atividades");
      System.out.println("(3) Gerenciar Locais");
      System.out.println("(4) Gerenciar Calendário");
      System.out.println("(5) Exibir log");
      System.out.println("(6) Salvar estado do sistema");
      Scanner scan = new Scanner(System.in);
      String opcao = scan.nextLine();
      switch (opcao) {
        case "1":
          g.gerenciaUsuario();
          break;
        case "2":
          g.gerenciaAtividade();
          break;
        case "3":
          g.gerenciaLocal();
          break;
        case "4":
          g.gerenciaCalendario();
          break;
        case "5":
          g.exibeLog();
          break;
        case "6":
          g.salvarEstadoSistema();
          break;
      }
    }
  }

}
