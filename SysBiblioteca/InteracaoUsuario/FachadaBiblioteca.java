
/*
* Classe fachada do sistema que possui os métodos que realizam cada comando dado pelo usuario atraves da Classe InterfaceUsuario
* um Singleton
*/
import java.util.ArrayList;

public class FachadaBiblioteca {

    public static FachadaBiblioteca instance;

    private FachadaBiblioteca() {}

    public static FachadaBiblioteca getInstance() {
        if(instance == null) {
            synchronized(FachadaBiblioteca.class) {
                if(instance == null) {
                    instance = new FachadaBiblioteca();
                }
            }
        }
        return instance;
    }

    public void realizarEmprestimo(ArrayList<String> parametroParaExecutar) {
        
        String identificadorUsuario = parametroParaExecutar.get(0);
        String identificadorLivro = parametroParaExecutar.get(1);

        int indexDoLivro = BuscaLivro.buscaIndexDoLivro(identificadorLivro);
        int indexDoUsuario = BuscaUsuario.buscaIndexDoUsuario(identificadorUsuario);

        if(indexDoLivro != -1) {
            Livro livro = CarregaLivros.getLivrosDoSistema().get(indexDoLivro);
            if(indexDoUsuario != -1) {
                Usuario usuario = CarregaUsuarios.getUsuariosDoSistema().get(indexDoUsuario);
                MensagensFachadaBiblioteca.mensagemOperacaoEmprestimo();
                usuario.realizaEmprestimo(livro);
            } else {
                MensagensBuscaUsuario.mensagemUsuarioNaoEncontrado();
            }
        } else {
            MensagensBuscaLivro.mensagemLivroNaoEncontrado();
        }
    }

    public void realizarDevolucao(ArrayList<String> parametroParaExecutar) {
       
        String identificadorUsuario = parametroParaExecutar.get(0);
        String identificadorLivro = parametroParaExecutar.get(1);

        int indexDoLivro = BuscaLivro.buscaIndexDoLivro(identificadorLivro);
        int indexDoUsuario = BuscaUsuario.buscaIndexDoUsuario(identificadorUsuario);

        if(indexDoLivro != -1) {
            Livro livro = CarregaLivros.getLivrosDoSistema().get(indexDoLivro);
            if(indexDoUsuario != -1) {
                Usuario usuario = CarregaUsuarios.getUsuariosDoSistema().get(indexDoUsuario);
                MensagensFachadaBiblioteca.mensagemOperacaoDevolucao();
                usuario.realizaDevolucao(livro);
            } else {
                MensagensBuscaUsuario.mensagemUsuarioNaoEncontrado();
            }
        } else {
            MensagensBuscaLivro.mensagemLivroNaoEncontrado();
        }
    }

    public void realizarReserva(ArrayList<String> parametroParaExecutar) { 
        
        String identificadorUsuario = parametroParaExecutar.get(0);
        String identificadorLivro = parametroParaExecutar.get(1);
        int indexDoLivro = BuscaLivro.buscaIndexDoLivro(identificadorLivro);
        int indexDoUsuario = BuscaUsuario.buscaIndexDoUsuario(identificadorUsuario);
        if(indexDoLivro != -1) {
            Livro livro = CarregaLivros.getLivrosDoSistema().get(indexDoLivro);
            if(indexDoUsuario != -1) {
                Usuario usuario = CarregaUsuarios.getUsuariosDoSistema().get(indexDoUsuario);
                MensagensFachadaBiblioteca.mensagemOperacaoReserva();
                usuario.realizaReserva(livro);
            } else {
                MensagensBuscaUsuario.mensagemUsuarioNaoEncontrado();
            }
        } else {
            MensagensBuscaLivro.mensagemLivroNaoEncontrado();
        }
    }

    public void realizarObservacao(ArrayList<String> parametroParaExecutar) {
        
        String identificadorUsuario = parametroParaExecutar.get(0);
        String identificadorLivro = parametroParaExecutar.get(1);
        int indexDoLivro = BuscaLivro.buscaIndexDoLivro(identificadorLivro);
        int indexDoUsuario = BuscaUsuario.buscaIndexDoUsuario(identificadorUsuario);
        if(indexDoLivro != -1) {
            Livro livro = CarregaLivros.getLivrosDoSistema().get(indexDoLivro);
            if(indexDoUsuario != -1) {
                Usuario usuario = CarregaUsuarios.getUsuariosDoSistema().get(indexDoUsuario);
                usuario.getEstadoUsuario().adicionarObserver(livro, usuario, usuario);
            } else {
                MensagensBuscaUsuario.mensagemUsuarioNaoEncontrado();
            }
        } else {
            MensagensBuscaLivro.mensagemLivroNaoEncontrado();
        }
    }

    public void realizarConsultaLivro(ArrayList<String> parametroParaExecutar) {
       
        String identificadorLivro = parametroParaExecutar.get(0);
        int indexDoLivro = BuscaLivro.buscaIndexDoLivro(identificadorLivro);
        if(indexDoLivro != -1) {
            Livro livro = CarregaLivros.getLivrosDoSistema().get(indexDoLivro);
            MensagensFachadaBiblioteca.mensagemConsultaDadosLivro();
            livro.consultarLivro();
        } else {
            MensagensBuscaLivro.mensagemLivroNaoEncontrado();
        }
    }

    public void realizarConsultaUsuario(ArrayList<String> parametroParaExecutar){
       
        String identificadorUsuario = parametroParaExecutar.get(0);
        int indexDoUsuario = BuscaUsuario.buscaIndexDoUsuario(identificadorUsuario);
        if(indexDoUsuario != -1) {
            Usuario usuario = CarregaUsuarios.getUsuariosDoSistema().get(indexDoUsuario);
            MensagensFachadaBiblioteca.mensagemConsultaDadosUsuario();
            usuario.consultarUsuario();
        } else {
            MensagensBuscaUsuario.mensagemUsuarioNaoEncontrado();
        }
    }

    public void realizarConsultaObserver(ArrayList<String> parametroParaExecutar){
       
        String identificadorUsuario = parametroParaExecutar.get(0);
        int indexDoProfessor = BuscaUsuario.buscaIndexDoUsuario(identificadorUsuario);

        if(indexDoProfessor != -1) {
            Usuario usuario = CarregaUsuarios.getUsuariosDoSistema().get(indexDoProfessor);
            MensagensFachadaBiblioteca.mensagemConsultaDadosProfessor();
            usuario.getEstadoUsuario().consultarObserver(usuario);
        } else {
            MensagensBuscaUsuario.mensagemUsuarioNaoEncontrado();
        }
    }
}
