package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.OrderDetail;
import DTO.Product;
import DTO.ProductDetail;
import util.ConnectionProvider;
import util.Pager;

public class ProductDao {

	public List<Product> selectProducts(Pager page) {
		PreparedStatement pstmt;
		Connection conn = ConnectionProvider.getConnection();
		String sql = "select rnum ,  product_id, product_name, product_price from ("
				+ "select rownum as rnum, product_id, product_name, product_price " + "from product where rownum <=? "
				+ ")where rnum >=? ";
		List<Product> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(page.getEndRowNo()));
			pstmt.setString(2, String.valueOf(page.getStartRowNo()));
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Product pro = new Product();

				pro.setProdcutId(rs.getString("product_id"));
				pro.setProductName(rs.getString("product_name"));
				pro.setProductPrice(rs.getInt("product_price"));
				list.add(pro);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.exit(conn);
		}

		return list;
	}

	public List<Product> selectProducts(Pager page, String searchOption) {
		PreparedStatement pstmt;
		Connection conn = ConnectionProvider.getConnection();
		String sql = "select rnum ,  product_id, product_name, product_price from ("
				+ "select rownum as rnum, product_id, product_name, product_price "
				+ "from product where rownum <=? and product_name like '%'||?||'%'" + ")where rnum >=? ";
		List<Product> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(page.getEndRowNo()));
			pstmt.setString(2, searchOption);
			pstmt.setString(3, String.valueOf(page.getStartRowNo()));
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Product pro = new Product();
				pro.setProdcutId(rs.getString("product_id"));
				pro.setProductName(rs.getString("product_name"));
				pro.setProductPrice(rs.getInt("product_price"));
				list.add(pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.exit(conn);
		}

		return list;
	}

	public int selectCountProduct() {
		PreparedStatement pstmt;
		Connection conn = ConnectionProvider.getConnection();
		String sql = "select count(product_id)as count " + "from product";

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.exit(conn);
		}
		return 0;
	}

	public Product selectProduct(String productId) {
		PreparedStatement pstmt;
		Connection conn = ConnectionProvider.getConnection();
		Product product = new Product();
		try {
			String sql = "select product_id, product_name,product_price,product_content,"
					+ "product_graphic_card,product_cpu,product_mainboard,product_os,product_memory "
					+ "from product where product_id= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productId);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				product.setProdcutId(rs.getString("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setProductContent(rs.getString("product_content"));
				product.setProductGraphicCard(rs.getString("product_graphic_card"));
				product.setCPU(rs.getString("product_cpu"));
				product.setMainboard(rs.getString("product_mainboard"));
				product.setOs(rs.getString("product_os"));
				product.setMemory(rs.getString("product_memory"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.exit(conn);
		}

		return product;
	}

	public Product selectProductSubQuery(String productDetailId) {
		PreparedStatement pstmt;
		Connection conn = ConnectionProvider.getConnection();
		Product product = new Product();
		try {
			String sql = "select product_id, product_name,product_price,product_content,"
					+ "product_graphic_card,product_cpu,product_mainboard,product_os,product_memory "
					+ "from product where product_id= "
					+ "(select product_product_id from product_detail where detail_id= ? )";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productDetailId);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				product.setProdcutId(rs.getString("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setProductContent(rs.getString("product_content"));
				product.setProductGraphicCard(rs.getString("product_graphic_card"));
				product.setCPU(rs.getString("product_cpu"));
				product.setMainboard(rs.getString("product_mainboard"));
				product.setOs(rs.getString("product_os"));
				product.setMemory(rs.getString("product_memory"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.exit(conn);
		}

		return product;
	}


	public void insertProduct(Product product) {
		/*String sql = "insert into product(product_id,product_name,product_price,"
				+ "product_content,product_date,product_graphic_card,"
				+ "product_cpu,product_mainboard,product_os,product_memory) "
				+ "values('pro'||product_id.nextval,?,?,?,sysdate,?,?,?,?,?)";
		sql = "insert into product_detail "
				+ "(detail_id, detail_color, detail_capacity, product_product_id, detail_qnt) "
				+ "values('proD'||product_detail_id.nextval,?,?,?,?)";

		sql = "update product set PRODUCT_NAME =?, PRODUCT_PRICE,"
				+ "PRODUCT_CONTENT=?,PRODUCT_DATE=?,PRODUCT_GRAPHIC_CARD=?,"
				+ "PRODUCT_CPU=?,PRODUCT_MAINBOARD=?,PRODUCT_OS=?,PRODUCT_MEMORY=? where PRODUCT_ID=?";

		sql = "update product_detail set DETAIL_COLOR=?," + "DETAIL_CAPACITY=?,DETAIL_QNT=? where detail_id=?";
		
		sql = "delete from product where product_id =?";
		
		sql="select p.product_name, d.detail_color, d.detail_capacity, o.price, o.product_qnt, "
				+ "(o.price*o.product_qnt )as sum, o.order_detail_id ,d.detail_id "
				+ "from product p, product_detail d, order_detail o "
				+ "where p.product_id=d.product_product_id "
				+ "and o.product_detail_detail_id=d.detail_id "
				+ "and o.ORDERS_ORDER_ID=?";
		
		sql = "select order_id, order_date, order_status, total_price, "
				+ "RECEIVER_NAME,RECEIVER_ADDRESS,RECEIVER_PHONE "
				+ "from orders where user_user_id=?";*/
	}
	
}

