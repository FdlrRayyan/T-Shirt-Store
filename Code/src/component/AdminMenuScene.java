package component;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AdminMenuScene {

	Scene scene;
	BorderPane mainbp;
	MenuBar menuBar;
	Menu menuUser, menuTransaction ;
	MenuItem menuItemSignOut, ManageTShirt;
	Pane pane;
	BuyTShirtScene buyTShirtScene;
	private void intialize() {
		menuBar = new MenuBar();
		menuBar.setMinWidth(1200);
		menuUser = new Menu("My Admin");
		
		menuTransaction = new Menu("Manage");

		menuItemSignOut = new MenuItem("SignOut");
		ManageTShirt = new MenuItem("Manage T-Shirt");
//		MenuItemViewTransaction = new MenuItem("View Transaction History");
		
		
		
		pane = new Pane();
	}
	
	private void setupComponent(Stage primaryStage) {
		menuBar.getMenus().addAll(menuUser, menuTransaction); 
		menuUser.getItems().addAll(menuItemSignOut);
		//menuEdit.getItems().addAll(menuItemCopy, menuItemCut, menuAdmin);
		menuTransaction.getItems().addAll(ManageTShirt);
		pane.getChildren().add(menuBar);
		
		setEventHandler(primaryStage);
		pane.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		scene = new Scene(pane, 1200, 720);
	}
	
	private void setEventHandler(Stage primaryStage) {
		menuItemSignOut.setOnAction(e -> System.exit(0));
		ManageTShirt.setOnAction(e -> mainbp.setCenter(buyTShirtScene.build()));
		//close main form
		// pindah ke login form
		
		// Ini Button Sebelahnya 
		//If user click Buy T-Shirt, program will open Buy T-Shirt Form inside the Main Form.
		//If user click View Transaction History, program will open View Transaction Form inside the Main Form.
	}
	
	public void start(Stage primaryStage) {
		
		intialize();
		setupComponent(primaryStage);
		primaryStage.setTitle("T-Shirt Store");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
