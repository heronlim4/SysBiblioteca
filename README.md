# Sistema de Gerenciamento de Biblioteca

Este projeto foi desenvolvido como parte da disciplina **Engenharia de Software 1**, com o objetivo de aplicar conceitos fundamentais de orientação a objetos e padrões de projeto na construção de um sistema de gerenciamento de biblioteca.

## Descrição Geral

O sistema modela uma biblioteca com funcionalidades como empréstimos, devoluções, reservas de livros, notificações, comandos interativos e diferentes tipos de usuários, como Professores, Alunos de Graduação e Alunos de Pós-Graduação.

A arquitetura do projeto faz uso extensivo de **padrões de projeto** para garantir modularidade, coesão, reutilização e manutenção facilitada.

---

## Usuários

Os códigos das classes `Usuario` e da interface `IEstadoUsuario` estão diretamente relacionados e implementam a interface `IUsuario`, que define os métodos e atributos comuns aos usuários do sistema, como realizar empréstimo, devolução e reserva de livros.

- **`Usuario`**: Implementa os métodos de `IUsuario` com lógica específica para ações como verificação de disponibilidade e tratamento de reservas simultâneas.
- **`IEstadoUsuario`**: Aplica o padrão **State**, permitindo que diferentes tipos de usuário (Professor, AlunoDeGraduacao, AlunoDePosGraduacao) implementem comportamentos distintos para empréstimo, devolução e reserva.
- **Professor**: Implementa o padrão **Observer**, sendo notificado sobre mudanças como disponibilidade de livros ou alterações de reserva.

---

## Mensageiros

A criação de diversas classes mensageiras com métodos de pesquisa e impressão de dados usa o padrão **Strategy**, permitindo:
- Definição de diferentes estratégias para tratamento de mensagens;
- Encapsulamento de abordagens distintas em classes intercambiáveis;
- Flexibilidade, extensibilidade e modularidade.

---

## Livros

Semelhante ao comportamento dos usuários, a modelagem dos livros também faz uso do padrão **State**:

- **`IEstadoLivro`**: Interface que define os comportamentos esperados dos estados.
- **`EstadoDisponivel`**: Representa o estado em que o livro pode ser emprestado.
- **`EstadoEmprestimo`**: Representa o estado de um livro atualmente emprestado.

---

## Interação com o Usuário

- **`FachadaBiblioteca`**: Implementa o padrão **Facade** e **Singleton**, fornecendo uma interface única e simplificada para interação com o sistema.
- **`InterfaceUsuario`**: Também usa o padrão **Singleton** com inicialização segura (Double-Checked Locking). É responsável por interpretar comandos digitados pelo usuário.
- **`InicializadorComandos`**: Inicializa e associa comandos disponíveis a suas classes correspondentes via `HashMap`.

### Relação entre as classes

- `InterfaceUsuario` chama `InicializadorComandos` para obter os comandos.
- Cada comando (como `Emprestimo`, `Devolucao`, `Reserva`, etc.) implementa a interface **Command**.
- `InterfaceUsuario` executa os comandos por meio do `HashMap`.

---

## Buscadores

Relacionam-se com classes **Carregadoras**, responsáveis por manter objetos do tipo `Livro` e `Usuario`, atuando em conjunto para a realização das buscas no sistema.

---

## Conceitos e Padrões Utilizados

- **Encapsulamento**: Classes encapsulam dados e comportamentos, mantendo uma interface limpa.
- **Abstração**: Representações conceituais claras (usuários, livros, transações).
- **Polimorfismo**: Uso de uma mesma interface (`Command`) para diferentes comandos executados de forma uniforme.
- **Singleton**: Aplicado nas classes `FachadaBiblioteca`, `InterfaceUsuario` e classes de estado.
- **Observer**: Professores recebem notificações sobre reservas simultâneas.
- **Command**: Encapsulamento de ações como comandos executáveis de forma desacoplada.
- **State**: Gerenciamento dos diferentes estados dos usuários e dos livros.
- **Facade**: Classe `FachadaBiblioteca` oferece uma interface única para operações complexas.
- **Strategy**: Aplicado nas mensagens para flexibilizar a maneira como os dados são buscados e exibidos.
- **Divisão de Responsabilidades**: Segue o princípio da separação de preocupações, com classes bem definidas e específicas.

