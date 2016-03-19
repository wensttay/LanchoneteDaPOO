package sistem;

public class Produto {
	
	/// CARACTERISTICAS ///
	private int ID;
    private String nome;
    private String descricao;
    private double preco;
    private double prejuiso;
    
    /// CONSTRUTORES ///
    public Produto(String nome, String descricao, double preco, double prejuiso) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.prejuiso = prejuiso;
    }
    
    public Produto(String nome, String descricao, double preco, double prejuiso, int ID) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.prejuiso = prejuiso;
        this.ID = ID;
    }
    
    public Produto() {}

	/// METODOS GET ///
	public int getID(){
        return ID;
    }
	
    public String getNome() {
        return nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public double getPrejuiso() {
    	return prejuiso;
    }
    
    public double getLucro(){
    	return preco - prejuiso;
    }
    
    /// METODOS SET ///
    public void setID(int ID){
    	this.ID = ID;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public void setPrejuiso(int prejuiso){
    	this.prejuiso = prejuiso;
    }

    /// OUTROS METODOS ///
    @Override
    public String toString(){
    	return ID + " - " + nome + " | R$ " + preco + "\n    (" + descricao +")"; 
    }
}
