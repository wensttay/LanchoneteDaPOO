package br.edu.ifpb.ads.poo.lanchonete.peoples;

import br.edu.ifpb.ads.poo.lanchonete.sistem.ConjuntoDePedidos;
import br.edu.ifpb.ads.poo.lanchonete.sistem.Pedido;
import br.edu.ifpb.ads.poo.lanchonete.sistem.Cardapio;
import br.edu.ifpb.ads.poo.lanchonete.sistem.JOMensagens;
import br.edu.ifpb.ads.poo.lanchonete.sistem.Produto;
import br.edu.ifpb.ads.poo.lanchonete.sistem.Loja;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * @version 1.0
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
 */
public class Garcom extends Funcionario {

    /// CONSTRUTORES ///
    public Garcom(double salario, String nome, int idade, String sexo) {
        super(salario, nome, idade, sexo);
    }

    /// MENU ///
    public void garcomMenu(Loja loja) {
        System.out.println();
        System.out.println("=> GARÇOM <=");
        System.out.println("1 - Fazer Pedido");
        System.out.println("2 - Voltar");
        System.out.print("=> ");
        Scanner in = new Scanner(System.in);
        int resposta = 0;

        try {
            resposta = in.nextInt();
        } catch (InputMismatchException er0) {
        }

        switch (resposta) {
            case 1: {
                if (!loja.getCardapio().getProdutos().isEmpty()) {
                    ArrayList<Pedido> escolhidos = new ArrayList();
                    ConjuntoDePedidos novo = new ConjuntoDePedidos();

                    novo.setMesaID(escolherMesa(loja));
                    novo.setPedidos(escolherPedidos(loja, novo, escolhidos));

                    confirmacaoFinal(novo, loja, escolhidos);
                    garcomMenu(loja);
                } else {
                    JOMensagens.error("Cardapio Vazio !");
                }

                loja.abrirLoja(loja);

                break;
            }
            case 2: {
                loja.abrirLoja(loja);

                break;
            }
            default: {
                JOMensagens.error();
                garcomMenu(loja);
            }
        }
    }

    /// METODOS OPTION 1 ///
    public boolean confirmarCompra(ConjuntoDePedidos novo) {
        System.out.println();
        System.out.println("=> CONCLUIR PEDIDOS <=");
        System.out.println("Pedidos:");
        System.out.print(novo.toString());
        System.out.println("\n\n>>>>> Total a pagar: R$ " + novo.getValorTotal() + " <<<<<\n");
        System.out.println(">>>>> Deseja Confirmar a Compra (S/N)? <<<<<<");
        System.out.print("=> ");
        Scanner in = new Scanner(System.in);
        String resposta = "";

        try {
            resposta = in.next();
        } catch (Exception er0) {
        }

        switch (resposta.toUpperCase()) {
            case "S": {
                JOMensagens.notice("Pedido Execultado com sucesso ! Porfavor Aguarde,\nLogo ele estará pronto ! Volte Sempre !");

                return true;
            }
            case "N": {
                JOMensagens.notice("Conclusão de Pedido Cancelado !");

                return false;
            }
            default: {
                JOMensagens.error();

                return confirmarCompra(novo);
            }
        }
    }

    public void confirmacaoFinal(ConjuntoDePedidos novo, Loja loja, ArrayList<Pedido> escolhidos) {
        if (confirmarCompra(novo)) {
            novo.setData(new Date());
            loja.getPedidosNaFila().add(novo);
        } else {
            escolherPedidos(loja, novo, escolhidos);
            confirmacaoFinal(novo, loja, escolhidos);
        }
    }

    public int escolherMesa(Loja loja) {
        System.out.println();
        System.out.println("=> ESCOLHER A MESA <=");
        System.out.print(loja.getSalao().toString());
        System.out.print("=> ");
        int resposta = 0;
        Scanner in = new Scanner(System.in);

        try {
            resposta = in.nextInt();

        } catch (InputMismatchException er0) {
        }

        if (loja.mesaExiste(loja.getSalao().getMesas(), resposta)) {
            return resposta;
        } else {
            JOMensagens.error();
            return escolherMesa(loja);
        }
    }

