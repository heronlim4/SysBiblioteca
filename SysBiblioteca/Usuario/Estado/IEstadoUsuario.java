public interface IEstadoUsuario {
    public void pegarLivroEmprestado(Livro livro, Usuario usuario);
    public void devolverLivroEmprestado(Livro livro, Usuario usuario);
    public void reservarLivro(Livro livro, Usuario usuario);
    public int diasParaEntrega();
    public void adicionarObserver(Livro livro, Observer observer, Usuario usuario);
    public void consultarObserver(Usuario usuario);
}
