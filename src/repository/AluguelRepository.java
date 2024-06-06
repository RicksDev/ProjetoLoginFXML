package repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Car;

public class AluguelRepository {
	
	private List<Car> carros;
	private File database;
	
	public AluguelRepository() {
		this.database = new File("database-carros.txt");
		this.carros = new ArrayList<>();
		LoadCarros();
	}
	//Carregar
	private void LoadCarros() {
		try (Scanner sc = new Scanner(database)){
			while(sc.hasNextLine()) {
				String [] data = sc.nextLine().split(";");
				if(data.length >= 4) {
					//0 -> id, 1 -> nome, 2 -> inicio, 3 -> fim
					Car car = new Car();
					car.setId(Integer.parseInt(data[0]));
					car.setNome(data[1]);
					car.setModelo(data[2]);
					car.setAno(data[3]);
					carros.add(car);
					
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado, criando um novo!");
		}
	}
	
	//Crud
	
	//Buscar todos
	
	public List<Car> buscarTodos(){
		return new ArrayList<>(carros);
	}
	
	//Deletar objeto específico
	
	public void deleteCar(long id) {
		carros.removeIf(car -> car.getId() == id);
		saveCarros();
	}
	
	//Criar car
	public void addCar(Car car) {
		car.setId(getNextId());
		carros.add(car);
		saveCarros();
	}
	
	private void saveCarros() {
		try (PrintWriter writer = new PrintWriter(new FileOutputStream(database, false))) {
			for(Car car: carros) {
				String data = car.getId() + ";" + car.getNome() + ";" + car.getModelo() + ";" + car.getAno();
				
				writer.println(data);
			}
		} catch (FileNotFoundException e) {
			
			System.out.println("Arquivo database não encontrado! Deu ruim irmão.");
		}
	}
	
	//Lógica para pegar o próximo ID
	public long getNextId() {
		long maxId = 0;
		for(Car car: carros) {
			if(car.getId() > maxId	) {
				maxId = car.getId();
			}
		}
		return maxId + 1;
	}
	
	//editar ( update)
	
	public void updateCar(Car updateCar) {
		for(int i = 0 ; i < carros.size(); i ++	) {
			if(carros.get(i).getId() == updateCar.getId()) {
				carros.set(i, updateCar);
				saveCarros();
				break;
			}
		}
	}
	
	public Car getCarById(long id) {
		for(Car car : carros) {
			if(car.getId() == id) {
				return car;
			}
		}
		return null;
	}
	
	
}
