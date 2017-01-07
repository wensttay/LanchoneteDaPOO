package br.edu.ifpb.ads.poo.lanchonete.peoples;

/**
 * @version 1.0
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
 */
public class Funcionario {

    /// CARACTERISTICAS ///
    private double salario;
    private String nome;
    private String sexo;
    private int idade;

    /// CONSTRUTORES ///
    public Funcionario() {
        this.salario = 0;
        this.nome = "Pessoa";
        this.idade = 18;
        this.sexo = "Assexuado";
    }

    public Funcionario(double salario, String nome, int idade, String sexo) {
        this.salario = salario;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    /// METODOS SET ///
    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /// METODOS GET ///
    public double getSalario() {
        return salario;
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getSexo() {
        return this.sexo;
    }

    /// OUTROS METODOS ///
    @Override
    public String toString() {
        return "Nome: " + nome + "\nSexo: " + sexo + "\nIdade: " + idade + "\nSalario: " + salario;
    }
}
