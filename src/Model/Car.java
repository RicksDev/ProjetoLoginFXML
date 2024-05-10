package Model;

public class Car {
	
	private long id;
	
	private String nome;
	private String modelo;
	private int ano;
	
	public Car(long id, String nome, String modelo, int ano) {
		super();
		this.id = id;
		this.nome = nome;
		this.modelo = modelo;
		this.ano = ano;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	
}
