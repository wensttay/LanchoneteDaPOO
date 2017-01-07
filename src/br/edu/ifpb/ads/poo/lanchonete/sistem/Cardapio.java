package br.edu.ifpb.ads.poo.lanchonete.sistem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @version 1.0
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
 */
public class Cardapio {

    /// CARACTERISTICAS ///
    private ArrayList<Produto> produtos;
    private int tamanho = 0;

    /// CONSTRUTORES ///
    public Cardapio() {
        produtos = new ArrayList<Produto>();
    }

    /// METODOS GET ///
    public ArrayList<Produto> getProdutos() {
        return this.produtos;
    }

    /// METODOS SET ///
    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    /// METODOS ADD ///
    public void addProduto(Produto p) {
        tamanho += 1;
        p.setID(tamanho);
        produtos.add(p);
    }

    public void addProduto() {
        Scanner in = new Scanner(System.in);
        double preco = 0, prejuiso = 0;
        System.out.println();
        System.out.println("=> ADICIONAR PRODUTO <=");
        System.out.print("NOME: ");
        String nome = in.nextLine();
        
        if ((nome == null) || (nome.equals(" "))) {
            JOMensagens.error("Valor Invalido!\nO Campo Nome é Obrigatorio!");
            addProduto();
        } else {
            System.out.print("DESCRIÇÃO: ");
            String descricao = in.nextLine();
            System.out.print("PREÇO: ");
            
            try {
                preco = in.nextDouble();
                System.out.print("CUSTO DE PRODUÇÃO: ");
                prejuiso = in.nextDouble();
                addProduto(new Produto(nome, descricao, preco, prejuiso));
            } catch (InputMismatchException ex) {
                JOMensagens.error("Opção Inválida!\nEscolha um Número Válido!");
                addProduto();
            }
        }
    }

    /// OUTROS METODOS ///
    @Override
    public String toString() {
        String tudo = "";
        tudo += "\n-------------------------------------------------------------";
        
        for (Produto produto : produtos) {
            tudo += "\n" + produto.toString();
            tudo += "\n-------------------------------------------------------------";
        }
        
        return tudo;
    }

    public Produto procurarProduto(int ID) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getID() == ID) {
                return produtos.get(i);
            }
        }
        
        return null;
    }
}
