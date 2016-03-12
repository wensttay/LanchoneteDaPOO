#Criando um Sistema de Lanchonete via Linha de Comando
  Segundo projeto da disciplina de POO do curso de ADS no qual foi criado um Sistema de Lanchonete através de linhas de Comando (console Java).

#Descrição do Projeto:
  Em uma determinada lanchonete acontecem diversos problemas devido à ausência de um 
sistema computacional para auxiliar na gestão do negócio. Por exemplo: 

- Alguns pedidos realizados pelos clientes demoram a ser repassados ao(s) cozinheiro(s);
- Como não há um controle da fila de pedidos, por vezes acontece da ordem dos mesmos ser alterada;
- Não há como saber quantas unidades de determinado produto foi vendido em uma data, muito menos fazer um balanço do que foi vendido nessa data.

  O dono da lanchonete então decidiu contratar estudantes do segundo período de ADS para desenvolver um sistema que auxilie a resolver esses problemas. Porém, como ele soube que a turma de POO ainda não concluiu a disciplina, aceitou que o sistema funcionasse em modo texto e, além disso, que (ainda) não houvesse a necessidade de integrar com arquivos ou banco de dados. Por outro lado, os dados devem ser armazenados temporariamente eu uma lista. O cliente (dono da lanchonete) informou que sistema pode ser acessado por três usuários distintos:

- Garçom: Funcionário que realiza os pedidos, ele consegue visualizar os produtos que estão no cardápio da lanchonete e assim, realizar os pedidos para cada mesa. Após ele realizar o pedido, o mesmo segue para uma fila que será acessada pelo cozinheiro.
- Cozinheiro: Funcionário que atende aos pedidos, ele consegue visualizar a fila de pedidos e atende-los mantendo a ordem de realização dos mesmos. Após um pedido ser atendido, ele deve ser removido da mesma e colocado na lista que contém todos os pedidos atendidos.
- Gerente: Funcionário que analisa as informações, ele tem acesso a lista que contém todos os pedidos que foram atendidos, dessa forma ele consegue analisar informações referentes a um dado dia, tais como: quantidade de determinado produto vendido ou total vendido.

A modelagem das classes fica a critério do grupo, mas devem seguir os conceitos da Orientação a Objetos.

#Execução:
A execução do programa é simples. No início da execução o utilizador irá indicar que tipo de usuário ele é (autenticação é opcional). Após isso, serão listadas as funcionalidades disponíveis para o tipo de usuário escolhido. Como a interface gráfica é opcional nesse trabalho, os comandos devem ser realizados em linha de texto. Além disso, toda a aplicação roda em uma única máquina, pois ainda não foram abordados conceitos de aplicações distribuídas em Java na disciplina (Isso não os impede de tentar).

No mínimo, o seu sistema deverá permitir:

- Visualizar o cardápio da lanchonete (garçom);
- Realizar um novo pedido (garçom);
- Verificar próximo pedido da fila (cozinheiro);
- Marcar um pedido como atendido (cozinheiro);
- Verificar quantas unidades de um produto foi vendido em uma determinada data (gerente);
- Verificar quanto foi vendido em uma determinada data (gerente);
