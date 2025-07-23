public class MensagensObservers {
    public static void mensagemAdicaoDeLivroNaListaDeObservador(Livro livro, Usuario usuario) {
        System.out.println("O usu" + usuario.getNome() + " adicionou o livro " + livro.getTitulo() + " na sua lista de observados.");
    }

    public static void mensagemJaObserva(Livro livro, Usuario usuario) {
        System.out.println("O usu" + usuario.getNome() + " jobserva o livro " + livro.getTitulo() + ".");
    }

    public static void mensagemDeNotificacao(Usuario usuario) {
        System.out.println("O usu" + usuario.getNome() + " foi notificado " + usuario.getQuantidadeDeNotificacoes() + " vezes.");
    }
}
