import java.util.ArrayList;

public interface IUsuario extends Observer {

    void realizaEmprestimo(Livro livro);

    void realizaDevolucao(Livro livro);

    void realizaReserva(Livro livro);

    void consultarUsuario();

    void avisarReservasSimultaneas();

    void setTipoDeUsuario(IEstadoUsuario estadoUsuario);

    void adicionaNaListaDeEmprestados(Exemplar exemplar);
  
    void removeDaListaDeEmprestados(Exemplar exemplar);

    void adicionaNaListaDeReservados(Livro livro);

    void removeDaListaDeReservados(Livro livro);

    String getIdentificador();

    void setIdentificador(String identificador);

    String getNome();

    void setNome(String nome);

    boolean isDevedor();

    void setDevedor(boolean devedor);

    IEstadoUsuario getEstadoUsuario();

    void setEstadoUsuario(IEstadoUsuario estadoUsuario);

    int getQuantidadeDeNotificacoes();

    void setQuantidadeDeNotificacoes(int quantidadeDeNotificacoes);

    ArrayList<Exemplar> getListaDeLivrosEmprestados();

    void setListaDeLivrosEmprestados(ArrayList<Exemplar> listaDeLivrosEmprestados);

    ArrayList<Livro> getListaDeReservados();

    void setListaDeReservados(ArrayList<Livro> listaDeReservados);
}
