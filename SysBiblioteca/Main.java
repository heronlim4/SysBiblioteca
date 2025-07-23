import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CarregaUsuarios.inicializaUsuarios();
        CarregaLivros.carregarLivrosSistema();
        InterfaceUsuario.getInstance().fazerLoopEntrada();
    }
}
