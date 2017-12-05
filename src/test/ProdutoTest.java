package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.Produto;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest {
	Produto product, copy;
	static int id = 0;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		product = new Produto(id, 1, "Feijão", "Prato Principal", 25.00);
		copy =   new Produto(id, 1, "Feijão", "Prato Principal", 25.00);
		System.out.println(product);
		System.out.println(copy);
		System.out.println(id);
	}

	@Test
	public void testLoad() {
		System.out.println("carregar");
		Produto fixture = new Produto(1, 2, "Abóbora com carne de soja no tacho", "Prato", 45.50);
		Produto novo = new Produto(1, 0, null, null, 0);
		novo.load();
		assertEquals("testa inclusao", novo, fixture);
	}
					
	@Test
	public void testCreate() {
		System.out.println("criar");
		product.create();
		id = product.getId();
		System.out.println(id);
		copy.setId(id);
		assertEquals("Teste de Criação", product, copy);
	}
	
	@Test
	public void testUpdate() {
		System.out.println("atualizar");
		product.setType("Sobremesa");
		copy.setType("Sobremesa");
		product.update();
		product.load();
		assertEquals("Teste de Atualização", product, copy);
	}

	@Test
	public void testDelete() {
		System.out.println("excluir");
		copy.setId(0);
		copy.setCodProduct(0);
		copy.setDescption(null);
		copy.setType(null);
		copy.setPrice(0);
		product.delete();
		product.load();
		assertEquals("Teste de Exclusão", product, copy);
	}
	
}
