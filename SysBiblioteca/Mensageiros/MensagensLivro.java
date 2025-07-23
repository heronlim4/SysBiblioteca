

public class MensagensLivro {
    public static void mensagemPossuiMaisReservasQueExemplares(Livro livro, Usuario usuario) {
        System.out.println("O livro " + livro.getTitulo() + " possui mais reservas do que exemplares " +
                "e o usu" + usuario.getNome() + " npossui reserva.");
    }

    public static void mensagemReservaDoLivroFeitaPeloUsuario(Livro livro, Usuario usuario) {
        System.out.println("O usu" + usuario.getNome() + " fez a reserva do livro " + livro.getTitulo()
                + ".");
    }

    public static void mensagemAdicaoDeLivroNaListaDeObservador(Livro livro, Usuario usuario) {
        System.out.println("O professor " + usuario.getNome() + " adicionou o livro " + livro.getTitulo() + " na sua lista de observados.");
    }

    public static void mensagemNaoHaExemplaresDisponiveis() {
        System.out.println("Nhexemplares Dispon");
    }
}
