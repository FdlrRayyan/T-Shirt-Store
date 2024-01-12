package component;

import java.sql.Date;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import jfxtras.labs.scene.control.window.CloseIcon;
import jfxtras.labs.scene.control.window.Window;

public class TransactionHistory {

	private Scene scene;
	private TableView<TShirt> tShirtTable;
	private TableView<TransactionHistory> historyTable;
	private BorderPane bp;
	private GridPane gp, tp, bottomPn;
	private Window window;
	
	public Window build() {
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
		
		historyTable = new TableView<>();
		TableColumn<TransactionHistory, Character> tranID = new TableColumn<>("Transaction ID");
		TableColumn<TransactionHistory, Date> tranDate = new TableColumn<>("Transaction Date");
		
		tranID.setCellValueFactory(new PropertyValueFactory<TransactionHistory, Character>("Transaction ID"));
		tranDate.setCellValueFactory(new PropertyValueFactory<TransactionHistory, Date>("Transaction Date"));
		
		historyTable.getColumns().addAll(tranID, tranDate);
		
		gp = new GridPane();
		tp = new GridPane();
		bottomPn = new GridPane();
		
		tp.add(historyTable, 0, 1);
		bottomPn.add(tShirtTable, 0, 1);
		
		bp = new BorderPane();
		bp.setTop(tp);
		bp.setCenter(bottomPn);
		
		tp.setAlignment(Pos.TOP_CENTER);
		bottomPn.setAlignment(Pos.BOTTOM_CENTER);
		gp.setPadding(new Insets(0,0,50,0));
		tShirtTable.setMinWidth(1170);
		tShirtTable.setMaxHeight(200);
		historyTable.setMinWidth(1170);
		historyTable.setMaxHeight(200);
		scene = new Scene(bp, 1200, 700);
		bp.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		tShirtTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		historyTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		window.getRightIcons().add(new CloseIcon(window));
		window.getContentPane().getChildren().add(bp);
		return window;
		
	}

}
