package peoples;

import java.util.ArrayList;
import java.util.InputMismatchException;

import sistem.*;

import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import sistem.Loja;

public class Cozinheiro extends Funcionario{
	
	/// CONSTRUTORES ///
	public Cozinheiro(double salario, String nome, int idade, String sexo) {
		super(salario,nome,idade,sexo);
	}
	
	/// MENU ///
	public void cozinheiroMenu (Loja loja){
		System.out.println();
		System.out.println("=> COZINHEIRO <=");
		System.out.println("1 - Cozinhar Próximo Pedido");
		System.out.println("2 - Escolher Mesa");
		System.out.println("3 - Prepar todos os Pedidos");
		System.out.println("4 - Ver Pedidos Na Fila");
		System.out.println("5 - Ver Cardapio");
		System.out.println("6 - Voltar");
		System.out.print("=> ");
		Scanner in = new Scanner(System.in);
		int resposta = 0;
		try{
			resposta = in.nextInt();
		}catch(InputMismatchException er0){}
		
		switch (resposta){
			case 1:
				cozinharProx(loja);
				break;
				
			case 2:
				if (!loja.getPedidosNaFila().isEmpty()){
					int mesa = loja.escolherMesa(loja);
					int aux = cozinharDaMesa(loja.getPedidosNaFila(),mesa);
				
					if (aux >= 0){
						loja.getPedidosConcluidos().add(0, loja.getPedidosNaFila().get(aux));;
						loja.addLucroTotal(loja.getPedidosNaFila().get(aux).getLucroParcial());
						loja.getPedidosNaFila().remove(aux);
						JOMensagens.info("Pedido da Mesa Escolhida ("+ mesa +") a seguir foi Concluido !\n" 
											+ loja.getPedidosConcluidos().get(0).toString());
					}else{
						JOMensagens.error("Não existe Nenhum Pedido Para esta Mesa !");
					}
					cozinheiroMenu(loja);
				}else{
					JOMensagens.error("Não existe Nenhum Pedido em Qualquer Mesa !");;
					cozinheiroMenu(loja);
				}
				break;
				
			case 3:
				if(!loja.getPedidosNaFila().isEmpty()){
					passarTudo(loja);
					JOMensagens.info("Todos os Pedidos Foram Concluidos !");
				}else{
					JOMensagens.errorEmpty();
				}
				cozinheiroMenu(loja);
				break;
				
			case 4:
				if (!loja.getPedidosNaFila().isEmpty()){
					System.out.println("=> PEDIDOS NA FILA <=");
					System.out.println(loja.getPedidosNaFilaString());
				}else{
					JOMensagens.errorEmpty();
				}
				cozinheiroMenu(loja);
				break;
				
			case 5:
				System.out.println();
				System.out.println("=> CARDAPIO <=");
				if(!loja.getCardapio().getProdutos().isEmpty()){
					System.out.println(loja.getCardapio().toString());
				}else{
					JOMensagens.error("Não existe nenhum Produto no Cardapio !");
				}
				cozinheiroMenu(loja);
				break;
				
			case 6:
				loja.abrirLoja(loja);
				break;
				
			default:
				JOMensagens.error();
				cozinheiroMenu(loja);
		}
	}
	
	/// METODO OPTION 1 ///
	public void cozinharProx(Loja loja){
		if(!loja.getPedidosNaFila().isEmpty()){
			loja.getPedidosConcluidos().add(0, loja.getPedidosNaFila().get(0));;
			loja.addLucroTotal(loja.getPedidosNaFila().get(0).getLucroParcial());
			loja.getPedidosNaFila().remove(0);
			System.out.println("=> COZINHAR PRÓXIMO PEDIDO <=");
			JOMensagens.info("O Pedido a seguir foi concluido !\n" + loja.getPedidosConcluidos().get(0).toString());
			cozinheiroMenu(loja);
		}else{
			JOMensagens.errorEmpty();
			cozinheiroMenu(loja);
		}
	}
	
	/// METODO OPTION 2 ///
	public int cozinharDaMesa (ArrayList<ConjuntoDePedidos> pedidos, int id){
		for(int i= 0; i < pedidos.size(); i++){
			if (pedidos.get(i).getMesaID() == id){
				return i;
			}
		}
		return -1;
	}
	
	/// METODO OPTION 3 ///
	public void passarTudo(Loja loja){
		for (int i = 0; i < loja.getPedidosNaFila().size(); i++){
			loja.getPedidosConcluidos().add(0, loja.getPedidosNaFila().get(i));
			loja.addLucroTotal(loja.getPedidosNaFila().get(i).getLucroParcial());
			loja.getPedidosNaFila().remove(i);
			i = i-1;
		}
	}
	
	/// OUTOS METODOS ///
	public void cozinhaEstaLista(Loja loja, ConjuntoDePedidos pedidos){
		loja.addLucroTotal(pedidos.getLucroParcial());
		loja.getPedidosConcluidos().add(0, pedidos);
	}
}
