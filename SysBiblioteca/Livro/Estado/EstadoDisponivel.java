
/*
* Classe que especifica Estado do Livro como Disponivel de acordo com o Padrao de Projeto State
* Esta classe é um Singleton
*/


public class EstadoDisponivel implements IEstadoLivro {
    private EstadoDisponivel() {}

    public static EstadoDisponivel instance;

    public static EstadoDisponivel getInstance() {
        if(instance == null) {
            synchronized(EstadoDisponivel.class) {
                if(instance == null) {
                    instance = new EstadoDisponivel();
                }
            }
        }
        return instance;
    }

    @Override
    public void emprestarLivro(Exemplar exemplar, Usuario usuario) {
        usuario.adicionaNaListaDeEmprestados(exemplar);
        if(usuario.verificaSeJaTemOLivroReservado(exemplar.getLivro())){
            usuario.removeDaListaDeReservados(exemplar.getLivro());
            TransacaoReserva.FinalizarReserva(exemplar.getLivro(), usuario);
        }
        exemplar.mudaEstado(EstadoEmprestado.getInstance());
        TransacaoEmprestimo.adicionarEmprestimoAtual(exemplar, usuario);
        MensagensSingletonDisponivel.mensagemEmprestimoDoLivroFeito(exemplar.getLivro(), usuario);
    }

    @Override
    public void devolverLivro(Exemplar exemplar, Usuario usuario) {
        MensagensSingletonDisponivel.mensagemNaoDevolverPoqueEstaDisponivel();
    }
    
    public String imprimirEstado() {
        return "Disponivel.";
    }
}
