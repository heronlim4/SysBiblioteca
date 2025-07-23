import java.util.ArrayList;

public class ConsultaLivro implements Command {
    
  @Override
  public void execute(ArrayList<String> parametroParaExecutar) {
        FachadaBiblioteca.getInstance().realizarConsultaLivro(parametroParaExecutar);
    }

	
}
