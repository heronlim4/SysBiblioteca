import java.util.ArrayList;

public class Observacao implements Command {
    @Override
    public void execute(ArrayList<String> parametroParaExecutar) {
        FachadaBiblioteca.getInstance().realizarObservacao(parametroParaExecutar);
    }

}
