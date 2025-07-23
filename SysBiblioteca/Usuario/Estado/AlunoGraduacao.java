/*
* Singleton Tipo Aluno de Graduação tendo como base o Padrão State
* */
public class AlunoGraduacao implements IEstadoUsuario {
    private AlunoGraduacao() {}
    private final int quantidadeDeLivrosMaximaEmprestimo = 3;
    public static AlunoGraduacao instance;

    public static AlunoGraduacao getInstance() {
        if(instance == null) {
            synchronized(AlunoGraduacao.class) {
                if(instance == null) {
                    instance = new AlunoGraduacao();
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
        return 3;
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
