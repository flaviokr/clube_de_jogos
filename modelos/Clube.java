package modelos;

public class Clube {

  private Espaco quadra_1;

  private Espaco quadra_2;

  private Espaco sala_1;

  private Espaco sala_2;

  public Clube() {
    this.quadra_1 = new Espaco("Quadra");
    this.quadra_2 = new Espaco("Quadra");
    this.sala_1 = new Espaco("Sala");
    this.sala_2 = new Espaco("Sala");
  }

  public Espaco getQuadra(int i) {
    switch (i) {
      case 1: return this.quadra_1;
      case 2: return this.quadra_2;
      default: return null;
    }
  }

  public Espaco getSala(int i) {
    switch (i) {
      case 1: return this.sala_1;
      case 2: return this.sala_2;
      default: return null;
    }
  }
}
