# Usuários:
Os códigos de Usuario e IEstadoUsuario estão diretamente relacionados. Ambos implementam a interface IUsuario, que define os métodos e atributos comuns aos usuários do sistema, como realizar empréstimo, devolução e reserva de livros.

O código 1 (classe Usuario) contém a implementação dos métodos da interface IUsuario e inclui a lógica para tratar as ações específicas do usuário, como verificar se o livro já está emprestado ou reservado, lidar com notificações de reservas simultâneas, etc.

O código 3 (interface IEstadoUsuario) é relacionado ao padrão State, pois define os métodos específicos que cada estado do usuário deve implementar. As classes Professor, AlunoDeGraduacao e AlunoDePosGraduacao podem implementar a interface IEstadoUsuario para definir seus próprios comportamentos em cada estado. Essa implementação permitiria que cada usuário tivesse diferentes regras de empréstimo, devolução e reserva de livros, bem como a definição de um período de dias para entrega de livros emprestados.

O professor, em particular, também utiliza o padrão Observer para receber notificações de mudanças nos livros. Isso permite que o Professor seja informado sobre eventos relevantes, como a disponibilidade de um livro ou alterações em reservas.

Em resumo, os códigos estão relacionados ao definir as interfaces e comportamentos comuns aos usuários e aos estados do usuário. O padrão State é aplicado através da interface IEstadoUsuario, permitindo que as classes Professor, AlunoDeGraduacao e AlunoDePosGraduacao implementem seus próprios comportamentos de acordo com cada estado. Além disso, o padrão Observer é utilizado pelo Professor para receber notificações sobre mudanças nos livros.

# Mensageiros:
Ao criar diversas classes mensageiras com métodos de pesquisa e/ou impressão de dados, utilizamos do padrão de projeto Strategy. Padrão que permite definir diferentes estratégias ou abordagens para tratar as mensagens, encapsulando cada uma delas em uma classe separada e tornando-as intercambiáveis em tempo de execução. Proporcionando flexibilidade, extensibilidade e modularidade ao código.

# Livros:
De forma semelhante aos usuários, a área relacionada a livro também utiliza do padrão State com a interface IEstadoLivro e as classes EstadoDisponivel e EstadoEmprestimo.
A classe EstadoDisponivel implementa a interface IEstadoLivro e representa o estado "Disponível" de um livro. Ela possui métodos para emprestar o livro, devolver o livro e imprimir o estado.
A classe EstadoEmprestimo também implementa a interface IEstadoLivro.

# Interação com o Usuário:
Fachada da Biblioteca - A classe FachadaBiblioteca é uma fachada do sistema que possui métodos que realizam as ações correspondentes a cada comando dado pelo usuário por meio da Classe InterfaceUsuario. Ela implementa o padrão de projeto Singleton.
InterfaceUsuario - O padrão de projeto utilizado nessa classe é o Singleton, que garante que exista apenas uma instância da classe InterfaceUsuario. Isso é feito através do método getInstance(), que utiliza o padrão de inicialização duplamente verificada (Double-Checked Locking) para garantir a criação da instância única de forma segura em ambientes concorrentes. Ela serve como a interface do usuário, lendo os comandos digitados no console e executando as operações correspondentes.
InicializadorComandos - possui o objetivo de inicializar os comandos existentes no sistema. Ela retorna um HashMap que relaciona cada comando (representado por uma string) com a instância correspondente da classe Command responsável por executar esse comando.

Relação entre as classes:

InterfaceUsuario possui uma referência para a classe InicializadorComandos. No método fazerLoopEntrada(), é chamado o método inicializarComandos() da classe InicializadorComandos para obter o HashMap de comandos disponíveis.

InicializadorComandos não possui uma relação direta com as outras classes. Ele é uma classe utilitária que fornece um método estático para inicializar os comandos.

Cada comando (Emprestimo, Reserva, Devolucao, Observacao, ConsultaUsuario, ConsultaLivro, ConsultaObserver) implementa a interface Command. Essas classes são instanciadas e associadas a uma string que representa o comando correspondente no HashMap retornado pelo método inicializarComandos(). Dessa forma, a classe InicializadorComandos relaciona os comandos com as instâncias correspondentes.

InterfaceUsuario utiliza o HashMap de comandos retornado por InicializadorComandos para realizar a execução dos comandos. No método executarComando(), a classe InterfaceUsuario busca o comando correspondente no HashMap e executa o método execute() da instância de Command associada a esse comando.

# Buscadores:
Se relacionando com as classes Carregadoras (responsáveis por guardar os objetos Livro e Usuario) para realizarem as buscas.





os conceitos e os padrões de projeto utilizados no sistema são os seguintes:

Encapsulamento: As classes encapsulam os dados e o comportamento relacionados, ocultando detalhes internos e fornecendo uma interface consistente para interagir com o sistema.

Abstração: O sistema é projetado com abstrações para representar entidades conceituais, como livros, usuários e transações. Essas abstrações simplificam a compreensão e a interação com o sistema.

Polimorfismo: O polimorfismo é utilizado para tratar diferentes tipos de comandos de forma uniforme na classe InterfaceUsuario. As transações são representadas por diferentes classes que implementam a mesma interface Command, permitindo que sejam executadas de maneira polimórfica.

Padrão Singleton: O padrão Singleton é aplicado nas classes FachadaBiblioteca, InterfaceUsuario e nas classes de estado, garantindo que apenas uma instância dessas classes seja criada durante a execução do programa.

Padrão Observer: O padrão Observer é utilizado na implementação da notificação de reservas simultâneas para professores. A classe Professor atua como um observador, sendo notificado quando mais de duas reservas simultâneas são feitas.

Padrão Command: O padrão Command é aplicado nas classes específicas de transações (Emprestimo, Devolucao, Reserva, Observacao) e na classe InicializadorComandos. Ele encapsula as operações como comandos e permite que sejam executadas de forma flexível, enfileiradas e desacopladas do emissor do comando.

Padrão State: O padrão State é utilizado nas classes de estado (EstadoDisponivel, EstadoEmprestado) para representar os diferentes estados em que um livro pode se encontrar (disponível ou emprestado). Essas classes encapsulam o comportamento associado a cada estado e permitem que o livro altere seu estado conforme as transações são realizadas.

Padrão Facade: A classe FachadaBiblioteca atua como uma fachada do sistema, fornecendo uma interface simplificada para interagir com as operações do sistema. Ela oculta a complexidade interna do sistema e simplifica o uso das funcionalidades.

Divisão de Responsabilidades: O sistema adota uma divisão clara de responsabilidades entre as diferentes classes, seguindo o princípio da separação de preocupações. Cada classe possui uma responsabilidade específica e colabora com outras classes para realizar as operações necessárias.
