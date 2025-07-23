

/*
 * Classe que especifo Estado do Livro como Emprestado 
 */


import java.time.LocalDate;

public class EstadoEmprestado implements IEstadoLivro {
    private EstadoEmprestado() {}

    public static EstadoEmprestado instance;

    public static EstadoEmprestado getInstance() {
        if(instance == null) {
            synchronized(EstadoEmprestado.class) {
                if(instance == null) {
                    instance = new EstadoEmprestado();
                }
            }
        }
        return instance;
    }

    @Override
    public void emprestarLivro(Exemplar exemplar, Usuario usuario) {
        MensagensSingletonEmprestado.mensagemLivroJaFoiEmprestado();
    }

    @Override
    public void devolverLivro(Exemplar exemplar, Usuario usuario) {
        if(LocalDate.now().isAfter(TransacaoEmprestimo.encontrarTransacaoEmprestimoAtuais(exemplar)
                .getData().plusDays(usuario.getEstadoUsuario().diasParaEntrega()))) {
            usuario.setDevedor(true);
        }
        usuario.removeDaListaDeEmprestados(exemplar);
        exemplar.mudaEstado(EstadoDisponivel.getInstance());
        TransacaoEmprestimo.FinalizarEmprestimo(exemplar);
        MensagensSingletonEmprestado.mensagemDevolucaoDoLivro(exemplar.getLivro(), usuario);
    }

    public String imprimirEstado() {
        return "Emprestado";
    }
}