    /// MENU 2 ///
    public ArrayList<Pedido> escolherPedidos(Loja loja, ConjuntoDePedidos novo, ArrayList<Pedido> escolhidos) {
        System.out.println();
        System.out.println("=> ESCOLHER PEDIDOS <=");
        System.out.println("1 - Adicionar Um Pedido");
        System.out.println("2 - Remover último Pedido");
        System.out.println("3 - Remover Todos Pedidos");
        System.out.println("4 - Ver Pedidos");
        System.out.println("5 - Trocar os Pedidos de Mesa");
        System.out.println("6 - Concluir Pedido");
        System.out.println("7 - Voltar/Cancelar");
        System.out.print("=> ");
        Scanner in = new Scanner(System.in);
        int resposta = 0;

        try {
            resposta = in.nextInt();
        } catch (InputMismatchException er0) {
        }

        switch (resposta) {
            case 1: {
                System.out.println();
                Produto escolhido = escolherUmProduto(loja.getCardapio());
                int quantidade = escolherQuantidade();
                escolhidos.add(new Pedido(escolhido, quantidade));
                JOMensagens.notice("Pedido Adicionado com Sucesso !");
                escolherPedidos(loja, novo, escolhidos);

                break;
            }
            case 2: {
                System.out.println();
                System.out.println("=> ESXCLUIR ÚLTIMO PEDIDO <= ");

                if (!escolhidos.isEmpty()) {
                    String excluido = escolhidos.get(escolhidos.size() - 1).toString();
                    escolhidos.remove(escolhidos.size() - 1);
                    JOMensagens.notice("O Pedido: \n" + excluido + "\nFoi Excluido com Sucesso !");
                } else {
                    JOMensagens.errorEmpty();
                }

                escolherPedidos(loja, novo, escolhidos);

                break;
            }
            case 3: {
                System.out.println();
                System.out.println("=> EXCLUIR TODOS PEDIDOS <=");

                if (!escolhidos.isEmpty()) {
                    escolhidos.clear();
                    JOMensagens.notice("Todos os Pedidos Foram Cancelados !");
                } else {
                    JOMensagens.errorEmpty();
                }

                escolherPedidos(loja, novo, escolhidos);

                break;
            }
            case 4: {
                System.out.println();
                System.out.println("=> VER PEDIDOS <=");

                if (!escolhidos.isEmpty()) {
                    System.out.println(verPedidos(escolhidos));
                    System.out.println(">>>>> Total a pagar: R$ " + precoTotal(escolhidos) + " <<<<<");
                } else {
                    JOMensagens.errorEmpty();
                }

                escolherPedidos(loja, novo, escolhidos);

                break;
            }
            case 5: {
                novo.setMesaID(escolherMesa(loja));
                escolherPedidos(loja, novo, escolhidos);

                break;
            }
            case 6: {
                if (!escolhidos.isEmpty()) {
                    return escolhidos;
                } else {
                    System.out.println();
                    System.out.println("=> CONCLUIR PEDIDO <=");
                    JOMensagens.errorEmpty();
                    escolherPedidos(loja, novo, escolhidos);
                }

                break;
            }
            case 7: {
                escolhidos.clear();
                loja.abrirLoja(loja);

                break;
            }
            default: {
                JOMensagens.error();
                return escolherPedidos(loja, novo, escolhidos);
            }
        }
        return escolhidos;
    }

    /// METODO OPTION 1 ///
    public Produto escolherUmProduto(Cardapio cardapio) {
        System.out.print("=> ADICIONAR UM PEDIDO <=");
        System.out.println(cardapio.toString());
        System.out.print("=> ");
        Scanner in = new Scanner(System.in);
        int resposta = 0;
        
        try {
            resposta = in.nextInt();
        } catch (InputMismatchException er0) {
        }

        if (cardapio.procurarProduto(resposta) != null) {
            return cardapio.procurarProduto(resposta);
        } else {
            JOMensagens.error();
            return escolherUmProduto(cardapio);
        }
    }

    public int escolherQuantidade() {
        System.out.println();
        System.out.println("=> QUANTIDADE <=");
        System.out.print("=> ");
        Scanner in = new Scanner(System.in);
        int resposta = 0;
        
        try {
            resposta = in.nextInt();
        } catch (InputMismatchException er0) {
        }

        if (resposta > 0) {
            return resposta;
        } else {
            JOMensagens.error();
            return escolherQuantidade();
        }
    }

    /// METODO OPTION 4 ///
    public String verPedidos(ArrayList<Pedido> escolhidos) {
        String tudo = "";
        
        for (Pedido produto : escolhidos) {
            tudo += produto.toString() + "\n";
        }
        
        return tudo;
    }

    public double precoTotal(ArrayList<Pedido> escolhidos) {
        double total = 0;
        
        for (Pedido pedido : escolhidos) {
            total += pedido.getSubtotal();
        }
        
        return total;
    }

}
