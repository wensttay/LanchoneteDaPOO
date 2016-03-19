package sistem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import peoples.*;

public class Loja {
	
	/// CARACTERISTICAS ///
	private String nome;
	private String endereco;
	private Salao salao = new Salao();
	private Cardapio cardapio = new Cardapio();
	private double lucroTotal = 0;
	
	/// LISTAS DE PEDIDOS ///
	private ArrayList<ConjuntoDePedidos> pedidosNaFila = new ArrayList<ConjuntoDePedidos>();
	private ArrayList<ConjuntoDePedidos> pedidosConcluidos = new ArrayList<ConjuntoDePedidos>();
	
	/// FUNCIONARIOS ///
	private Gerente gerente;
	private Garcom garcom;
	private Cozinheiro cozinheiro;
	
	/// CONSTRUTORES ///
	public Loja(String nome, String endereco){
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public Loja(String nome, String endereco, double lucroTotal){
		this.nome = nome;
		this.endereco = endereco;
		this.lucroTotal = lucroTotal;
	}
	
	/// METODO OPEN ///
	public void abrirLoja (Loja loja){
		System.out.println();
		System.out.println("=> ENTRAR"
				+ ""
				+ ""
				+ ""
				+ ""
				+ " COMO: <=");
		System.out.println("1 - COZINHEIRO");
		System.out.println("2 - GERENTE");
		System.out.println("3 - GARÇOM");		
		System.out.println("4 - EXIT");
		System.out.print("=> ");
		Scanner in = new Scanner(System.in);
		int x = 0;
		try{
			x = in.nextInt();
		}catch(InputMismatchException er0){}
		
		switch (x) {
		case 1:
			loja.getCozinheiro().cozinheiroMenu(loja);
			break;
			
		case 2:
			loja.getGerente().gerenteMenu(loja);
			break;
			
		case 3:
			loja.getGarcom().garcomMenu(loja);
			break;
		
		case 4:
			JOMensagens.bye();
                        System.exit(0);
			break;
		
		default:
			JOMensagens.error();
			abrirLoja(loja);
		}
	}
	
	/// METODOS GET ///
	public String getNome() {
		return nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public Salao getSalao() {
		return salao;
	}
	
	public Cardapio getCardapio() {
		return cardapio;
	}
	
	public ArrayList<ConjuntoDePedidos> getPedidosNaFila() {
		return pedidosNaFila;
	}
	
	public String getPedidosNaFilaString(){
		String tudo = "";
		for(ConjuntoDePedidos pedidos : pedidosNaFila){
			tudo += pedidos.toString() + "\n";
		}
		return tudo;
	}
	
	public ArrayList<ConjuntoDePedidos> getPedidosConcluidos() {
		return pedidosConcluidos;
	}
	
	public Gerente getGerente() {
		return gerente;
	}
	
	public Garcom getGarcom() {
		return garcom;
	}
	
	public Cozinheiro getCozinheiro() {
		return cozinheiro;
	}
	
	public void getLojaBuild(){
		System.out.println("-------------------------------------------------------------");
		System.out.println("=> LOJA <=");
		System.out.println("NOME: " + nome);
		System.out.println("ENDEREÇOO: " + endereco);
		System.out.println("DINHEIRO DO CAIXA: R$ " + lucroTotal);
		System.out.println("-------------------------------------------------------------");
		System.out.println("=> FUNCIONÁRIOS <=");
		System.out.println("=> COZINHEIRO <=");
		System.out.println(cozinheiro.toString());
		System.out.println("-------------------------------------------------------------");
		System.out.println("=> GERENTE <=");
		System.out.println(gerente.toString());
		System.out.println("-------------------------------------------------------------");
		System.out.println("=> GARÇOOM <=");
		System.out.println(garcom.toString());
		System.out.println("-------------------------------------------------------------");
	}
	
	public double getLucroTotal(){
		return this.lucroTotal;
	}

	public String getMesasComPedidos(Loja loja){
		String tudo = "";
		for (int i = 0; i < salao.getMesas().size(); i++){
			if (procurarIDNaFila(salao.getMesas().get(i).getNumero())){
				tudo += salao.getMesas().get(i).toString() + "\n"; 
			}
		}
		return tudo;
	}
	
	public String getDatas (ArrayList<Integer> list){
		String tudo = "";
		if (pedidosConcluidos.size() > 0){
			for (int i = 0; i < pedidosConcluidos.size(); i ++){
				if (i == 0){
					list.add(i);
					tudo += i + " - " + pedidosConcluidos.get(0).getData() + "\n";
				} else if (!pedidosConcluidos.get(i).getData().equals(pedidosConcluidos.get(i-1).getData())){
					list.add(i);
					tudo += i + " - " + pedidosConcluidos.get(i).getData() + "\n";
				}
			}
		}
		return tudo;
	}
	
	/// METODOS SET ///
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setSalao(Salao salao) {
		this.salao = salao;
	}
	
	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}
	
	public void setPedidosNaFila(ArrayList<ConjuntoDePedidos> pedidosNaFila) {
		this.pedidosNaFila = pedidosNaFila;
	}
	
	public void setPedidosConcluidos(ArrayList<ConjuntoDePedidos> pedidosConcluidos) {
		this.pedidosConcluidos = pedidosConcluidos;
	}
	
	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	
	public void setGarcom(Garcom garcom) {
		this.garcom = garcom;
	}
	
	public void setCozinheiro(Cozinheiro cozinheiro) {
		this.cozinheiro = cozinheiro;
	}
	
	public void setLucroTotal(double lucroTotal){
		this.lucroTotal = lucroTotal;
	}
	
	/// METODOS ADD ///
	public void addLucroTotal(double lucroTotal){
		this.lucroTotal += lucroTotal;
	}
	
	/// OUTROS METODOS ///
	public boolean mesaExiste(ArrayList<Mesa> mesas, int ide){
		for (Mesa mesa: mesas){
			if (mesa.getNumero() == ide){
				return true;
			}
		}
		return false;
	}
	
	public int escolherMesa(Loja loja){
		System.out.println();
		System.out.println("=> ESCOLHA A MESA <=");
		System.out.print(getMesasComPedidos(loja));
		System.out.print("=> ");
		int resposta = 0;
		Scanner in = new Scanner(System.in);
		try{
			resposta = in.nextInt();
		}catch(InputMismatchException er0){}
		
		if (procurarIDNaFila(resposta)){
			return resposta;
		}else{
			JOMensagens.error();
			return escolherMesa(loja);
		}
	}
		
	
	public boolean procurarIDNaFila(int id){
		for (int i = 0; i < pedidosNaFila.size(); i++){
			if (pedidosNaFila.get(i).getMesaID() == id){
				return true;
			}
		}
		return false;
	}
	
	
	public boolean respValid (int resposta, ArrayList<Integer> list){
		for (int i = 0; i <	list.size(); i ++){
			if (list.get(i).equals(resposta)){
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<ConjuntoDePedidos> conjuntoDataID (String data){
		ArrayList<ConjuntoDePedidos> aux = new ArrayList<ConjuntoDePedidos>();
		for(int i = 0; i < pedidosConcluidos.size(); i++){
			if (pedidosConcluidos.get(i).getData().equals(data)){
				aux.add(pedidosConcluidos.get(i));
			}
		}
		return aux;
	}
}
