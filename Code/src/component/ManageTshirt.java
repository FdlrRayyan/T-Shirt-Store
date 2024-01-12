package component;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import jfxtras.labs.scene.control.window.Window;
import main.Connect;

public class ManageTshirt extends Application implements EventHandler<ActionEvent>{

	private Scene scene, manageScene;
	private TableView<TShirt> tShirtTable;
	private BorderPane borderPane, tablePane, managePane;
	private GridPane gridPane, buttonPane, topPane;
	private Label tshirtNameLb, tshirtPriceLb, tshirtStockLb, tshirtTypeLb;
	private TextField tshirtNameTF, tshirtPriceTF  ;
	private Spinner<Integer> tshirtQuantityStock;
	private ComboBox<String> tshirtTypeCombo;
	private Button addButton, deleteButton, updateButton;
	private Window window;
	private ListView<String> manageTshirtListView;
	
	public Window build() {
		tShirtTable = new TableView<>();
		TableColumn<TShirt, String> idCol = new TableColumn<>("Product ID");
		TableColumn<TShirt, String> nameCol = new TableColumn<>("Product Name");
		TableColumn<TShirt, Integer> priceCol = new TableColumn<>("Product Price");
		TableColumn<TShirt, Integer> stockCol = new TableColumn<>("Product Stock");
		TableColumn<TShirt, String> typeCol = new TableColumn<>("Product Type");
		
		idCol.setCellValueFactory(new PropertyValueFactory<TShirt, String>("Product ID"));
		nameCol.setCellValueFactory(new PropertyValueFactory<TShirt, String>("Product Name"));
		priceCol.setCellValueFactory(new PropertyValueFactory<TShirt, Integer>("Product Price"));
		stockCol.setCellValueFactory(new PropertyValueFactory<TShirt, Integer>("Product Stock"));
		typeCol.setCellValueFactory(new PropertyValueFactory<TShirt, String>("Product Type"));
		
		tShirtTable.getColumns().addAll(idCol,nameCol, priceCol, stockCol, typeCol);
		
		gridPane = new GridPane();
		buttonPane = new GridPane();
		topPane = new GridPane();
		managePane = new BorderPane();
		
		tshirtNameLb = new Label("Product Name");
		tshirtPriceLb = new Label("Product Price");
		tshirtStockLb = new Label("Product Stock");
		tshirtTypeLb = new Label("Product Type");
		tshirtQuantityStock = new Spinner<Integer>(1,30,0);
		tshirtTypeCombo = new ComboBox<String>();
		tshirtNameTF = new TextField();
		tshirtPriceTF = new TextField();
		addButton = new Button("ADD");
		deleteButton = new Button("Delete");
		updateButton = new Button("Update");
//		HBox bottomButton = new HBox();
		
		tshirtTypeCombo.getItems().add("Oversize");
		tshirtTypeCombo.getItems().add("Turtleneck");
		tshirtTypeCombo.getItems().add("O-Neck");
		tshirtTypeCombo.getItems().add("V-Neck");
		tshirtTypeCombo.getSelectionModel().selectFirst();
		
		topPane.add(tShirtTable, 0, 1);
		gridPane.add(tshirtNameLb, 0, 1);
		gridPane.add(tshirtPriceLb, 0, 2);
		gridPane.add(tshirtStockLb, 0, 3);
		gridPane.add(tshirtTypeLb, 0, 4);
		gridPane.add(tshirtNameTF, 1, 1);
		gridPane.add(tshirtPriceTF, 1, 2);
		gridPane.add(tshirtQuantityStock, 1, 3);
		gridPane.add(tshirtTypeCombo, 1, 4);
		buttonPane.add(deleteButton, 1, 1);
		buttonPane.add(updateButton, 2, 1);
		buttonPane.add(addButton, 3, 1);
		buttonPane.setHgap(200);
		buttonPane.setPadding(new Insets(0,200,0,0));
//		bottomButton.getChildren().addAll(deleteButton, updateButton, addButton);
		
		
		borderPane = new BorderPane();
//		borderPane.setBottom(buttonPane);
		borderPane.setTop(topPane);
		borderPane.setCenter(gridPane);
		borderPane.setBottom(buttonPane);
		
		topPane.setAlignment(Pos.TOP_CENTER);
		buttonPane.setAlignment(Pos.BOTTOM_CENTER);
		gridPane.setAlignment(Pos.CENTER_LEFT);
		gridPane.setPadding(new Insets(0,0,50,0));
		tShirtTable.setMinWidth(1170);
		tShirtTable.setMaxHeight(200);
		scene = new Scene(borderPane, 1200, 720);
		tShirtTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		borderPane.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		gridPane.setVgap(20);
		gridPane.setHgap(10);
		//set on action
		
		tshirtNameLb.setFont(new Font("Verdana", 16));
		tshirtNameTF.setPrefWidth(300);
		tshirtNameTF.setPrefHeight(40);
		
		tshirtPriceLb.setFont(new Font("Verdana", 16));
		tshirtPriceTF.setPrefWidth(300);
		tshirtPriceTF.setPrefHeight(40);
		
		tshirtStockLb.setFont(new Font("Verdana", 16));
		tshirtQuantityStock.setPrefWidth(300);
		tshirtQuantityStock.setPrefHeight(40);
		
		tshirtTypeLb.setFont(new Font("Verdana", 16));
		tshirtTypeCombo.setPrefWidth(300);
		tshirtTypeCombo.setPrefHeight(40);
		
		addButton.setFont(new Font("Verdana", 14));
		addButton.setPrefWidth(120);
		addButton.setPrefHeight(40);
		
		updateButton.setFont(new Font("Verdana", 14));
		updateButton.setPrefWidth(120);
		updateButton.setPrefHeight(40);
		
		deleteButton.setFont(new Font("Verdana", 14));
		deleteButton.setPrefWidth(120);
		deleteButton.setPrefHeight(40);
		
		
		
		addButton.setOnAction(this);
		return window;
	}
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	
	}

	@Override
	public void handle(ActionEvent arg0) {
		
		String name = tshirtNameTF.getText();
		int price = tshirtPriceTF.getAnchor();
		int  stock = tshirtQuantityStock.getValue();
		
		
		if (arg0.getSource()== addButton) {
			
			
			if (name.length()< 5 || name.length()> 15){
				Alert alert = new Alert (AlertType.ERROR);
				alert.setTitle("Error");
				alert.setContentText("	New T-Shirt Name must consist of 5 - 15 characters.");
				alert.show();
				
			}else 
				if (price < 0) {
					Alert alert = new Alert (AlertType.ERROR);
					alert.setTitle("Error");
					alert.setContentText("Price can't be zero, can't minus and must numeric");
					alert.show();
				}
				else
					if (stock < 0) {
						Alert alert = new Alert (AlertType.ERROR);
						alert.setTitle("Error");
						alert.setContentText("Must Be Greater Than Zero");
						alert.show();
					}
					else
						if(tshirtTypeCombo.getItems().isEmpty()) {
							Alert alert = new Alert (AlertType.ERROR);
							alert.setTitle("Error");
							alert.setContentText("Must be choosen either Oversize, TurtleNeck, O-Neck, or V-Neck");
							alert.show();
						}
				
			tShirtTable.getItems().add(new TShirt(tshirtNameTF.getText(), tshirtPriceTF.getAnchor(), tshirtQuantityStock.getValue(), tshirtTypeCombo.getValue() , 0));
			Alert alert = new Alert (AlertType.INFORMATION);
			alert.setTitle("Successful ");
			alert.setContentText(" Data Input Successfull");
			alert.show();
			
		}
		
		if(arg0.getSource()== updateButton) {
			String nameTF = tshirtNameTF.getText();
			int priceTF = tshirtPriceTF.getAnchor();
			int stockTF = tshirtQuantityStock.getValue();
			
			TShirt selected = tShirtTable.getSelectionModel().getSelectedItem();
			
			
			String query = "SELECT * FROM student"; // tolong diganti fungsi insert dari databasenya.
			Connect con = Connect.getInstance();		
			
		
		}
		
		if(arg0.getSource()== deleteButton ) {
			
			if(tShirtTable.getSelectionModel().getSelectedItem() == null) {
				
				Alert alert = new Alert (AlertType.ERROR);
				alert.setTitle("Error ");
				alert.setContentText(" Click the Table Row First ");
				alert.show();
			}
			else {
				TShirt selected =tShirtTable.getSelectionModel().getSelectedItem();
				String query = "SELECT * FROM student"; // tolong ganti fungsi delete dari database server/
				
				refreshTable ();
				Alert alert = new Alert (AlertType.INFORMATION);
				alert.setTitle("Successful ");
				alert.setContentText("Success Delete T-Shirt !");
				alert.show();
				
			}
			
			
			
		}
		
	}

	void refreshTable (){
	
			tShirtTable.getItems().clear();
		
	}
		
}




