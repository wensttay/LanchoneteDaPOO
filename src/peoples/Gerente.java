package peoples;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import sistem.ConjuntoDePedidos;
import sistem.JOMensagens;
import sistem.Loja;
import sistem.Pedido;
import sistem.Produto;

/**
 * @version 1.0
 * @author wensttay <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
 */
public class Gerente extends Funcionario {

    /// CONSTRUTORES ///
    public Gerente(double salario, String nome, int idade, String sexo) {
        super(salario, nome, idade, sexo);
    }

    /// MENU ///
    public void gerenteMenu(Loja loja) {
        System.out.println();
        System.out.println("=> GERENTE <=");
        System.out.println("1 - Verificar Pedidos em Espera");
        System.out.println("2 - Verificar Pedidos Comcluidos");
        System.out.println("3 - Produtos Vendidos (Escolher Data)");
        System.out.println("4 - Dados da Loja");
        System.out.println("5 - Ver Cardapio");
        System.out.println("6 - Adicionar/Remover Produto do Cardapio");
        System.out.println("7 - Voltar");
        System.out.print("=> ");
        Scanner in = new Scanner(System.in);
        int resposta = 0;
        
        try {
            resposta = in.nextInt();
        } catch (InputMismatchException er0) {
        }

        switch (resposta) {
            case 1: {
                if (!loja.getPedidosNaFila().isEmpty()) {
                    System.out.println("=> PEDIDO EM ESPERA <=");
                    ConjuntoDePedidosToString(loja.getPedidosNaFila());
                } else {
                    JOMensagens.errorEmpty();
                }
                
                gerenteMenu(loja);
                
                break;
            }
            case 2: {
                if (!loja.getPedidosConcluidos().isEmpty()) {
                    System.out.println("=> PEDIDOS CONCLUIDOS <=");
                    ConjuntoDePedidosToString(loja.getPedidosConcluidos());
                } else {
                    JOMensagens.error("Sua Lista de Pedidos Concluidos Est� Vazia !");
                }
                
                gerenteMenu(loja);
                
                break;
            }
            case 3: {
                if (!loja.getPedidosConcluidos().isEmpty()) {
                    pedidosPor(loja);
                } else {
                    JOMensagens.error("Sua Lista de Pedidos Concluidos Est� Vazia !");
                }
                
                gerenteMenu(loja);
                
                break;
            }
            case 4: {
                System.out.println();
                System.out.println("=> DADOS DA LOJA <=");
                loja.getLojaBuild();
                gerenteMenu(loja);
                
                break;
            }
            case 5: {
                if (!loja.getCardapio().getProdutos().isEmpty()) {
                    System.out.println("=> CARDAPIO <=");
                    System.out.println(loja.getCardapio().toString());
                } else {
                    JOMensagens.error("Cardapio Vazio !");
                }
                
                gerenteMenu(loja);
                
                break;
            }
            case 6: {
                addOrDelet(loja);
                loja.abrirLoja(loja);
                
                break;
            }
            case 7: {
                loja.abrirLoja(loja);
                
                break;
            }
            default: {
                JOMensagens.error();
                gerenteMenu(loja);
            }
        }
    }

    /// METODO OPTION 1 e 2 ///
    public void ConjuntoDePedidosToString(ArrayList<ConjuntoDePedidos> pedidos) {
        for (ConjuntoDePedidos pedido : pedidos) {
            System.out.println(pedido.toString() + " | Valor Total R$" + pedido.getValorTotal() + "\nData: " + pedido.getData() + " | Lucro Parcial: R$" + pedido.getLucroParcial());
            System.out.println("-------------------------------------------------------------");
            System.out.println();
        }
    }

    /// MENU METODO OPTION 3 ///
    public void pedidosPor(Loja loja) {
        System.out.println();
        System.out.println("=> PRODUTOS VENDIDOS <=");
        System.out.println("1 - Mais Vendido(s) em uma certa Data");
        System.out.println("2 - Todos Vendidos em uma certa Data");
        System.out.println("3 - Voltar");
        System.out.print("=> ");
        Scanner in = new Scanner(System.in);
        int resposta = 0;
        
        try {
            resposta = in.nextInt();
        } catch (InputMismatchException er0) {
        }

        switch (resposta) {
            case 1: {
                int dataID = escolherData(loja);
                ArrayList<Pedido> maisComprados = produtoDataID(loja, loja.getPedidosConcluidos().get(dataID).getData());
                System.out.println();
                System.out.println("=> PRODUTO(OS) MAIS VENDIDOS NA DATA: " + loja.getPedidosConcluidos().get(dataID).getData() + " <=");
                System.out.println(arrayListToString(maisComprados));
                pedidosPor(loja);
                
                break;
            }
            case 2: {
                int dataID2 = escolherData(loja);
                ArrayList<Pedido> maisComprados2 = produtoSDATAID2(loja, loja.getPedidosConcluidos().get(dataID2).getData());
                System.out.println();
                System.out.println("=> PRODUTO(OS) VENDIDOS NA DATA: " + loja.getPedidosConcluidos().get(dataID2).getData() + " <=");
                System.out.println(arrayListToString(maisComprados2));
                pedidosPor(loja);
                
                break;
            }
            case 3: {
                gerenteMenu(loja);
                
                break;
            }
            default: {
                JOMensagens.error();
                pedidosPor(loja);
            }
        }

    }

