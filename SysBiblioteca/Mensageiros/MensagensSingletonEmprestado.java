public class MensagensSingletonEmprestado {
    public static void mensagemLivroJaFoiEmprestado() {
        System.out.println("Nhcomo pegar emprestado um livro que jestemprestado.");
    }

    public static void mensagemDevolucaoDoLivro(Livro livro, Usuario usuario) {
        System.out.println("O usu" + usuario.getNome() + " devolveu o livro " + livro.getTitulo() + ".");
    }
}
