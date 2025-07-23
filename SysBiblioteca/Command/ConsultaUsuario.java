import java.util.ArrayList;

public class ConsultaUsuario implements Command{
    @Override
    public void execute(ArrayList<String> parametroParaExecutar) {
        FachadaBiblioteca.getInstance().realizarConsultaUsuario(parametroParaExecutar);
    }
	
}
