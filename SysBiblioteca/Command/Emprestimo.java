import java.util.ArrayList;

public class Emprestimo implements Command {
    @Override
    public void execute(ArrayList<String> parametroParaExecutar) {
        FachadaBiblioteca.getInstance().realizarEmprestimo(parametroParaExecutar);
    }

}
