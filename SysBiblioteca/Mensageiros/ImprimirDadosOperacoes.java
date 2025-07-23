public class ImprimirDadosOperacoes {

    private static String retornaStringDeEstado(TransacaoEmprestimo transacaoEmprestimo) {
        if(transacaoEmprestimo.isEstaFinalizado()) {
            return "Finalizado";
        }
        return "Em curso";
    }

    public static void imprimirDadosEmprestimos(TransacaoEmprestimo transacaoEmprestimo) {
        String estadoDaTransacao = retornaStringDeEstado(transacaoEmprestimo);
        System.out.println("Titulo: " + transacaoEmprestimo.getExemplar().getLivro().getTitulo());
        System.out.println("Data do empr" + transacaoEmprestimo.getData());
        System.out.println("Estado: " + estadoDaTransacao);
        System.out.println("Data de devolu" + transacaoEmprestimo.getData().plusDays(transacaoEmprestimo.getUsuario().getEstadoUsuario().diasParaEntrega()));
    }

    public static void imprimirDadosDeReservas(TransacaoReserva transacaoReserva) {
        System.out.println("Titulo: " + transacaoReserva.getLivro().getTitulo());
        System.out.println("Data da reserva: " + transacaoReserva.getData());
    }
}
