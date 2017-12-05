package to;

public class ProductTO {
	private int id;
	private int codProduct;
	private String descption;
	private String type;
	private double price;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCodProduct() {
		return codProduct;
	}
	
	public void setCodProduct(int codProduct) {
		this.codProduct = codProduct;
	}
	
	public String getDescption() {
		return descption;
	}
	
	public void setDescption(String descption) {
		this.descption = descption;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
}
