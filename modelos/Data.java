package modelos;
import java.util.ArrayList;

public class Data {

  private int dia;

  private int mes;

  private int ano;

  private ArrayList<Horario> horarios;

  private boolean aberto = true;

  public Data(int dia, int mes, int ano, boolean criar_horarios) {
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;
    if (criar_horarios) {
      this.horarios = new ArrayList<Horario>();
      for(int i = 8; i <= 22; i++){
        this.horarios.add(new Horario(i, 0));
      }
    }
  }

  public int getDia(){
    return this.dia;
  }

  public int getMes(){
    return this.mes;
  }

  public int getAno(){
    return this.ano;
  }

  public boolean getAberto(){
    return this.aberto;
  }

  public void setAberto(boolean a){
    this.aberto = a;
  }

  public ArrayList<Horario> getHorarios(){
    return this.horarios;
  }

  public void exibirHorarios() {
    System.out.println();
    for (Horario h : this.horarios) {
      if (h.getTurmas().isEmpty() == false) {
        System.out.println(h.getHoras() + "h: Ocupado");
      } else {
        System.out.println(h.getHoras() + "h: Livre");
      }
    }
  }

}
