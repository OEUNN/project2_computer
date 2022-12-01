package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.OrderDetail;
import DTO.ProductDetail;
import util.ConnectionProvider;

public class ProductDetailDao {
	
	public List<ProductDetail> selectProductDetails(String productId) {
		PreparedStatement pstmt;
		Connection conn = ConnectionProvider.getConnection();
		
		String sql = "select d.detail_color ,d.detail_capacity,"
				+ "d.detail_qnt,d.detail_id,p.product_id from product p, product_detail d "
				+ "where p.product_id=d.product_product_id " + "and p.product_id= '" + productId + "' "
				+ "and d.detail_qnt!=0 " + "order by d.detail_color";

		List<ProductDetail> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductDetail pd = new ProductDetail();
				pd.setDetailId(rs.getString("detail_id"));
				pd.setDetailColor(rs.getString("detail_color"));
				pd.setDetailCapacity(rs.getString("detail_capacity"));
				pd.setDetailQnt(rs.getInt("detail_qnt"));
				pd.setProductId(rs.getString("product_id"));
				list.add(pd);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.exit(conn);
		}

		return list;
	}

	public ProductDetail selectProductDetailOneCol(String detailId) {
		PreparedStatement pstmt;
		Connection conn = ConnectionProvider.getConnection();
	
		String sql = "select detail_color ,detail_capacity,"
				+ "detail_qnt,detail_id, product_product_id from product_detail "
				+ "where detail_id= ? ";
			

		ProductDetail pd = new ProductDetail();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, detailId);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				pd.setDetailId(rs.getString("detail_id"));
				pd.setDetailColor(rs.getString("detail_color"));
				pd.setDetailCapacity(rs.getString("detail_capacity"));
				pd.setDetailQnt(rs.getInt("detail_qnt"));
				pd.setProductId(rs.getString("product_product_id"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.exit(conn);
		}

		return pd;
	}

	public boolean updateDetail(OrderDetail od) {
		PreparedStatement pstmt;
		Connection conn = ConnectionProvider.getConnection();
		String sql = "update product_detail set detail_qnt=detail_qnt-? where detail_id=? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, od.getProductQnt());
			pstmt.setString(2, od.getProductDetailId());
			return pstmt.execute() ;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.exit(conn);
		}
		return false;
	}
}
