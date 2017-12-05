package service;

import to.ProductTO;
import dao.ProductDAO;


public class ProdutoService {
	ProductDAO dao;
	
	public ProdutoService() {
		dao = new ProductDAO();
	}
	
	public void criar(ProductTO to) {
		dao.include(to);
	}
	
	public void atualizar(ProductTO to){
		dao.update(to);
	}
	
	public void excluir(ProductTO to){
		dao.delete(to);
	}
	
	public ProductTO carregar(int id){
		ProductTO to = dao.load(id);
		return to;
	}
}
