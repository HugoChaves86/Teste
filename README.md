# Biblioteca
## O projeto "Biblioteca", simula um sistema de interação usuário-biblioteca, onde é possível realizar empréstimos, reservas, consultas, bem como outras pequenas funcionalidades. 
### O sistema foi implementado como um trabalho final de Engenharia de Software da Universidade Federal da Bahia, com os pré-requisitos de utilização de padrões de projeto (Design Patterns), sendo eles:
* **Command** - Console de comandos de operações e consultas, interagindo com as regras de negócio através de uma "fachada".
* **Façade** - Fachada (interface) entre o núcleo do sistema e o usuário
* **Singleton** - Implementado para garantir uma única instância para interação do sistema com o usuário
* **Strategy** - Implementado para diferenciação entre as regras de negócio de alunos de graduação, pós-graduação e professores, flexibilizando a implementação de outros usuários no sistema facilmente
* **Observer** - Implementado para inclusão de professores como observadores do status de reserva de um livro, podendo ser facilmente extendido a outros usuarios do sistema com permissão a esta função
* O sistema não comporta interface gráfica.
