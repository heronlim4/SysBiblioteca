import java.util.ArrayList;

public class Reserva implements Command {
    @Override
    public void execute(ArrayList<String> parametroParaExecutar) {          FachadaBiblioteca.getInstance().realizarReserva(parametroParaExecutar);
    }


}
