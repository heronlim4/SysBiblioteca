public class MensagensUser {
  public static void imprimirNomeUsuario(Usuario usuario) {
        System.out.println(usuario.getNome());
    }

    public static void mensagemDeNaoExistenciaDeExemplar(Livro livro) {
        System.out.println("Nexiste exemplar do livro "+ livro.getTitulo() + ".");
    }

    public static void mensagemOperacaoJaFeitaComLivro(Livro livro, Usuario usuario, String estado) {
        System.out.println("Usu" + usuario.getNome() + " ja tem um exemplar do livro " + livro.getTitulo() + " " + estado);
    }

    public static void mensagemDeInadimplencia(Usuario usuario) {
        System.out.println("O usu" + usuario.getNome() + " devedor na Biblioteca");
    }

    public static void mensagemNaoHaLivroParaDevolver(Usuario usuario) {
        System.out.println("Usu" + usuario.getNome() + " ntlivros para devolver.");
    }

    public static void mensagemLivroNaoEstaNaListaDeEmprestados(Livro livro, Usuario usuario) {
        System.out.println("O livro " + livro.getTitulo() + " nestna lista de emprestados do usu" + usuario.getNome() + ".");
    }

    public static void mensagemDeNaoExistenciaDeOperacoes() {
        System.out.println("Nhemprativos, emprfinalizados ou reservas.");
    }
}
