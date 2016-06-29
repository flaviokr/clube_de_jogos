package controladores;
import modelos.*;

public class Ranking {

  public static Usuario definirPessoaVencedora(int ano) {
    int max = 0;
    Usuario vencedor = null;
    for (Usuario u : Usuario.getListaDeUsuarios()){
      if (u.getTipo() == "Pessoa" && u.getPontuacao(ano) > max) {
        vencedor = u;
        max = u.getPontuacao(ano);
      }
    }
    return vencedor;
  }

  public static Usuario definirEquipeVencedora(int ano) {
    int max = 0;
    Usuario vencedor = null;
    for (Usuario u : Usuario.getListaDeUsuarios()){
      if (u.getTipo() == "Equipe" && u.getPontuacao(ano) > max) {
        vencedor = u;
        max = u.getPontuacao(ano);
      }
    }
    return vencedor;
  }
}
