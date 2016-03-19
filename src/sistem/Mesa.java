package sistem;


public class Mesa {
	
	/// CARACTERISTICAS ///
	private int numero;
	private String nome;
	
	/// CONSTRUTORES ///
	public Mesa (String nome){
		this.nome = nome;
	}
	
	/// METODOS GET ///
	public int getNumero(){
		return this.numero;
	}
	
	/// METODOS SET ///
	public void setNumero(int numero){
		this.numero = numero;
	}
	
	/// OUTROS METODOS ///
	@Override
	public String toString(){
		return numero + " - " + nome;
	}
}
