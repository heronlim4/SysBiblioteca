import java.util.ArrayList;

public class Livro implements Subject {
    private String id;
    private String titulo;
    private String editora;
    private String autores;
    private String edicao;
    private int anoDePublicacao;

    private ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();
    private final ArrayList<Observer> observadores = new ArrayList<Observer>();

    public Livro(String id, String titulo, String editora, String autores, String edicao, int anoDePublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoDePublicacao = anoDePublicacao;
    }

    public void adicionaExemplar(Exemplar exemplar) {
        this.exemplares.add(exemplar);
    }

    private Exemplar obterExemplarDisponivel() {
        for(Exemplar exemplar: this.exemplares) {
            if(exemplar.getEstadoExemplar().imprimirEstado().equals("Disponivel.")){
                return exemplar;
            }
        }
        return null;
    }

    public void pegarLivroEmprestado(Usuario usuario){
        if(TransacaoReserva.quantidadeReserva(this) >= this.getQuantidadeExemplares()){
            if(!usuario.verificaSeJaTemOLivroReservado(this)){                MensagensLivro.mensagemPossuiMaisReservasQueExemplares(this, usuario);
            } else{
                this.obterExemplarDisponivel().getEstadoExemplar().emprestarLivro(this.obterExemplarDisponivel(), usuario);
            }
        } else {
            if(obterExemplarDisponivel() != null) {
                this.obterExemplarDisponivel().getEstadoExemplar().emprestarLivro(this.obterExemplarDisponivel(), usuario);
            } else {
                MensagensLivro.mensagemNaoHaExemplaresDisponiveis();
            }
        }
    }

    public void devolverLivroEmprestado(Usuario usuario) {
        for(Exemplar exemplarDoLivro: this.exemplares) {
            for (Exemplar exemplarEmprestado: usuario.getListaDeLivrosEmprestados()) {
                if(exemplarDoLivro.getCodigoExemplar().equals(exemplarEmprestado.getCodigoExemplar())) {
                    exemplarDoLivro.getEstadoExemplar().devolverLivro(exemplarDoLivro, usuario);
                    return;
                }
            }
        }
    }

    public void reservarLivro(Usuario usuario) {
        TransacaoReserva.adicionarReserva(this, usuario);
        usuario.getListaDeReservados().add(this);
        MensagensLivro.mensagemReservaDoLivroFeitaPeloUsuario(this, usuario);
        if (TransacaoReserva.quantidadeReserva(this) >= 3) { //se passou de 2 reservas, notifica o professor
            this.notificarObserver();
        }
    }

    public void consultarLivro() {
        ImprimeDadosLivro.imprimeCabecalho(this);
        if(TransacaoReserva.quantidadeReserva(this) > 0){         TransacaoReserva.imprimirUsuariosReserva(this);
        }
        ImprimeDadosLivro.imprimeInformacoesDosExemplaresEmprestados(this.exemplares);
    }

    public void adicionarObserver(Observer observer) {
        this.observadores.add(observer);
    }
  
    public void notificarObserver() {
        for(Observer observer: this.observadores) {
            observer.avisarReservasSimultaneas();
        }
    }

    public int getQuantidadeExemplares(){
        return this.exemplares.size();
    }

    public boolean verificaObserver(Observer usuario){
        for(Observer observer: this.observadores){
            if(observer.equals(usuario)){
                return false;
            }
        }
        return true;
    }

    public ArrayList<Exemplar> getExemplares() {
        return exemplares;
    }

    public void setExemplares(ArrayList<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }

    public ArrayList<Observer> getObservadores() {
        return observadores;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAutores() {
        return autores;
    }


    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public void setAnoDePublicacao(int anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }
}