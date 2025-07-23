/*
* Singleton de Tipo Aluno de Pos como base o Padrde Projeto State
* */
public class AlunoPosGraduacao implements IEstadoUsuario {
    private AlunoPosGraduacao() {}

    public static AlunoPosGraduacao instance;
    private final int quantidadeDeLivrosMaximaEmprestimo = 4;

    public static AlunoPosGraduacao getInstance() {
        if(instance == null) {
            synchronized(AlunoPosGraduacao.class) {
                if(instance == null) {
                    instance = new AlunoPosGraduacao();
                }
            }
        }
        return instance;
    }

    @Override
    public void pegarLivroEmprestado(Livro livro, Usuario usuario) {
        MetodosGeraisDeUsuarios.emprestimoParaAlunos(livro, usuario, this.getQuantidadeDeLivrosMaximaEmprestimo());
    }

    @Override
    public void devolverLivroEmprestado(Livro livro, Usuario usuario) {
        livro.devolverLivroEmprestado(usuario);
    }

    @Override
    public void reservarLivro(Livro livro, Usuario usuario) {
        MetodosGeraisDeUsuarios.reservaParaUsuario(livro, usuario);
    }

    @Override
    public int diasParaEntrega() {
        return 4;
    }

    @Override
    public void adicionarObserver(Livro livro, Observer observer, Usuario usuario) {
        MensagensNaoObservers.mensagemErroAdicaoListaDeObservadores(livro, usuario);
    }

    @Override
    public void consultarObserver(Usuario usuario) {
        MensagensNaoObservers.mensagemErroConsultaObserver(usuario);
    }

    public int getQuantidadeDeLivrosMaximaEmprestimo() {
        return quantidadeDeLivrosMaximaEmprestimo;
    }
}
