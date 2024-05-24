package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Model.Car;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
	
	private ObservableList<Car> data;
	
	@FXML
	private TextField preco;
	
	private AluguelRepository repoCar;
	
	@FXML
	public void initialize() {
		
		carroColuna.setCellValueFactory(new PropertyValueFactory<>("nome"));
		modeloColuna.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		precoColuna.setCellValueFactory(new PropertyValueFactory<>("ano"));
		
		//Iniciando lista observable
		data = FXCollections.observableArrayList();
		//tableview aceita somente ObservableList
		
		carView.setItems(data);

		repoCar = new AluguelRepository();
		
		//Preencher lista
		carregarDadosSalvos();
		
	}
	
	
	public void carregarDadosSalvos() {
		try (BufferedReader br = new BufferedReader(new FileReader("database-carros.txt"))) {
			String line;
			//Caso na linha não tenha nada, vai parar o while
			while((line = br.readLine()) != null) {
				String [] parts  = line.split(";");
				
				if(parts.length >= 4) {
					Car car = new Car();
					car.setId(Integer.parseInt(parts[0]));
					car.setNome(parts[1]);
					car.setModelo(parts[2]);
					car.setAno(parts[3]);
					
					//Adicionar no observableList
					data.add(car);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void adicionar() {
		System.out.println("Adicionado com sucesso!");
		Car car= new Car();
		car.setNome(carro.getText());
		car.setModelo(modelo.getText());
		car.setAno(preco.getText());
		repoCar.addCar(car);
		clearFiels();
		carregarDadosSalvos();
		
		if(carro.getText().isEmpty()) {
			showAlert("Erro", "Adicione um carro!", Alert.AlertType.ERROR);
			return;
		}
		
		if(modelo.getText().isEmpty() ) {
			showAlert("Erro" , "adicione um modelo de carro!" , Alert.AlertType.ERROR);
			return;
		}
		if(preco.getText().isEmpty()) {
			showAlert("Erro", "Adicione um valor de proposta", Alert.AlertType.ERROR);
		}
	}
	
	private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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
