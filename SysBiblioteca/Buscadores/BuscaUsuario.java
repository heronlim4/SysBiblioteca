

public class BuscaUsuario {
    public static int buscaIndexDoUsuario(String identificacaoUsuario) {
        int index = 0;
        for(Usuario usuario : CarregaUsuarios.getUsuariosDoSistema()) {
            if(identificacaoUsuario.equals(usuario.getIdentificador())) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
