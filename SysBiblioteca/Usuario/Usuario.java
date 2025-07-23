import java.util.ArrayList;

public class Usuario implements IUsuario {
    private String identificador;
    private String nome;
    private boolean isDevedor;
    private IEstadoUsuario estadoUsuario;
    private int quantidadeDeNotificacoes;

    /*
    * Listas que conta os livros emprestados e os livros reservados (respectivamente)
    */
    private ArrayList<Exemplar> listaDeLivrosEmprestados;
    private ArrayList<Livro> listaDeReservados;

    public Usuario(String identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
        this.quantidadeDeNotificacoes = 0;
        this.listaDeLivrosEmprestados = new ArrayList<Exemplar>();
        this.listaDeReservados = new ArrayList<Livro>();
        this.isDevedor = false;
    }

    private boolean verificaSeJaTemOLivroEmprestado(Livro livro) {
        for(Exemplar exemplar: this.listaDeLivrosEmprestados) {
            if(exemplar.getLivro().getId().equals(livro.getId())) {
                return true;
            }
        }
        return false;
    }

    public boolean verificaSeJaTemOLivroReservado(Livro livro) {
        for(Livro livroReservado: this.listaDeReservados) {
            if(livroReservado.getId().equals(livro.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void realizaEmprestimo(Livro livro) {
        if(livro.getQuantidadeExemplares() == 0){
            MensagensUser.mensagemDeNaoExistenciaDeExemplar(livro);
        } else if(verificaSeJaTemOLivroEmprestado(livro)) {
            MensagensUser.mensagemOperacaoJaFeitaComLivro(livro, this, "Emprestado");
        } else if(this.isDevedor) {
            MensagensUser.mensagemDeInadimplencia(this);
        } else {
            this.estadoUsuario.pegarLivroEmprestado(livro, this);
        }
    }

    @Override
    public void realizaDevolucao(Livro livro) {
        if(this.listaDeLivrosEmprestados.size() == 0) {
            MensagensUser.mensagemNaoHaLivroParaDevolver(this);
        } else if(!this.verificaSeJaTemOLivroEmprestado(livro)) {
            MensagensUser.mensagemLivroNaoEstaNaListaDeEmprestados(livro, this);
        } else {
            this.estadoUsuario.devolverLivroEmprestado(livro, this);
        }
    }

    @Override
    public void realizaReserva(Livro livro) {
        if(verificaSeJaTemOLivroReservado(livro)) {
            MensagensUser.mensagemOperacaoJaFeitaComLivro(livro, this," reservado.");
        } else if(this.isDevedor) {
            MensagensUser.mensagemDeInadimplencia(this);
        } else if(verificaSeJaTemOLivroEmprestado(livro)){
            MensagensUser.mensagemOperacaoJaFeitaComLivro(livro, this, " emprestado.");
        } else {
            this.estadoUsuario.reservarLivro(livro, this);
        }
    }

    private boolean isImprimirDadosDeEmprestimosAtivos(boolean interacao) {
        String estadoEmCurso = "Em curso";
        for(Exemplar exemplar: this.listaDeLivrosEmprestados){
            for(TransacaoEmprestimo transacaoEmprestimo : TransacaoEmprestimo.getEmprestimosAtuais()){
                if(exemplar.equals(transacaoEmprestimo.getExemplar())){
                  ImprimirDadosOperacoes.imprimirDadosEmprestimos(transacaoEmprestimo);
                  interacao = true;
                }
            }
        }
        return interacao;
    }

    private boolean isImprimirDadosDeEmprestimosFinalizados(boolean interacao){
        String estadoFinalizado = "Finalizado";
        for (TransacaoEmprestimo transacaoEmprestimo : TransacaoEmprestimo.getEmprestimosFinalizados()) {
            if (transacaoEmprestimo.getUsuario().equals(this)) {
                ImprimirDadosOperacoes.imprimirDadosEmprestimos(transacaoEmprestimo);
                interacao = true;
            }
        }
        return interacao;
    }

    private boolean isImprimirDadosDeReservas(boolean interacao) {
        for(Livro livro: this.listaDeReservados){
            for(TransacaoReserva transacaoReserva : TransacaoReserva.getReservas()) {
                if (livro.equals(transacaoReserva.getLivro())) {
                    ImprimirDadosOperacoes.imprimirDadosDeReservas(transacaoReserva);
                    interacao = true;
                }
            }
        }
        return interacao;
    }

    private void ImprimirDadosDeEmprestimosAtivosEFinalizadosEReservas(boolean interacao) {
        if(this.listaDeLivrosEmprestados.size() > 0){
            interacao = isImprimirDadosDeEmprestimosAtivos(interacao);
        }
        if(TransacaoEmprestimo.quantidadeEmprestimosFinalizados(this) > 0){
            interacao = isImprimirDadosDeEmprestimosFinalizados(interacao);
        }
        if(this.listaDeReservados.size() > 0){
            interacao = isImprimirDadosDeReservas(interacao);
        }
        if(!interacao){
            MensagensUser.mensagemDeNaoExistenciaDeOperacoes();
        }
    }

    @Override
    public void consultarUsuario(){
        boolean interacao = false;
        MensagensUser.imprimirNomeUsuario(this);
        ImprimirDadosDeEmprestimosAtivosEFinalizadosEReservas(interacao);
    }

    @Override
    public void avisarReservasSimultaneas() {
        this.quantidadeDeNotificacoes++;
    }

    @Override
    public void setTipoDeUsuario(IEstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    @Override
    public void adicionaNaListaDeEmprestados(Exemplar exemplar) {
        this.listaDeLivrosEmprestados.add(exemplar);
    }

    @Override
    public void removeDaListaDeEmprestados(Exemplar exemplar) {
        this.listaDeLivrosEmprestados.remove(exemplar);
    }

    @Override
    public void adicionaNaListaDeReservados(Livro livro) {
        this.listaDeReservados.add(livro);
    }

    @Override
    public void removeDaListaDeReservados(Livro livro) {
        this.listaDeReservados.remove(livro);
    }

    @Override
    public String getIdentificador() {
        return identificador;
    }

    @Override
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean isDevedor() {
        return isDevedor;
    }

    @Override
    public void setDevedor(boolean devedor) {
        isDevedor = devedor;
    }

    @Override
    public IEstadoUsuario getEstadoUsuario() {
        return estadoUsuario;
    }

    @Override
    public void setEstadoUsuario(IEstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    @Override
    public int getQuantidadeDeNotificacoes() {
        return quantidadeDeNotificacoes;
    }

    @Override
    public void setQuantidadeDeNotificacoes(int quantidadeDeNotificacoes) {
        this.quantidadeDeNotificacoes = quantidadeDeNotificacoes;
    }

    @Override
    public ArrayList<Exemplar> getListaDeLivrosEmprestados() {
        return listaDeLivrosEmprestados;
    }

    @Override
    public void setListaDeLivrosEmprestados(ArrayList<Exemplar> listaDeLivrosEmprestados) {
        this.listaDeLivrosEmprestados = listaDeLivrosEmprestados;
    }


    @Override
    public ArrayList<Livro> getListaDeReservados() {
        return listaDeReservados;
    }

    @Override
    public void setListaDeReservados(ArrayList<Livro> listaDeReservados) {
        this.listaDeReservados = listaDeReservados;
    }
}
