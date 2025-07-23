public class MetodosGeraisDeUsuarios {
    public static void reservaParaUsuario(Livro livro, Usuario usuario) {
        if(usuario.getListaDeReservados().size() < 3) {
            livro.reservarLivro(usuario);
        } else {
            MensagensUsuariosGerais.mensagemDeQuantidadeMaximaDeReservasFeitas(livro, usuario);
        }
    }

    public static void emprestimoParaAlunos(Livro livro, Usuario usuario, int quantidadeMaxima) {
        if(usuario.getListaDeLivrosEmprestados().size() == quantidadeMaxima){
            MensagensUsuariosGerais.mensagemDeQuantidadeMaximaDeReservasFeitas(livro, usuario);
        }
        else{
            livro.pegarLivroEmprestado(usuario);
        }
    }
}
