package component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import jfxtras.labs.scene.control.window.CloseIcon;
import jfxtras.labs.scene.control.window.Window;

public class BuyTShirtScene {

	private Scene scene;
	private BorderPane borderPn;
	private GridPane gridPn, buttonPn, topPn, buttonPn1;
	
	private TableView<TShirt> tShirtTable;
	private TableView<CartTShirt> cartTshirtTable;
	
	private Label tshirtLb, tshirtNameLb, tshirtPriceLb, tshirtQuantityLb, cartLb;
	private TextField tshirtTF, tshirtNameTF, tshirtPriceTF;
	private Spinner<Integer> tshirtQuantitySpinner;
	private Button addButton, removeButton, updateButton, buyButton;
	private HBox bottomButton;
	private Window window;
	
	public BuyTShirtScene() {
		gridPn = new GridPane();
		buttonPn = new GridPane();
		topPn = new GridPane();
		
		tshirtLb = new Label("Product ID");
		tshirtNameLb = new Label("Product Name");
		tshirtPriceLb = new Label("Product Price");
		cartLb = new Label("Cart");
		tshirtQuantityLb = new Label("Product Quantity");
		tshirtQuantitySpinner = new Spinner<Integer>(1, 30, 0);
		tshirtTF = new TextField();
		tshirtNameTF = new TextField();
		tshirtPriceTF = new TextField();
		addButton = new Button("Add to Cart");
		removeButton = new Button("Remove T-Shirt");
		updateButton = new Button("Update T-Shirt");
		buyButton = new Button("BUY");
		bottomButton = new HBox();
		borderPn = new BorderPane();
		buttonPn1 = new GridPane();
		window = new Window();
		
		tShirtTable = new TableView<>();
		TableColumn<TShirt, Character> idCol = new TableColumn<>("Product ID");
		TableColumn<TShirt, String> nameCol = new TableColumn<>("Product Name");
		TableColumn<TShirt, Integer> priceCol = new TableColumn<>("Product Price");
		TableColumn<TShirt, Integer> stockCol = new TableColumn<>("Product Stock");
		TableColumn<TShirt, String> typeCol = new TableColumn<>("Product Type");
		
		idCol.setCellValueFactory(new PropertyValueFactory<TShirt, Character>("Product ID"));
		nameCol.setCellValueFactory(new PropertyValueFactory<TShirt, String>("Product Name"));
		priceCol.setCellValueFactory(new PropertyValueFactory<TShirt, Integer>("Product Price"));
		stockCol.setCellValueFactory(new PropertyValueFactory<TShirt, Integer>("Product Stock"));
		typeCol.setCellValueFactory(new PropertyValueFactory<TShirt, String>("Product Type"));
		
		tShirtTable.getColumns().addAll(idCol, nameCol, priceCol, stockCol, typeCol);
		
		cartTshirtTable = new TableView<>();
		TableColumn<CartTShirt, Character> cartidCol = new TableColumn<>("Shirt ID");
		TableColumn<CartTShirt, String> cartnameCol = new TableColumn<>("Shirt Name");
		TableColumn<CartTShirt, Integer> cartpriceCol = new TableColumn<>("Shirt Price");
		TableColumn<CartTShirt, Integer> cartQuanCol = new TableColumn<>("Shirt Quantity");
		TableColumn<CartTShirt, String> carttypeCol = new TableColumn<>("Shirt Type");
		
		cartidCol.setCellValueFactory(new PropertyValueFactory<CartTShirt, Character>("Shirt ID"));
		cartnameCol.setCellValueFactory(new PropertyValueFactory<CartTShirt, String>("Shirt Name"));
		cartpriceCol.setCellValueFactory(new PropertyValueFactory<CartTShirt, Integer>("Shirt Price"));
		cartQuanCol.setCellValueFactory(new PropertyValueFactory<CartTShirt, Integer>("Shirt Quantity"));
		carttypeCol.setCellValueFactory(new PropertyValueFactory<CartTShirt, String>("Shirt Type"));
		
		cartTshirtTable.getColumns().addAll(cartidCol, cartnameCol, cartpriceCol, cartQuanCol, carttypeCol);
	
		updateButton.setOnAction( event -> {
			String name = tshirtTF.getText();
			Integer price  =tshirtPriceTF.getAnchor(); 
			Integer quantity = tshirtQuantitySpinner.getValue();
			
			//table insert
			TShirt  selected = tShirtTable.getSelectionModel().getSelectedItem();
			 
			});
	}
	
//	public Scene build1() {
//		
//		return scene;
		
	
	
