package component;

public class CartTShirt {

	private String shirtName;
	private int shirtPrice;
	private int shirtQuantity;
	private String shirtType;
	private int shirtID;
	
	public CartTShirt(String shirtName, int shirtPrice, int shirtQuantity, String shirtType, int shirtID) {
		super();
		this.shirtName = shirtName;
		this.shirtPrice = shirtPrice;
		this.shirtQuantity = shirtQuantity;
		this.shirtType = shirtType;
		this.shirtID = shirtID;
	}

	public String getShirtName() {
		return shirtName;
	}

	public void setShirtName(String shirtName) {
		this.shirtName = shirtName;
	}

	public int getShirtPrice() {
		return shirtPrice;
	}

	public void setShirtPrice(int shirtPrice) {
		this.shirtPrice = shirtPrice;
	}

	public int getShirtQuantity() {
		return shirtQuantity;
	}

	public void setShirtQuantity(int shirtQuantity) {
		this.shirtQuantity = shirtQuantity;
	}

	public String getShirtType() {
		return shirtType;
	}

	public void setShirtType(String shirtType) {
		this.shirtType = shirtType;
	}

	public int getShirtID() {
		return shirtID;
	}

	public void setShirtID(int shirtID) {
		this.shirtID = shirtID;
	}
	
	

}
