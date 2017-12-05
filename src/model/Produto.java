package model;

import java.io.Serializable;

import dao.ProductDAO;
import to.ProductTO;

public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int codProduct;
	private String descption;
	private String type;
	private double price;
	
	public Produto() {
		
	}
	
	public Produto(int id, int codProduct, String descption, String type, double price) {
		this.id = id;
		this.codProduct = codProduct;
		this.descption = descption;
		this.type = type;
		this.price = price;
	}
	
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
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getDescption() {
		return descption;
	}
	
	public void setDescption(String descption) {
		this.descption = descption;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void create() {
		ProductDAO dao = new ProductDAO();
		ProductTO to = new ProductTO();
		to.setId(id);
		to.setCodProduct(codProduct);
		to.setDescption(descption);
		to.setType(type);
		to.setPrice(price);
		dao.include(to);
	}
	
	public void update() {
		ProductDAO dao = new ProductDAO();
		ProductTO to = new ProductTO();
		to.setId(id);
		to.setCodProduct(codProduct);
		to.setDescption(descption);
		to.setType(type);
		to.setPrice(price);
		dao.update(to);
	}
	
	public void delete() {
		ProductDAO dao = new ProductDAO();
		ProductTO to = new ProductTO();
		to.setId(id);
		dao.delete(to);
	}
	
	public void load() {
		ProductDAO dao = new ProductDAO();
		ProductTO to = dao.load(id);
		codProduct = to.getCodProduct();
		descption = to.getDescption();
		type = to.getType();
		price = to.getPrice();
	}
	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", codProduto=" + codProduct + ", descricao=" + descption + ", tipo=" + type
				+ ", preco=" + price + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codProduct != other.codProduct)
			return false;
		if (descption == null) {
			if (other.descption != null)
				return false;
		} else if (!descption.equals(other.descption))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
}
