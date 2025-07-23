

import java.util.ArrayList;

public class ImprimirDadosLivro {
    public static void imprimeCabecalho(Livro livro) {
        System.out.println("T" + livro.getTitulo());
        System.out.println("Quantidade de reservas: " + TransacaoReserva.quantidadeReserva(livro));
    }

    public static void imprimeInformacoesDosExemplaresEmprestados(ArrayList<Exemplar> exemplares) {
        System.out.println("Exemplares: ");
        imprimeDadosDosExemplares(exemplares);
    }

    private static void imprimeDadosDosExemplares(ArrayList<Exemplar> exemplares) {
        for(Exemplar exemplar: exemplares){
            System.out.println("C" + exemplar.getCodigoExemplar());
            System.out.println("Estado: " + exemplar.getEstadoExemplar().imprimirEstado());
            imprimeDadosDeEmprestimos(exemplar);
        }
    }

    private static void imprimeDadosDeEmprestimos(Exemplar exemplar) {
        for(TransacaoEmprestimo transacaoEmprestimo : TransacaoEmprestimo.getEmprestimosAtuais()){
            if(exemplar.getCodigoExemplar().equals(transacaoEmprestimo.getExemplar().getCodigoExemplar())){
                System.out.println("Usuario: " + transacaoEmprestimo.getUsuario().getNome());
                System.out.println("Data de emprestimo: " + transacaoEmprestimo.getData());
                System.out.println("Data de entrega: " + transacaoEmprestimo.getData()
                        .plusDays(transacaoEmprestimo.getUsuario().getEstadoUsuario().diasParaEntrega()));
            }
        }
    }
}
