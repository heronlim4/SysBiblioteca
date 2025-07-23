

/*
public class Professor implements IEstadoUsuario {
    private Professor() {}
    public static Professor instance;
    public static Professor getInstance() {
        if(instance == null) {
            synchronized(Professor.class) {
                if(instance == null) {
                    instance = new Professor();
                }
            }
        }
        return instance;
    }

    @Override
    public void pegarLivroEmprestado(Livro livro, Usuario usuario) {
        livro.pegarLivroEmprestado(usuario);
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
        return 7;
    }

    @Override
    public void adicionarObserver(Livro livro, Observer observer, Usuario usuario) {
        if(livro.verificaObserver(observer)){
            livro.adicionarObserver(observer);
            MensagensObservers.mensagemAdicaoDeLivroNaListaDeObservador(livro, usuario);
        }
        else{
            MensagensObservers.mensagemJaObserva(livro, usuario);
        }
    }

    @Override
    public void consultarObserver(Usuario usuario) {
        MensagensObservers.mensagemDeNotificacao(usuario);
    }

}
