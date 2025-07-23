import java.util.ArrayList;

public class ConsultaObserver implements Command{
    @Override
    public void execute(ArrayList<String> parametroParaExecutar) {
        FachadaBiblioteca.getInstance().realizarConsultaObserver(parametroParaExecutar);
    }

}
