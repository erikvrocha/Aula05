package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProdutoService;
import to.ProductTO;

@WebServlet("/ManterProduto.do")
public class CrudProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pCodProduct = Integer.parseInt(request.getParameter("codProduto"));
		String pDescrption = request.getParameter("descricao");
		int pPrice = Integer.parseInt(request.getParameter("preco"));
		String pType = request.getParameter("tipo");
		
		ProductTO product = new ProductTO();
		product.setCodProduct(pCodProduct);
		product.setDescption(pDescrption);
		product.setPrice(pPrice);
		product.setType(pType);
		
		//Para Instanciar o Service
		ProdutoService ps = new ProdutoService();
		ps.criar(product);
		product = ps.carregar(product.getId());
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Cliente Cadastrado</title></head><body>");
		out.println( "ID: "+product.getId()+"<br>");
		out.println( "Codigo do Produto: "+product.getCodProduct()+"<br>");
		out.println( "Descrição: "+product.getDescption()+"<br>");
		out.println( "Preço: "+product.getPrice()+"<br>");
		out.println( "Tipo: " +product.getType()+"<br>");
		out.println("</body></html>");
	}

}
