package Model;

public class Car {
	
	private long id;
	
	private String nome;
	private String modelo;
	private String ano;
	
	public Car(long id, String nome, String modelo, String ano) {
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
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	public Car() {}
	
	
}
