package component;

public class TShirt {

	private String ProductName;
	private int ProductPrice;
	private int ProductStock;
	private String ProductType;
	private int ProductID;
	
	public TShirt(String productName, int productPrice, int productStock, String productType, int productID) {
		super();
		ProductName = productName;
		ProductPrice = productPrice;
		ProductStock = productStock;
		ProductType = productType;
		ProductID = productID;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public int getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(int productPrice) {
		ProductPrice = productPrice;
	}

	public int getProductStock() {
		return ProductStock;
	}

	public void setProductStock(int productStock) {
		ProductStock = productStock;
	}

	public String getProductType() {
		return ProductType;
	}

	public void setProductType(String productType) {
		ProductType = productType;
	}

	public int getProductID() {
		return ProductID;
	}

	public void setProductID(int productID) {
		ProductID = productID;
	}
	
	
}
