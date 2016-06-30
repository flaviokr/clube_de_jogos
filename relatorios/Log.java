package relatorios;
import java.text.SimpleDateFormat;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Date;;

public class Log {

  private static Log instance = new Log();

  private Log(){
  }

  public static Log getInstance(){
    return instance;
  }

  public void logar(String operacao, String resultado){
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true));
			String output = "";
      SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm");
      String strDate = sdfDate.format(new Date());
      output += strDate + " - " + operacao + " - " + resultado + "\n";
      writer.write(output);
			writer.close();
		} catch (Exception e) {
			System.out.println("\nErro na escrita do log.");
		}
  }

}
