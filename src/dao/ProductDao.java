package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Product;
import dto.ProductImage;
import util.Pager;

public class ProductDao {
	
	
	public List<Product> selectProducts(Pager page, Connection conn,Product productCategory) throws Exception {
		List<Product> list = new ArrayList<>();

		String sql = "select rnum ,  product_id, product_name, product_price,PRODUCT_GRAPHIC_CARD,PRODUCT_CPU, PRODUCT_MAINBOARD,  PRODUCT_OS, PRODUCT_MEMORY from ("
				+ "select rownum as rnum, product_id, product_name, product_price,PRODUCT_GRAPHIC_CARD, "
				+ " PRODUCT_CPU, PRODUCT_MAINBOARD,  PRODUCT_OS, PRODUCT_MEMORY " 
				+ "from product where rownum <=? ";
		int index=1;
		//sql문 작성
		if(productCategory.getProductGraphicCard()!=null) {
			sql+="and PRODUCT_GRAPHIC_CARD=? ";
		}
		if(productCategory.getCPU()!=null) {
			sql+="and PRODUCT_CPU=? ";
		}
		if(productCategory.getMainboard()!=null) {
			sql+="and PRODUCT_MAINBOARD=? ";
		}
		if(productCategory.getMemory()!=null) {
			sql+="and PRODUCT_MEMORY=? ";
		}
		if(productCategory.getOs()!=null) {
			sql+="and PRODUCT_OS=? ";
		}
		if(productCategory.getProductName()!=null) {
			sql+="and PRODUCT_NAME like '%'||?||'%' ";
		}
		if(productCategory.getProductPrice()!=0) {
			sql+="and product_price>=? ";
			if(productCategory.getProductPrice()!=1500000) {
				sql+="and product_price<= ? ";
			}
		}
		
		sql+= ")where rnum >=? ";
		//값 넣기
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(index++, String.valueOf(page.getEndRowNo()));
		if(productCategory.getProductGraphicCard()!=null) {
			pstmt.setString(index++, productCategory.getProductGraphicCard());
		}
		if(productCategory.getCPU()!=null) {
			pstmt.setString(index++, productCategory.getCPU());
		}
		if(productCategory.getMainboard()!=null) {
			pstmt.setString(index++, productCategory.getMainboard());
		}
		if(productCategory.getMemory()!=null) {
			pstmt.setString(index++, productCategory.getMemory());
		}
		if(productCategory.getOs()!=null) {
			pstmt.setString(index++, productCategory.getOs());
		}
		if(productCategory.getProductName()!=null) {
			pstmt.setString(index++, productCategory.getProductName());
		}
		if(productCategory.getProductPrice()!=0) {
			pstmt.setInt(index++, productCategory.getProductPrice()-500000);
			if(productCategory.getProductPrice()!=1500000) {
				pstmt.setInt(index++, productCategory.getProductPrice());
			}
		}
		pstmt.setString(index++, String.valueOf(page.getStartRowNo()));

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Product productDto = new Product();
			productDto.setProductId(rs.getString("product_id"));
			productDto.setProductName(rs.getString("product_name"));
			productDto.setProductPrice(rs.getInt("product_price"));
			productDto.setProductGraphicCard(rs.getString("PRODUCT_GRAPHIC_CARD"));
			productDto.setCPU(rs.getString("PRODUCT_CPU"));
			productDto.setMainboard(rs.getString("PRODUCT_MAINBOARD"));
			productDto.setMemory(rs.getString("PRODUCT_MEMORY"));
			productDto.setOs(rs.getString("PRODUCT_OS"));
			
			list.add(productDto);
		}

		return list;
	}
	

	public int selectCountProduct(Connection conn,Product productCategory) throws Exception {
		int count = 0;
		String sql = "select count(product_id)as count from product where 1=1 ";
		int index=1;
		//sql문 작성
		if(productCategory.getProductGraphicCard()!=null) {
			sql+="and PRODUCT_GRAPHIC_CARD=? ";
		}
		if(productCategory.getCPU()!=null) {
			sql+="and PRODUCT_CPU=? ";
		}
		if(productCategory.getMainboard()!=null) {
			sql+="and PRODUCT_MAINBOARD=? ";
		}
		if(productCategory.getMemory()!=null) {
			sql+="and PRODUCT_MEMORY=? ";
		}
		if(productCategory.getOs()!=null) {
			sql+="and PRODUCT_OS=? ";
		}
		if(productCategory.getProductName()!=null) {
			sql+="and PRODUCT_NAME like '%'||?||'%' ";
		}
		if(productCategory.getProductPrice()!=0) {
			sql+="and product_price>=? ";
			if(productCategory.getProductPrice()!=1500000) {
				sql+="and product_price<= ? ";
			}
		}
		
		//값 넣기
		PreparedStatement pstmt = conn.prepareStatement(sql);
		if(productCategory.getProductGraphicCard()!=null) {
			pstmt.setString(index++, productCategory.getProductGraphicCard());
		}
		if(productCategory.getCPU()!=null) {
			pstmt.setString(index++, productCategory.getCPU());
		}
		if(productCategory.getMainboard()!=null) {
			pstmt.setString(index++, productCategory.getMainboard());
		}
		if(productCategory.getMemory()!=null) {
			pstmt.setString(index++, productCategory.getMemory());
		}
		if(productCategory.getOs()!=null) {
			pstmt.setString(index++, productCategory.getOs());
		}
		if(productCategory.getProductName()!=null) {
			pstmt.setString(index++, productCategory.getProductName());
		}
		if(productCategory.getProductPrice()!=0) {
			pstmt.setInt(index++, productCategory.getProductPrice()-500000);
			if(productCategory.getProductPrice()!=1500000) {
				pstmt.setInt(index++, productCategory.getProductPrice());
			}
		}
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			count = rs.getInt("count");
		}

		return count;
	}

	
	public Product selectProduct(String productId, Connection conn) throws Exception {
		Product productDto = new Product();

		String sql = "select product_id, product_name,product_price,product_content,"
				+ "product_graphic_card,product_cpu,product_mainboard,product_os,product_memory "
				+ "from product where product_id= ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productId);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			productDto.setProductId(rs.getString("product_id"));
			productDto.setProductName(rs.getString("product_name"));
			productDto.setProductPrice(rs.getInt("product_price"));
			productDto.setProductGraphicCard(rs.getString("product_graphic_card"));
			productDto.setCPU(rs.getString("product_cpu"));
			productDto.setMainboard(rs.getString("product_mainboard"));
			productDto.setOs(rs.getString("product_os"));
			productDto.setMemory(rs.getString("product_memory"));
		}

		return productDto;
	}
	
	

	public List<String> selectCategory(String category, Connection conn)throws Exception {
		List<String> list =new ArrayList<>();
		String sql = "select distinct " +category+ " from product";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			list.add(rs.getString(category));
		}
		return list;
	}

	public void inserProduct(Product product, Connection conn)throws Exception {
		String sql = "insert into product(product_id,product_name,product_price," +
				 "product_date,product_graphic_card," +
				 "product_cpu,product_mainboard,product_os,product_memory) " +
				 "values(?,?,?,sysdate,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// 입력됨.
		pstmt.setString(1, product.getProductId());
		pstmt.setString(2, product.getProductName());
		pstmt.setInt(3, product.getProductPrice());
		pstmt.setString(4, product.getProductGraphicCard());
		pstmt.setString(5, product.getCPU());
		pstmt.setString(6, product.getMainboard());
		pstmt.setString(7, product.getOs());
		pstmt.setString(8, product.getMemory());
		pstmt.executeUpdate();
		pstmt.close();
		
	}

	

}
