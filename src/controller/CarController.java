package controller;

import Model.Car;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import repository.AluguelRepository;

public class CarController {
	@FXML
	private TableView<Car> carView;
	
	@FXML
	private TableColumn<Car, String> carroColuna;
	
	@FXML
	private TableColumn<Car, String> modeloColuna;
	
	@FXML
	private TableColumn<Car, String> precoColuna;
	
	
	@FXML
	private TextField carro;
				
	@FXML
	private TextField modelo;
	
	@FXML
	private TextField preco;
	
	private AluguelRepository repoCar;
	
	@FXML
	public void initialize() {
		repoCar = new AluguelRepository();
	}
	
	public void adicionar() {
		Car car= new Car();
		car.setNome(carro.getText());
		car.setModelo(modelo.getText());
		car.setAno(preco.getText());
		repoCar.addCar(car);
		clearFiels();
	}
	
	public void clearFiels()	{
		carro.clear();
		modelo.clear();
		preco.clear();
	}
	
	public void limpar() {
		clearFiels();
	}
}
