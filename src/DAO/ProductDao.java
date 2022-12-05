package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.Product;
import util.Pager;

public class ProductDao {

	public List<Product> selectProducts(Pager page, Connection conn) throws Exception{
		List<Product> list = new ArrayList<>();
		
		String sql = "select rnum ,  product_id, product_name, product_price from ("
				+ "select rownum as rnum, product_id, product_name, product_price " + "from product where rownum <=? "
				+ ")where rnum >=? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, String.valueOf(page.getEndRowNo()));
		pstmt.setString(2, String.valueOf(page.getStartRowNo()));
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Product productDto = new Product();
			productDto.setProdcutId(rs.getString("product_id"));
			productDto.setProductName(rs.getString("product_name"));
			productDto.setProductPrice(rs.getInt("product_price"));
			list.add(productDto);
		}
		
		return list;
	}

	public List<Product> selectProducts(Pager page, String searchOption, Connection conn) throws Exception{
		List<Product> list = new ArrayList<>();
		
		String sql = "select rnum ,  product_id, product_name, product_price from ("
				+ "select rownum as rnum, product_id, product_name, product_price "
				+ "from product where rownum <=? and product_name like '%'||?||'%'" + ")where rnum >=? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, String.valueOf(page.getEndRowNo()));
		pstmt.setString(2, searchOption);
		pstmt.setString(3, String.valueOf(page.getStartRowNo()));
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Product productDto = new Product();
			productDto.setProdcutId(rs.getString("product_id"));
			productDto.setProductName(rs.getString("product_name"));
			productDto.setProductPrice(rs.getInt("product_price"));
			list.add(productDto);
		}
		
		return list;
	}

	public int selectCountProduct(Connection conn) throws Exception{
		int count=0;
		
		String sql = "select count(product_id)as count from product";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			count = rs.getInt("count");
		}
		
		return count;
	}

	public Product selectProduct(String productId, Connection conn)throws Exception {
		Product productDto = new Product();
		
		String sql = "select product_id, product_name,product_price,product_content,"
				+ "product_graphic_card,product_cpu,product_mainboard,product_os,product_memory "
				+ "from product where product_id= ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productId);
		
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			productDto.setProdcutId(rs.getString("product_id"));
			productDto.setProductName(rs.getString("product_name"));
			productDto.setProductPrice(rs.getInt("product_price"));
			productDto.setProductContent(rs.getString("product_content"));
			productDto.setProductGraphicCard(rs.getString("product_graphic_card"));
			productDto.setCPU(rs.getString("product_cpu"));
			productDto.setMainboard(rs.getString("product_mainboard"));
			productDto.setOs(rs.getString("product_os"));
			productDto.setMemory(rs.getString("product_memory"));
		}
		
		return productDto;
	}

	public Product selectProductSubQuery(String productDetailId, Connection conn)throws Exception {
		Product productDto = new Product();
		
		String sql = "select product_id, product_name,product_price,product_content,"
				+ "product_graphic_card,product_cpu,product_mainboard,product_os,product_memory "
				+ "from product where product_id= "
				+ "(select product_product_id from product_detail where detail_id= ? )";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productDetailId);
		
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			productDto.setProdcutId(rs.getString("product_id"));
			productDto.setProductName(rs.getString("product_name"));
			productDto.setProductPrice(rs.getInt("product_price"));
			productDto.setProductContent(rs.getString("product_content"));
			productDto.setProductGraphicCard(rs.getString("product_graphic_card"));
			productDto.setCPU(rs.getString("product_cpu"));
			productDto.setMainboard(rs.getString("product_mainboard"));
			productDto.setOs(rs.getString("product_os"));
			productDto.setMemory(rs.getString("product_memory"));
		}
		
		return productDto;
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

