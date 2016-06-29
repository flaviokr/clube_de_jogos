package modelos;

public class Jogo {

  private String nome;

  private String tipo;

  public Jogo(String nome, String tipo) {
    this.nome = nome;
    this.tipo = tipo;
  }

  public String getNome() {
    return this.nome;
  }

  public String getTipo() {
    return this.tipo;
  }
}
