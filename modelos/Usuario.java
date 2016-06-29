package modelos;
import java.util.ArrayList;
import java.util.HashMap;

public class Usuario {

  private static ArrayList<Usuario> lista_de_usuarios = new ArrayList<Usuario>();

  private static int numero_de_usuarios = 1;

  private int nMatricula;

  private String tipo;

  private String nome;

  private String idade;

  private String sexo;

  private String endereco;

  private String telefone;

  private ArrayList<Usuario> membros = null;

  private HashMap<Integer, Integer> pontuacao_por_ano;

  private ArrayList<Turma> turmas = null;

  public Usuario(String tipo, String nome) {
    this.nMatricula = numero_de_usuarios;
    this.tipo = tipo;
    this.nome = nome;
    this.turmas = new ArrayList<Turma>();
    this.pontuacao_por_ano = new HashMap<Integer, Integer>();
    lista_de_usuarios.add(this);
    numero_de_usuarios += 1;
  }

  public static int getNumeroDeUsuarios(){
    return numero_de_usuarios;
  }

  public int getMatricula(){
    return this.nMatricula;
  }

  public String getTipo() {
    return this.tipo;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getPontuacao(int ano) {
    if (this.pontuacao_por_ano.get(ano) == null){
      return 0;
    } else {
      return this.pontuacao_por_ano.get(ano);
    }
  }

  public ArrayList<Turma> getTurmas() {
    return this.turmas;
  }

  public static ArrayList<Usuario> getListaDeUsuarios() {
    return lista_de_usuarios;
  }

  public boolean addTurma(Turma t) {
    if (this.turmas.size() >= 2) return false;
    for (Turma tr : this.turmas) {
      if (t.getAtividade().getData().getAno() == tr.getAtividade().getData().getAno() &&
          t.getAtividade().getData().getMes() == tr.getAtividade().getData().getMes() &&
          t.getAtividade().getData().getDia() == tr.getAtividade().getData().getDia()

          ) {
            return false;
      }
    }
    this.turmas.add(t);
    return true;
  }

  public void addPontos(int pontos, int ano) {
    if (this.pontuacao_por_ano.get(ano) == null){
      this.pontuacao_por_ano.put(ano, pontos);
    } else {
      int p = pontuacao_por_ano.get(ano);
      this.pontuacao_por_ano.put(ano, p + pontos);
    }
  }

  public ArrayList<Usuario> getMembros() {
    if (this.tipo == "Equipe") return this.membros;
    return null;
  }

  public void addMembro(Usuario u) {
    if (this.tipo == "Equipe") {
      if (this.membros == null) this.membros = new ArrayList<Usuario>();
      this.membros.add(u);
    }
  }

  public void setAtributosLegacy(String idade, String endereco, String telefone){
    this.idade = idade;
    this.endereco = endereco;
    this.telefone = telefone;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  public String getEndereco(){
    return this.endereco;
  }

  public void setEndereco(String endereco){
    this.endereco = endereco;
  }

  public String getIdade(){
    return this.idade;
  }

  public void setIdade(String idade){
    this.idade = idade;
  }

  public String getTelefone(){
    return this.telefone;
  }

  public void setTelefone(String telefone){
    this.telefone = telefone;
  }



}
