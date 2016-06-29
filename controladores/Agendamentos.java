package controladores;
import modelos.*;
import java.util.ArrayList;

public class Agendamentos {

  public static boolean agendarTurma(Turma t, Calendario c) {
    Atividade a = t.getAtividade();
    Data data_para_agendar = a.getData();
    ArrayList<Horario> horarios_do_dia_do_calendario;
    if (podeAgendar(c, data_para_agendar, a.getInicio(), a.getFim(), a.getDuracao(), t.getEspaco(), a)) {
      agendar(t, c, data_para_agendar, a.getInicio(), a.getFim(), a.getDuracao(), t.getEspaco());
      return true;
    } else {
      return false;
    }
  }

  public static void agendar(Turma t, Calendario c, Data data_de_realizacao, Horario horario_de_inicio, Horario horario_de_fim, Horario duracao, Espaco e) {
    Data data_do_calendario = null;
    Horario horario_de_inicio_do_calendario = null;
    int indice_do_horario_de_inicio_do_calendario = 0;
    for (Data dt : c.getDias()) {
      if (dt.getMes() == data_de_realizacao.getMes()) {
        if (dt.getDia() == data_de_realizacao.getDia()) {
          data_do_calendario = dt;
        }
      }
    }
    for (Horario hr : data_do_calendario.getHorarios()) {
      if (hr.getHoras() == horario_de_inicio.getHoras()){
        horario_de_inicio_do_calendario = hr;
        indice_do_horario_de_inicio_do_calendario = data_do_calendario.getHorarios().indexOf(hr);
      }
    }
    for (int i = 0; i < duracao.getHoras(); i++) {
      data_do_calendario.getHorarios().get(indice_do_horario_de_inicio_do_calendario + i).addTurma(t);
    }
  }

  public static boolean podeAgendar(Calendario c, Data data_de_realizacao, Horario horario_de_inicio, Horario horario_de_fim, Horario duracao, Espaco e, Atividade a) {
    if (a.getJogo().getTipo() == "Analógico" && e.getTipo() == "Quadra") return false;
    if (a.getJogo().getTipo() == "Físico" && e.getTipo() == "Sala") return false;
    if (horario_de_inicio.getHoras() < 8 || horario_de_fim.getHoras() > 22) return false;
    Data data_do_calendario = null;
    Horario horario_de_inicio_do_calendario = null;
    int indice_do_horario_de_inicio_do_calendario = 0;
    for (Data dt : c.getDias()) {
      if (dt.getMes() == data_de_realizacao.getMes()) {
        if (dt.getDia() == data_de_realizacao.getDia()) {
          data_do_calendario = dt;
        }
      }
    }
    if (data_do_calendario.getAberto() == false) return false;
    for (Horario hr : data_do_calendario.getHorarios()) {
      if (hr.getHoras() == horario_de_inicio.getHoras()){
        horario_de_inicio_do_calendario = hr;
        indice_do_horario_de_inicio_do_calendario = data_do_calendario.getHorarios().indexOf(hr);
      }
    }
    return checarTurmas(data_do_calendario.getHorarios(), duracao.getHoras(), indice_do_horario_de_inicio_do_calendario, e);
  }

  public static boolean checarTurmas(ArrayList<Horario> horarios, int duracao, int indice_do_inicio, Espaco e) {
    if (indice_do_inicio + duracao > horarios.size()) return false;
    for (int i = indice_do_inicio; i < indice_do_inicio + duracao - 1; i++) {
      if (horarios.get(i).getTurmas().isEmpty() == true) break;
      for (Turma t : horarios.get(i).getTurmas()) {
        if (t.getEspaco() == e) return false;
      }
    }
    return true;
  }
}
