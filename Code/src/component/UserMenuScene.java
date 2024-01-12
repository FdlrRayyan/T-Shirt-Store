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

public class UserMenuScene {

	Scene scene;
	BorderPane mainbp;
	MenuBar menuBar;
	Menu menuUser, menuTransaction ;
	MenuItem menuItemSignOut, menuItemBuyTShirt , MenuItemViewTransaction;
	Pane pane;
	BuyTShirtScene buyTShirtScene;
	TransactionHistory transactionHistory;

	private void intialize() {
		menuBar = new MenuBar();

		menuUser = new Menu("My User");
		
		menuTransaction = new Menu("Transaction ");

		menuItemSignOut = new MenuItem("SignOut");
		menuItemBuyTShirt = new MenuItem("Buy T-Shirt");
		MenuItemViewTransaction = new MenuItem("View Transaction History");
		mainbp = new BorderPane();
		buyTShirtScene = new BuyTShirtScene(); // ini error di komputer gua aja gara2 gk ada window
		
		pane = new Pane();
	}
	
	private void setupComponent(Stage primaryStage) {
		menuBar.getMenus().addAll(menuUser, menuTransaction);
		menuBar.setMinWidth(1200);
		menuUser.getItems().addAll(menuItemSignOut);
		//menuEdit.getItems().addAll(menuItemCopy, menuItemCut, menuAdmin);
		menuTransaction.getItems().addAll(menuItemBuyTShirt, MenuItemViewTransaction);
		pane.getChildren().add(menuBar);
		
		setEventHandler(primaryStage);
		pane.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		scene = new Scene(pane, 1200, 720);
	}
	
	private void setEventHandler(Stage primaryStage) {	
		menuItemSignOut.setOnAction(e -> System.exit(0));
		menuItemBuyTShirt.setOnAction(e -> mainbp.setCenter(buyTShirtScene.build()));
		MenuItemViewTransaction.setOnAction(e -> mainbp.setCenter(transactionHistory.build()));
		//close main form		
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
