package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private TextField email;
	
	@FXML
	private TextField password;
	public Stage primaryStage;
	
	public void entrar() {
		System.out.println("Login realizado com sucesso");
		
		if(email.getText().equals("admin") && password.getText().equals("admin")) {
			System.out.println("Realizando login com acesso ADMIN");
			
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/dashboard.fxml"));
				
				Parent root = loader.load();
				Scene scene = new Scene(root,12000,800);
				
				Stage currentStage = (Stage) email.getScene().getWindow();
				
				currentStage.close();
				
				currentStage.setScene(scene);
				currentStage.setTitle("Dashboard");
				currentStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			mensagemErro();
		}
	}
	public void mensagemErro() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Sua senha está errada");
		alert.setContentText("Senha Incorreta!");
		alert.setHeaderText(null);
		alert.showAndWait();
	}
}
