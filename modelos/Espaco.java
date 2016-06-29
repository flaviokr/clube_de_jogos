package modelos;
import java.util.ArrayList;

public class Espaco {

  private static ArrayList<Espaco> lista_de_espacos = new ArrayList<Espaco>();

  private static int numero_de_espacos = 1;

  private int id;

  private String tipo;

  private String nome;

  public Espaco(String tipo) {
    this.id = numero_de_espacos;
    this.tipo = tipo;
    numero_de_espacos += 1;
    lista_de_espacos.add(this);
  }

  public static ArrayList<Espaco> getListaDeEspacos(){
    return lista_de_espacos;
  }

  public String getTipo() {
    return this.tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getId() {
    return this.id;
  }

  public int getNumeroDeEspacos() {
    return numero_de_espacos;
  }
}
