package modelos;
import java.util.ArrayList;

public class Turma {

  private Atividade atividade;

  private ArrayList<Usuario> participantes;

  private int numero_de_participantes;

  private Espaco espaco;

  private int duracao;

  private Data inicio;

  private Data fim;

  public Turma(Atividade atividade, Espaco espaco, int duracao, Data inicio, Data fim) {
    this.atividade = atividade;
    this.participantes = new ArrayList<Usuario>();
    this.numero_de_participantes = 0;
    this.espaco = espaco;
    this.duracao = duracao;
    this.inicio = inicio;
    this.fim = fim;
  }

  public Atividade getAtividade() {
    return this.atividade;
  }

  public ArrayList<Usuario> getParticipantes() {
    return this.participantes;
  }

  public Espaco getEspaco() {
    return this.espaco;
  }

  public int getDuracao() {
    return this.duracao;
  }

  public Data getInicio() {
    return this.inicio;
  }

  public Data getFim() {
    return this.fim;
  }

  public int getNumeroDeParticipantes() {
    return this.numero_de_participantes;
  }

  public boolean addParticipante(Usuario u){
    if (u.addTurma(this) == false) return false;
    if (u.getTipo() == "Pessoa") {
      this.participantes.add(u);
      this.numero_de_participantes = this.numero_de_participantes + 1;
      return true;
    }
    if (u.getTipo() == "Equipe") {
      this.participantes.add(u);
      this.numero_de_participantes = this.numero_de_participantes + u.getMembros().size();
      return true;
    }
    return false;
  }
}
