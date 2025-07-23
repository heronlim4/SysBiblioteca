
/*
* Classe que tem a responsabilidade de fazer o papel de interface do usuario, fazendo a leitura dos comandos
* digitados no console designando para as opera
* um Singleton porque faz sentido ser apenas uma interface para o programa 
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class InterfaceUsuario {
    /*
    * Constante que define o comando de sado programa, interrompendo o seu funcionamento.
    * Serve para comparar
    */
    public final String comandoDeSaidaDoPrograma = "sai";

    /*
    * Relaciona a InterfaceUsuario com o comando (abstrato).
    * */
    private HashMap<String, Command> comandos;

    public static InterfaceUsuario instance;
    private InterfaceUsuario() {}

    public static InterfaceUsuario getInstance() {
        if(instance == null) {
            synchronized(InterfaceUsuario.class) {
                if(instance == null) {
                    instance = new InterfaceUsuario();
                }
            }
        }
        return instance;
    }

    /*
    * Metodo que por meio do polimorfismo executa o comando especifico para cada comando passado pela
   */
    private void executarComando(String tipoDeComando[]) {
        ArrayList<String> parametroParaExecutar = new ArrayList<String>();

       
        Command comando = comandos.get(tipoDeComando[0]);
        if(comando != null) {
            comando.execute(parametroParaExecutar);
        } else {
            MensagensInterfaceUsuario.mensagemComandoNaoEncontrado();
        }
    }

    /*
    * Mque faz o split na string dada pelo usuario na interação feita no console.
    */
    private String[] obterEntradaDividida() throws IOException {
        String stringComando = obterComandoConsole();
        String divisaoComando[] = stringComando.split(" ");
        return divisaoComando;
    }

    private String obterComandoConsole() {
		// TODO Auto-generated method stub
		return null;
	}

    public void fazerLoopEntrada() throws IOException {
        comandos = InicializadorComandos.inicializarComandos();
        String divisaoComando[] = obterEntradaDividida();
        while (!divisaoComando[0].equals(this.comandoDeSaidaDoPrograma)) {
            executarComando(divisaoComando);
            divisaoComando = obterEntradaDividida();
        }
    }
}
