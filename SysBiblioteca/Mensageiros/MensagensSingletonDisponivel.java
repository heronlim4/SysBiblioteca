public class MensagensSingletonDisponivel {
    public static void mensagemEmprestimoDoLivroFeito(Livro livro, Usuario usuario) {
        System.out.println("O usu" + usuario.getNome() + " fez emprdo livro " +
                livro.getTitulo() + ".");
    }

    public static void mensagemNaoDevolverPoqueEstaDisponivel() {
        System.out.println("Vocnpode devolver um exemplar que estdispon");
    }
}
