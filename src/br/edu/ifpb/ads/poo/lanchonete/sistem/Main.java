package br.edu.ifpb.ads.poo.lanchonete.sistem;

import java.util.ArrayList;
import br.edu.ifpb.ads.poo.lanchonete.peoples.Cozinheiro;
import br.edu.ifpb.ads.poo.lanchonete.peoples.Garcom;
import br.edu.ifpb.ads.poo.lanchonete.peoples.Gerente;


/**
 * @version 1.0
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
 */
public class Main {

    public static void main(String[] agrs) {
        /// CRIANDO LOJA ///
        Loja loja = new Loja("Lanchonete Lan-X's", "Na Rua dos Bobos, 0");

        /// CRIANDO FUNCIONARIOS ///
        loja.setGerente(new Gerente(1500, "Chefinha", 25, "Feminino"));
        loja.setGarcom(new Garcom(600, "Escravonildo", 19, "Masculino"));
        loja.setCozinheiro(new Cozinheiro(1300, "CozinhaADor", 32, "Masculino"));

        /// CRIANDO MESAS ///
        loja.getSalao().addMesa(new Mesa("Mesa Top"));
        loja.getSalao().addMesa(new Mesa("Mesa Mid"));
        loja.getSalao().addMesa(new Mesa("Mesa Bot"));
        loja.getSalao().addMesa(new Mesa("Mesa Jungler"));

        /// CRIANDO PRODUTOS ///
        loja.getCardapio().addProduto(new Produto("Água Mineral", "H2O - Água importada, porque no Brasil não tem", 2, 0.5));
        loja.getCardapio().addProduto(new Produto("Suco de Frutas", "Frutas de final de Feira", 4, 0.5));
        loja.getCardapio().addProduto(new Produto("Refrigerante", "Produtos quimicos perigosos para seu corpo com Corante", 3, 1));
        loja.getCardapio().addProduto(new Produto("SandWich", "Lanche com Areia", 5, 2));
        loja.getCardapio().addProduto(new Produto("Salsichão", "Não recomendado para menores de 18", 4, 1.5));
        loja.getCardapio().addProduto(new Produto("Misto", "O mesmo que você faz em casa, só que mais caro", 3, 0.5));

        /// PEDIDOS PARA TEST ///
        ArrayList<Pedido> pedidos1 = new ArrayList();
        pedidos1.add(new Pedido(new Produto("Água Mineral", "H2O - Água importada, porque no Brasil não tem", 2, 0.5, 1), 10));
        pedidos1.add(new Pedido(new Produto("Suco de Frutas", "Frutas de final de Feira", 4, 0.5, 2), 202));
        pedidos1.add(new Pedido(new Produto("Refrigerante", "Produtos quimicos perigosos para seu corpo com Corante", 3, 1, 3), 303));
        pedidos1.add(new Pedido(new Produto("Misto", "O mesmo que você faz em casa, só que mais caro", 3, 0.5, 6), 404));
        loja.getCozinheiro().cozinhaEstaLista(loja, new ConjuntoDePedidos(pedidos1, 1));

        ArrayList<Pedido> pedidos2 = new ArrayList();
        pedidos2.add(new Pedido(new Produto("Água Mineral", "H2O - Água importada, porque no Brasil não tem", 2, 0.5, 1), 1000));
        pedidos2.add(new Pedido(new Produto("Suco de Frutas", "Frutas de final de Feira", 4, 0.5, 2), 20));
        pedidos2.add(new Pedido(new Produto("Salsichão", "Não recomendado para menores de 18", 4, 1.5, 5), 30));
        pedidos2.add(new Pedido(new Produto("Misto", "O mesmo que você faz em casa, só que mais caro", 3, 0.5, 6), 40));
        loja.getCozinheiro().cozinhaEstaLista(loja, new ConjuntoDePedidos(pedidos2, 2));

        ArrayList<Pedido> pedidos3 = new ArrayList();
        pedidos3.add(new Pedido(new Produto("Água Mineral", "H2O - Água importada, porque no Brasil não tem", 2, 0.5, 1), 200));
        pedidos3.add(new Pedido(new Produto("Suco de Frutas", "Frutas de final de Feira", 4, 0.5, 2), 37));
        pedidos3.add(new Pedido(new Produto("Salsichão", "Não recomendado para menores de 18", 4, 1.5, 5), 20));
        pedidos3.add(new Pedido(new Produto("Misto", "O mesmo que você faz em casa, só que mais caro", 3, 0.5, 6), 10));
        loja.getPedidosNaFila().add(new ConjuntoDePedidos(pedidos3, 3));

        /// ABRINDO LOJA ///
        JOMensagens.welcome();
        loja.abrirLoja(loja);
    }
}
