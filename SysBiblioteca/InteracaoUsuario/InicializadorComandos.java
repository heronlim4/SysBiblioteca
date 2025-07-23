
public class InicializadorComandos {
    public static HashMap<String, Command> inicializarComandos() {
        HashMap<String, Command> comandos = new HashMap<String, Command>();
        comandos.put("emp", new Emprestimo());
        comandos.put("res", new Reserva());
        comandos.put("dev", new Devolucao());
        comandos.put("obs", new Observacao());
        comandos.put("liv", new ConsultaUsuario());
        comandos.put("ntf", new ConsultaLivro());
        comandos.put("usu", new ConsultaObserver());
        return comandos;
    }
}