    public int escolherData(Loja loja) {
        ArrayList<Integer> list = new ArrayList();
        System.out.println();
        System.out.println("=> DATAS <=");
        System.out.println(loja.getDatas(list));
        System.out.print("=> ");
        Scanner in = new Scanner(System.in);
        int resposta = 0;
        
        try {
            resposta = in.nextInt();
            
            if ((resposta >= 0) && (resposta < loja.getPedidosConcluidos().size()) && (loja.respValid(resposta, list))) {
                return resposta / 1;
            } else {
                JOMensagens.error();
                return escolherData(loja);
            }
        } catch (InputMismatchException er0) {
            JOMensagens.error();
            
            return escolherData(loja);
        }
    }

    public ArrayList<Pedido> unirConjuntoDePedidos(ArrayList<ConjuntoDePedidos> conjuntoRetorno) {
        ArrayList<Pedido> unido = new ArrayList();
        unido.add(0, new Pedido(new Produto(), 0));
        unido.get(0).getProduto().setID(-1);

        for (int i = 0; i < conjuntoRetorno.size(); i++) {
            for (int j = 0; j < conjuntoRetorno.get(i).getPedidos().size(); j++) {
                organizaPedidosDataID(unido, conjuntoRetorno.get(i).getPedidos().get(j), conjuntoRetorno.get(i).getPedidos().get(j).getQuantidade());
            }
        }
        
        return unido;
    }

    public void organizaPedidosDataID(ArrayList<Pedido> unido, Pedido pedido, int quant) {
        for (int i = 0; i < unido.size(); i++) {
            if (unido.get(i).getProduto().getID() == pedido.getProduto().getID()) {
                unido.get(i).setQuantidade(unido.get(i).getQuantidade() + quant);
                
                break;
            } else if (i == unido.size() - 1) {
                Pedido outro = new Pedido();
                outro.setProduto(pedido.getProduto());
                outro.setQuantidade(quant);
                unido.add(outro);
                
                if (unido.get(0).getProduto().getID() == -1) {
                    unido.remove(0);
                }
                
                break;
            }
        }
    }

    public ArrayList<Pedido> produtoDataID(Loja loja, String data) {
        ArrayList<ConjuntoDePedidos> conjuntoRetorno = loja.conjuntoDataID(data);
        ArrayList<Pedido> retorno = unirConjuntoDePedidos(conjuntoRetorno);

        ArrayList<Pedido> maisComprados = new ArrayList();
        int maiorQuantidade = 0;

        for (int i = 0; i < retorno.size(); i++) {
            if (retorno.get(i).getQuantidade() > maiorQuantidade) {
                maiorQuantidade = retorno.get(i).getQuantidade();
            }
        }
        
        for (int i = 0; i < retorno.size(); i++) {
            if (retorno.get(i).getQuantidade() == maiorQuantidade) {
                maisComprados.add(retorno.get(i));
            }
        }
        
        return maisComprados;
    }

    public ArrayList<Pedido> produtoSDATAID2(Loja loja, String data) {
        ArrayList<ConjuntoDePedidos> conjuntoRetorno = loja.conjuntoDataID(data);
        ArrayList<Pedido> retorno = unirConjuntoDePedidos(conjuntoRetorno);
        return retorno;
    }

    public String arrayListToString(ArrayList<Pedido> produto) {
        String total = "";
        
        for (int i = 0; i < produto.size(); i++) {
            total += produto.get(i).toString() + "\n";
        }
        
        return total;
    }

    /// MENU METODO OPTION 6 ///
    public void addOrDelet(Loja loja) {
        System.out.println();
        System.out.println("=> ADICIONAR OU REMOVER PRODUTO DO CARDAPIO <=");
        System.out.println("1 - Adicionar Produto");
        System.out.println("2 - Remover Produto");
        System.out.println("3 - Voltar");
        System.out.print("=> ");
        Scanner in = new Scanner(System.in);
        int resposta = 0;
        
        try {
            resposta = in.nextInt();
            in.nextLine();
        } catch (InputMismatchException ex0) {
        }

        switch (resposta) {
            case 1: {
                loja.getCardapio().addProduto();
                JOMensagens.notice("Produto adicionado ao Cardapio com Sucesso !");
                addOrDelet(loja);
                
                break;
            }
            case 2: {
                if (!loja.getCardapio().getProdutos().isEmpty()) {
                    System.out.println("=> REMOVER PRODUTO <=");
                    loja.getCardapio().toString();
                    System.out.print("ID Do Produto: ");
                    int x = 0;
                    
                    try {
                        x = in.nextInt();
                        String aux = loja.getCardapio().procurarProduto(x).toString();
                        loja.getCardapio().getProdutos().remove(loja.getCardapio().procurarProduto(x));
                        JOMensagens.notice("O Produto abaixo foi Excluido com Sucesso !"
                                + "\n-------------------------------------------------------------\n"
                                + aux
                                + "\n-------------------------------------------------------------\n");
                    } catch (NullPointerException ex) {
                        JOMensagens.error("N�o existe nenhum Produto com Esse ID !");
                    } catch (InputMismatchException ex0) {
                        JOMensagens.error("Op��o Inv�lida !\nEscolha um ID V�lido !");
                    }
                } else {
                    JOMensagens.error("Cardapio Vazio !");
                }
                
                addOrDelet(loja);
                
                break;
            }
            case 3: {
                System.out.println();
                gerenteMenu(loja);
                
                break;
            }
            default: {
                JOMensagens.error();
                addOrDelet(loja);
            }
        }
    }
}
