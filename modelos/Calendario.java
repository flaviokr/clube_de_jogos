package modelos;
import java.util.ArrayList;

public class Calendario {

  private ArrayList<Data> dias;

  public Calendario(int ano) {
    this.dias = new ArrayList<Data>();
    for (int i = 1; i <= 12; i++) {
      this.dias.addAll(criarMes(i, ano));
    }
    int j = 0;
    for (Data d : this.dias) {
      if (j % 6 == 0) {
        d.setAberto(false);
      }
      j++;
    }
  }

  public ArrayList<Data> getDias() {
    return this.dias;
  }

  private ArrayList<Data> criarMes(int mes, int ano){
    ArrayList<Data> mes_aux = null;
    switch (mes) {
      case 1: mes_aux = criarDias(31, mes, ano); break;
      case 2:
        if (ano == 2016 || ano == 2020){
          mes_aux = criarDias(29, mes, ano); break;
        } else {
          mes_aux = criarDias(28, mes, ano); break;
        }
      case 3: mes_aux = criarDias(31, mes, ano); break;
      case 4: mes_aux = criarDias(30, mes, ano); break;
      case 5: mes_aux = criarDias(31, mes, ano); break;
      case 6: mes_aux = criarDias(30, mes, ano); break;
      case 7: mes_aux = criarDias(31, mes, ano); break;
      case 8: mes_aux = criarDias(31, mes, ano); break;
      case 9: mes_aux = criarDias(30, mes, ano); break;
      case 10: mes_aux = criarDias(31, mes, ano); break;
      case 11: mes_aux = criarDias(30, mes, ano); break;
      case 12: mes_aux = criarDias(31, mes, ano); break;
    }
    return mes_aux;
  }

  private ArrayList<Data> criarDias(int dias, int mes, int ano){
    ArrayList<Data> dias_do_mes = new ArrayList<Data>();
    for (int i = 1; i <= dias; i++) {
      dias_do_mes.add(new Data(i, mes, ano, true));
    }
    return dias_do_mes;
  }

  public void exibirCalendario() {
    int contador = 0;
    for (Data d : this.dias) {
      if (d.getDia() == 1) {
        if (contador == 0)
          contador = valorContadorSemana(primeiroDeJaneiro(d.getAno()));
        System.out.println();
        System.out.println(calcularMes(d.getMes()));
      }
      boolean ocupado = false;
      for (Horario h : d.getHorarios()) {
        if (h.getTurmas().isEmpty() == false) {
          ocupado = true;
        }
      }
      if (ocupado) {
        System.out.print(d.getDia() + "* ");
      } else {
        System.out.print(d.getDia() + " ");
      }
      if (contador == 7) {
        System.out.println();
        contador = 1;
      } else {
        contador++;
      }

    }
  }

  private String calcularMes(int mes) {
    switch (mes) {
      case 1: return "Janeiro";
      case 2: return "Fevereiro";
      case 3: return "Março";
      case 4: return "Abril";
      case 5: return "Maio";
      case 6: return "Junho";
      case 7: return "Julho";
      case 8: return "Agosto";
      case 9: return "Setembro";
      case 10: return "Outubro";
      case 11: return "Novembro";
      case 12: return "Dezembro";
      default: return "";
    }
  }

  private String primeiroDeJaneiro(int ano) {
    switch (ano) {
      case 2013: return "Terca";
      case 2014: return "Quarta";
      case 2015: return "Quinta";
      case 2016: return "Sexta";
      case 2017: return "Domingo";
      case 2018: return "Segunda";
      case 2019: return "Terca";
      case 2020: return "Quarta";
      default: return "";
    }
  }

  private int valorContadorSemana(String dia) {
    switch (dia) {
      case "Domingo": return 1;
      case "Segunda": return 2;
      case "Terca": return 3;
      case "Quarta": return 4;
      case "Quinta": return 5;
      case "Sexta": return 6;
      case "Sabado": return 7;
      default: return 0;
    }
  }
}
