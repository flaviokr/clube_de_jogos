package modelos;
import java.util.ArrayList;

public class Horario {

  private int horas;

  private int minutos;

  private ArrayList<Turma> turmas;

  public Horario(int horas, int minutos) {
    this.horas = horas;
    this.minutos = minutos;
    this.turmas = new ArrayList<Turma>();
  }

  public int getHoras(){
    return this.horas;
  }

  public int getMinutos(){
    return this.minutos;
  }

  public ArrayList<Turma> getTurmas(){
    return this.turmas;
  }

  public void addTurma(Turma t){
    this.turmas.add(t);
  }

  public static Horario calcularDistancia(Horario h1, Horario h2) {
    // h1 > h2
    int horas = h1.getHoras() - h2.getHoras();
    int minutos;
    if (h1.getMinutos() + h2.getMinutos() >= 60) {
      if (h1.getMinutos() < h2.getMinutos()){
        horas = horas - 1;
        minutos = h1.getMinutos() + 60 - h2.getMinutos();
      } else {
        minutos = h1.getMinutos() - h2.getMinutos();
      }
    } else {
      minutos = h1.getMinutos() + h2.getMinutos();
    }
    return new Horario(horas, minutos);
  }

}
