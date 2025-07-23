

/*
* Classe que Carrega os Livros e Exemplares do sistema.
* */



import java.util.ArrayList;

public class CarregaLivros {
    private static ArrayList<Livro> livrosDoSistema = new ArrayList<Livro>();

    public static void carregarLivrosSistema() {
        Livro l1 = new Livro("100", "Engenharia de Software", "AddisonWesley", "Ian Sommervile",
                6, 2000);

        Livro l2 = new Livro("101", "UML - Guia do Usu", "Campus",
                "Grady Booch, James Rumbaugh, Ivar Jacobson", 7, 2000);

        Livro l3 = new Livro("200", "Code Complete", "Microsoft Press", "Steve McConnel",
                2, 2014);

        Livro l4 = new Livro("201", "Agile Software Development, Principles, Patterns and pratices",
                "Prentice Hall", "Robert Martin", 1, 2002);

        Livro l5 = new Livro("300", "Refactoring: Improving the Design of Existing Code",
                "Addison-Wesley Professional", "Martin Fowler", 1, 1999);

        Livro l6 = new Livro("301", "Software Metrics: A Rigorous and pratical approach",
                "CRC Press", "Norman Fenton, James Bieman", 3, 2014);

        Livro l7 = new Livro("400", "Design Patterns: Elements of Reusable Object-Oriented Software",
                "Addison-Wesley Professional", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides",
                1, 1994);

        Livro l8 = new Livro("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language",
                "Addison-Wesley Professional", "Martin Fowler", 3, 2003);

        criaExemplares(l1, l2, l3, l4, l5, l7);
        addLivrosNoSistema(l1, l2, l3, l4, l5, l6, l7, l8);
    }

    /*
    * Metodo que adiciona Exemplares dos livros no sistema
    * */
    private static void criaExemplares(Livro l1, Livro l2, Livro l3, Livro l4, Livro l5, Livro l7) {
        l1.adicionaExemplar(new Exemplar(l1,"01", EstadoDisponivel.getInstance()));
        l1.adicionaExemplar(new Exemplar(l1,"02", EstadoDisponivel.getInstance()));
        l2.adicionaExemplar(new Exemplar(l2,"03", EstadoDisponivel.getInstance()));
        l3.adicionaExemplar(new Exemplar(l3,"04", EstadoDisponivel.getInstance()));
        l4.adicionaExemplar(new Exemplar(l4,"05", EstadoDisponivel.getInstance()));
        l5.adicionaExemplar(new Exemplar(l5,"06", EstadoDisponivel.getInstance()));
        l5.adicionaExemplar(new Exemplar(l5,"07", EstadoDisponivel.getInstance()));
        l7.adicionaExemplar(new Exemplar(l7,"08", EstadoDisponivel.getInstance()));
        l7.adicionaExemplar(new Exemplar(l7,"09", EstadoDisponivel.getInstance()));
    }

    /*
    * Metodo que adiciona os livros inicializados no sistema.
    * */
    private static void addLivrosNoSistema(Livro l1, Livro l2, Livro l3, Livro l4, Livro l5, Livro l6, Livro l7, Livro l8) {
        CarregaLivros.livrosDoSistema.add(l1);
        CarregaLivros.livrosDoSistema.add(l2);
        CarregaLivros.livrosDoSistema.add(l3);
        CarregaLivros.livrosDoSistema.add(l4);
        CarregaLivros.livrosDoSistema.add(l5);
        CarregaLivros.livrosDoSistema.add(l6);
        CarregaLivros.livrosDoSistema.add(l7);
        CarregaLivros.livrosDoSistema.add(l8);
    }

    /*
    * Metodo que remove um livro no sistema.
    * */
    private void removeLivroNoSistema(int i) {
        CarregaLivros.livrosDoSistema.remove(i);
    }

    public static ArrayList<Livro> getLivrosDoSistema() {
        return livrosDoSistema;
    }

    public static void setLivrosDoSistema(ArrayList<Livro> livrosDoSistema) {
        CarregaLivros.livrosDoSistema = livrosDoSistema;
    }
}
