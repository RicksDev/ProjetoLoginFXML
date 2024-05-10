package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML
	private TextField email;
	
	@FXML
	private TextField password;
	
	public void entrar() {
		System.out.println("Login realizado com sucesso");
		
		if(email.getText().equals("admin") && password.getText().equals("admin")) {
			System.out.println("Realizando login com acesso ADMIN");
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
