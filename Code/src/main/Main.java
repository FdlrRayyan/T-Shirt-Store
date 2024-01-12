package main;

import component.AdminMenuScene;
import component.BuyTShirtScene;
import component.LoginScene;
import component.ManageTshirt;
import component.RegisScene;
import component.TransactionHistory;
import component.UserMenuScene;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application{
	
	LoginScene loginScene;
	RegisScene regisScene;
	UserMenuScene userMenuScene;
	AdminMenuScene adminMenuScene;
	BuyTShirtScene buyTShirtScene;
	TransactionHistory transactionHistory;
	ManageTshirt manageTShirt;
	BorderPane mainbp;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		loginScene = new LoginScene();
		regisScene = new RegisScene();
		userMenuScene = new UserMenuScene();
		adminMenuScene = new AdminMenuScene();
		buyTShirtScene = new BuyTShirtScene();
		transactionHistory = new TransactionHistory();
		manageTShirt = new ManageTshirt();
		
		mainbp = new BorderPane();
		loginScene.getButton().setOnMousePressed(event -> adminMenuScene.start(primaryStage));
		loginScene.getHyperlink().setOnMousePressed(event -> primaryStage.setScene(regisScene.build()));
		regisScene.getHyperlink().setOnMousePressed(event -> primaryStage.setScene(loginScene.build()));
		regisScene.getButton().setOnMousePressed(event -> userMenuScene.start(primaryStage));
		primaryStage.setScene(loginScene.build());
		primaryStage.show();
		
	}

}
