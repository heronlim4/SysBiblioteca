
/*
* Interface que define as funcionalidades especificas mplementadas pelos estados.
* Base do Padrao de Projeto State
*/


public interface IEstadoLivro {
    void emprestarLivro(Exemplar exemplar, Usuario usuario);
    void devolverLivro(Exemplar exemplar, Usuario usuario);
    String imprimirEstado();
}
