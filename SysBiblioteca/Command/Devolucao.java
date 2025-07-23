import java.util.ArrayList;

public class Devolucao implements Command {
    @Override
    public void execute(ArrayList<String> parametroParaExecutar) {
        FachadaBiblioteca.getInstance().realizarDevolucao(parametroParaExecutar);
    }
}
