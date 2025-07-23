public class Exemplar {
    private Livro livro;
    private String codigoExemplar;
    private IEstadoLivro estadoExemplar;

    public Exemplar(Livro livro, String codigoExemplar, IEstadoLivro estadoInicial) {
        this.livro = livro;
        this.codigoExemplar = codigoExemplar;
        this.estadoExemplar = estadoInicial;
    }

    public void mudaEstado(IEstadoLivro estadoExemplar) {
        this.estadoExemplar = estadoExemplar;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getCodigoExemplar() {
        return codigoExemplar;
    }

    public void setCodigoExemplar(String codigoExemplar) {
        this.codigoExemplar = codigoExemplar;
    }

    public IEstadoLivro getEstadoExemplar() {
        return estadoExemplar;
    }

    public void setEstadoExemplar(IEstadoLivro estadoExemplar) {
        this.estadoExemplar = estadoExemplar;
    }
}
