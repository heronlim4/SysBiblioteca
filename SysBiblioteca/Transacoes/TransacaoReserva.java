import java.time.LocalDate;
import java.util.ArrayList;

public class TransacaoReserva {
    private Livro livro;
    private Usuario usuario;
    private LocalDate data;

    private static ArrayList<TransacaoReserva> reservas = new ArrayList<>();

    public TransacaoReserva(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.data = LocalDate.now();
    }

    public static void adicionarReserva(Livro livro, Usuario usuario) {
        TransacaoReserva.reservas.add(new TransacaoReserva(livro, usuario));
    }

    private static TransacaoReserva encontrarTransacaoReservas(Livro livro, Usuario usuario) {
        for(TransacaoReserva transacaoReserva : TransacaoReserva.reservas) {
            if(transacaoReserva.getLivro().equals(livro) && transacaoReserva.getUsuario().equals(usuario)){
                return transacaoReserva;
            }
        }
        return null;
    }

    public static void FinalizarReserva(Livro livro, Usuario usuario) {
        TransacaoReserva.reservas.remove(encontrarTransacaoReservas(livro, usuario));
    }

    public static int quantidadeReserva(Livro livro){
        int qtd = 0;
        for(TransacaoReserva transacaoReserva : TransacaoReserva.reservas) {
            if(transacaoReserva.getLivro().getId().equals(livro.getId())) {
                qtd++;
            }
        }
        return qtd;
    }

    public static void imprimirUsuariosReserva(Livro livro){
        for(TransacaoReserva transacaoReserva : TransacaoReserva.reservas) {
            if(transacaoReserva.getLivro().getId().equals(livro.getId())){
                MensagensTransacaoReserva.mensagemTransacaoReservaDoLivro(transacaoReserva);
            }
        }
    }
  
    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public static ArrayList<TransacaoReserva> getReservas() {
        return reservas;
    }

    public static void setReservas(ArrayList<TransacaoReserva> reservas) {
        TransacaoReserva.reservas = reservas;
    }
}
