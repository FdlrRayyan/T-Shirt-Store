package component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class RegisScene {

	private Scene scene;
	private BorderPane container;
	private GridPane formContainer, bottomContainer;
	
	private Label idLabel, usernameLabel , passwordLabel, confirmLabel, genderLabel, Adress, Nationality, title;
	private TextField usernameField, idField;
	private TextArea AddressField;
	private PasswordField passwordField, confirmationPassoword;
	
	private FlowPane genderContain;
	
	private RadioButton maleRadioButton, femaleRadioButton;
	
	private ComboBox<String> countryBox;
	private CheckBox agree;
	
	private Button registerButton ;
	private Hyperlink loginHere ;
	
	private ToggleGroup genderToogle;
	
//	Untuk Random ID
//	A-Z
	char min=65;
	char max=90;
	char Nrange = (char) (max - min + 1);
	
//	0-9
	int min1 = 0;
	int max1 = 9;
	int Nrange1 = max1-min1+1;
	
//	Random A-Z
	char Crandom1 = (char)(Math.random()*Nrange + min);	
	char Crandom2 = (char)(Math.random()*Nrange + min);
	char Crandom3 = (char)(Math.random()*Nrange + min);
	
//	Random 0-9
	int Nrandom1 = (int)(Math.random()*Nrange1 + min1);	
	int Nrandom2 = (int)(Math.random()*Nrange1 + min1);
	
	private String RandIDnew = "SU-"+Crandom1+Crandom2+Crandom3+Nrandom1+Nrandom2;
	
	public RegisScene() {
		
		container = new BorderPane();
		formContainer = new GridPane ();
		bottomContainer = new GridPane ();
		
		title = new Label("Register");
		usernameLabel = new Label ("Username");
		idLabel = new Label ("ID");
		passwordLabel = new Label ("Password");
		confirmLabel = new Label ("Confrim Password");
		genderLabel = new Label ("Gender");
		Adress = new Label ("Address");
		Nationality = new Label ("Nationality");
		
		idField = new TextField(RandIDnew);
//		idField.setEditable(false);
		usernameField = new TextField ();
		AddressField = new TextArea ();
		 
		passwordField = new PasswordField();
		confirmationPassoword = new PasswordField ();
		 
		genderToogle = new ToggleGroup();
		genderContain = new FlowPane();
		maleRadioButton = new RadioButton("Male");
		femaleRadioButton = new RadioButton ("Female");
		 
		countryBox = new ComboBox<> ( );

		agree = new CheckBox ("I agree with terms and condition");
		 
		registerButton = new Button ("Register");
		 
		loginHere = new Hyperlink ("Login Here");
		
		scene = new Scene(container, 1200, 720);
		 
	}
	
public Scene build() {
		
		
		container.setTop(title);
		container.setCenter(formContainer);
		container.setBottom(bottomContainer);
		
		formContainer.add(idLabel, 0, 1);
		formContainer.add(idField, 1, 1);
		
		formContainer.add(usernameLabel, 0, 2);
		formContainer.add(usernameField, 1, 2);
		
		formContainer.add(passwordLabel, 0, 3);
		formContainer.add(passwordField, 1, 3);
		
		formContainer.add(confirmLabel, 0, 4);
		formContainer.add(confirmationPassoword, 1, 4);
		
		formContainer.add(genderLabel, 0, 5);
		formContainer.add(genderContain, 1, 5);
		
		genderToogle.getToggles().add(maleRadioButton);
		genderToogle.getToggles().add(femaleRadioButton);
		genderContain.getChildren().add(maleRadioButton);
		genderContain.getChildren().add(femaleRadioButton);
		
		formContainer.add(Adress, 0, 6);
		formContainer.add(AddressField, 1, 6);
		
		formContainer.add(Nationality, 0, 7);
		formContainer.add(countryBox, 1, 7);
		
		countryBox.getItems().add("America");
		countryBox.getItems().add("Australia");
		countryBox.getItems().add("Brazil");
		countryBox.getItems().add("Indonesia");
		countryBox.getItems().add("Malaysia");
		countryBox.getItems().add(" Singapore");
		
		formContainer.add(agree, 1, 8);
	
		bottomContainer.add(registerButton, 0, 0);
		bottomContainer.add(loginHere, 0, 1);
		
		container.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		loginHere.setTextFill(Color.DARKBLUE);
		
		container.setPadding(new Insets(50, 0, 50, 0));
		BorderPane.setAlignment(title, Pos.TOP_CENTER);
		formContainer.setAlignment(Pos.CENTER);
		bottomContainer.setAlignment(Pos.BOTTOM_CENTER);		
		
		title.setFont(new Font("Verdana", 36));
	
		idLabel.setFont(new Font("Verdana", 16));
		idField.setPrefWidth(300);
		idField.setPrefHeight(30);
		idField.setDisable(true);
		
		usernameLabel.setFont(new Font("Verdana", 16));
		usernameField.setPrefWidth(300);
		usernameField.setPrefHeight(30);
		
		passwordLabel.setFont(new Font("Verdana", 16));
		passwordField.setPrefWidth(300);
		passwordField.setPrefHeight(30);
		
		confirmLabel.setFont(new Font("Verdana", 16));
		confirmationPassoword.setPrefWidth(300);
		confirmationPassoword.setPrefHeight(30);
		
		femaleRadioButton.setFont(new Font("Verdana", 12));
		maleRadioButton.setFont(new Font("Verdana", 12));
		genderLabel.setFont(new Font("Verdana", 16));
		genderContain.setPrefWidth(300);
		genderContain.setPrefHeight(30);
		
		Adress.setFont(new Font("Verdana", 16));
		AddressField.setPrefWidth(300);
		AddressField.setPrefHeight(60);
		AddressField.setWrapText(true);
		
		Nationality.setFont(new Font("Verdana", 16));
		countryBox.setPrefWidth(300);
		countryBox.setPrefHeight(30);
		
		formContainer.setHgap(30);
		formContainer.setVgap(10);
		genderContain.setHgap(40);
		genderContain.setPadding(new Insets(7,0,0,0));
		
		registerButton.setPrefHeight(40);
		registerButton.setPrefWidth(120);
		registerButton.setFont(new Font("Verdana", 14));
		
		loginHere.setFont(new Font("Verdana", 14));
		loginHere.setPadding(new Insets(0,0,0,20));
		loginHere.setUnderline(true);
		
		bottomContainer.setVgap(10);
		
		return scene;
		
	}
	
	public Hyperlink getHyperlink() {
		return loginHere;
	}
	
	public Button getButton() {
		return registerButton;
		
	}
	
}

	
