package component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LoginScene {

	private Scene scene;
	private BorderPane container;
	
//	private Button button;
	
	private Label title;
	
	private GridPane formContainer,bottomContainer;
	private TextField usernameField;
	private PasswordField passwordField;
	private Label usernameLabel, passwordLabel;
	
//	private VBox bottomContainer;
	private Button loginBtn;
	private Hyperlink registerHypr;
	
	public LoginScene() {
		container = new BorderPane();
		
		title = new Label("Welcome to T-Shirt Store");
		
		formContainer = new GridPane();
		bottomContainer = new GridPane();
		usernameField = new TextField();
		passwordField = new PasswordField();
		
		usernameLabel = new Label("Username");
		passwordLabel = new Label("Password");
		
		loginBtn = new Button("Login");
		registerHypr = new Hyperlink("Register");
		
		scene = new Scene(container, 1200, 720);
	}
	
//	public Scene build() {
//		
//			
//		return scene;
//	}

	public Scene build() {
		
		container.setTop(title);
		container.setCenter(formContainer);
		container.setBottom(bottomContainer);
		
		formContainer.add(usernameLabel, 0, 0);
		formContainer.add(usernameField, 1, 0);
		formContainer.add(passwordLabel, 0, 1);
		formContainer.add(passwordField, 1, 1);
		
		bottomContainer.add(loginBtn, 0, 0);
		bottomContainer.add(registerHypr, 0, 1);
		
//		usernameField.visibleProperty();
		container.setPadding(new Insets(50, 0, 50, 0));
		container.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		loginBtn.setPrefHeight(40);
		loginBtn.setPrefWidth(120);
		registerHypr.setTextFill(Color.DARKBLUE);
		BorderPane.setAlignment(title, Pos.TOP_CENTER);
		formContainer.setAlignment(Pos.CENTER);
		bottomContainer.setAlignment(Pos.BOTTOM_CENTER);
		
		usernameLabel.setFont(new Font("Verdana", 16));
		passwordLabel.setFont(new Font("Verdana", 16));
		
		usernameField.setPrefWidth(300);
		passwordField.setPrefWidth(300);
		usernameField.setPrefHeight(30);
		passwordField.setPrefHeight(30);
		
		formContainer.setHgap(30);
		formContainer.setVgap(10);
		
		title.setFont(new Font("Verdana", 36));
		loginBtn.setFont(new Font("Verdana", 14));
		registerHypr.setFont(new Font("Verdana", 14));
		registerHypr.setUnderline(true);
		loginBtn.setPadding(new Insets(0,0,0,0));
		registerHypr.setPadding(new Insets(0,0,0,30));
		bottomContainer.setVgap(10);
		
		
		return scene;
	}

	public Hyperlink getHyperlink() {
		return registerHypr;
	}
	
	public Button getButton() {
		return loginBtn;
		
	}

}