	public Window build() {
		tShirtTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		cartTshirtTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//		tShirtTable.effectiveNodeOrientationProperty();

		borderPn.setBottom(buttonPn);
		borderPn.setTop(topPn);
		borderPn.setCenter(gridPn);
//		borderPn.setBottom(bottomButton);
		borderPn.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		topPn.add(tShirtTable, 0, 1);
		gridPn.add(tshirtLb, 0, 1);
		gridPn.add(tshirtNameLb, 0, 2);
		gridPn.add(tshirtPriceLb, 0, 3);
		gridPn.add(tshirtQuantityLb, 0, 4);
		gridPn.add(addButton, 2, 4);
		gridPn.add(tshirtTF, 1, 1);
		gridPn.add(tshirtNameTF, 1, 2);
		gridPn.add(tshirtPriceTF, 1, 3);
		gridPn.add(tshirtQuantitySpinner, 1, 4);
		buttonPn.add(cartLb, 0, 0);
		buttonPn.add(cartTshirtTable, 0, 1);
		
		buttonPn1.add(removeButton, 1, 0);
		buttonPn1.add(updateButton, 2, 0);
		buttonPn1.add(buyButton, 3, 0);
		
		buttonPn.add(buttonPn1, 0, 2);
		
		tshirtLb.setFont(new Font("Verdana", 16));
		tshirtTF.setPrefWidth(300);
		tshirtTF.setPrefHeight(40);
		
		tshirtNameLb.setFont(new Font("Verdana", 16));
		tshirtNameTF.setPrefWidth(300);
		tshirtNameTF.setPrefHeight(40);
		
		tshirtPriceLb.setFont(new Font("Verdana", 16));
		tshirtPriceTF.setPrefWidth(300);
		tshirtPriceTF.setPrefHeight(40);
		
		tshirtQuantityLb.setFont(new Font("Verdana", 16));
		tshirtQuantitySpinner.setPrefWidth(300);
		tshirtQuantitySpinner.setPrefHeight(40);
		
		addButton.setFont(new Font("Verdana", 14));
		addButton.setPrefWidth(120);
		addButton.setPrefHeight(40);
		
		gridPn.setHgap(20);
		gridPn.setVgap(10);
		
		buttonPn1.setHgap(200);
		
		buttonPn1.setPadding(new Insets(0,0,0,-200));
		
		removeButton.setPrefWidth(120);
		removeButton.setPrefHeight(30);
		
		updateButton.setPrefWidth(120);
		updateButton.setPrefHeight(30);
		
		buyButton.setPrefWidth(120);
		buyButton.setPrefHeight(30);
		
		topPn.setAlignment(Pos.TOP_CENTER);
		buttonPn.setAlignment(Pos.BOTTOM_CENTER);
		buttonPn1.setAlignment(Pos.BOTTOM_CENTER);
		gridPn.setAlignment(Pos.CENTER_LEFT);
		gridPn.setPadding(new Insets(0,0,50,0));
		cartLb.setFont(new Font("Verdana", 24));
		cartLb.setPadding(new Insets(0,0,0,20));
		tShirtTable.setPrefWidth(1180);
		tShirtTable.setPrefHeight(225);
		cartTshirtTable.setPrefWidth(1180);
		cartTshirtTable.setPrefHeight(225);
		scene = new Scene(borderPn, 1200, 720);
		window.getRightIcons().add(new CloseIcon(window));
		window.getContentPane().getChildren().add(borderPn);
		
		return window;
		
	}

}
