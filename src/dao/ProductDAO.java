package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import to.ProductTO;

public class ProductDAO {
	public void include(ProductTO to) {
		String sqlInsert = "INSERT INTO PRODUTOS (cod_produto, descricao, tipo, preco) VALUES (?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, to.getCodProduct());
			stm.setString(2, to.getDescption());
			stm.setString(3, to.getType());
			stm.setDouble(4, to.getPrice());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); 
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt(1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(ProductTO to) {
		String sqlUpdate = "UPDATE produtos SET cod_produto = ?, descricao = ?, tipo = ? , preco = ? WHERE id = ?";
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, to.getCodProduct());
			stm.setString(2, to.getDescption());
			stm.setString(3, to.getType());
			stm.setDouble(4, to.getPrice());
			stm.setInt(5, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(ProductTO to) {
		String sqlDelete = "DELETE FROM produtos WHERE id = ?";
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ProductTO load(int id) {
		ProductTO to = new ProductTO();
		String sqlSelect = "SELECT cod_produto, descricao, tipo, preco FROM produtos WHERE produtos.id = ?";

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setCodProduct(rs.getInt("cod_produto"));
					to.setDescption(rs.getString("descricao"));
					to.setType(rs.getString("tipo"));
					to.setPrice(rs.getDouble("preco"));
					
				} else {
					to.setId(-1);
					to.setCodProduct(0);
					to.setDescption(null);
					to.setType(null);
					to.setPrice(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}

	public ArrayList<ProductTO> listarProdutos() {
		ProductTO to;
		ArrayList<ProductTO> list = new ArrayList<>();
		String sqlSelect = "";

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					to = new ProductTO();
					// setando atributos
					list.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		return list;
	}

	public ArrayList<ProductTO> listProducts(String chave) {
		ProductTO to;
		ArrayList<ProductTO> list = new ArrayList<>();
		String sqlSelect = "";

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					to = new ProductTO();
					// set atributos
					list.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		return list;
	}
}
