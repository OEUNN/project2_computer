package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.json.JSONArray;
import org.json.JSONObject;

import DTO.QnaBoard;
import DTO.ReviewBoard;
import util.ConnectionProvider;
import util.Pager;

public class ReviewBoardDao {
	String Output;
	int countRow;
	int totalRow;
	Pager pager = new Pager();
	
	public String ordered(String userId,Connection conn) {
		String sql = "select ORDER_DETAIL_ID, PRODUCT_NAME from ORDER_DETAIL, PRODUCT "
				+ "where ORDERS_ORDER_ID in (select ORDER_ID from ORDERS where USER_USER_ID = ? ) "
				+ "and PRODUCT_ID=(select PRODUCT_PRODUCT_ID from PRODUCT_DETAIL where DETAIL_ID=PRODUCT_DETAIL_DETAIL_ID)"; // 얘도
																																// 필드로
		
		JSONObject returnjson = new JSONObject().put("sf", "fail");
		JSONArray ja = new JSONArray();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					returnjson.put("sf", "success");
					JSONObject jo = new JSONObject();
					jo.put("ORDER_DETAIL_ID", rs.getString("ORDER_DETAIL_ID"));
					jo.put("PRODUCT_NAME", rs.getString("PRODUCT_NAME"));
					ja.put(jo);
				} while (rs.next());
				returnjson.put("json", ja);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return returnjson.toString();
	}

	public String Insert(ReviewBoard reviewBoard,Connection conn) {
		String sql = "insert into REVIEW_BOARD (review_bno, Review_Btitle,Review_Bcontent, REVIEW_DATE, Review_Rate, USER_USER_ID, ORDER_DETAIL_ORDER_DETAIL_ID, PRODUCT_NAME )  values('28', ? , ? , SYSDATE, ? , ? , ?, ?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reviewBoard.getReviewBtitle());
			pstmt.setString(2, reviewBoard.getReviewBcontent());
			pstmt.setInt(3, reviewBoard.getReviewRate());
			pstmt.setString(4, reviewBoard.getUserId());
			pstmt.setString(5, reviewBoard.getOrderDetailId());
			pstmt.setString(6, reviewBoard.getProductName());
			pstmt.executeUpdate();
			pstmt.close();
			Output = "success";

		} catch (Exception e) {
			Output = "fail";
			e.printStackTrace();
		}
		return Output;
	}

	public int getTotalRowReviewBoard(Connection conn) {
		

		try {
			String sql = "select count(*) from REVIEW_BOARD ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				totalRow = rs.getInt(1);
			} else
				totalRow = 0;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		return totalRow;
	}

	public ArrayList<ReviewBoard> readReviewBoard(int pageNo,Connection conn) {
		
		ArrayList<ReviewBoard> list = new ArrayList<>();
		try {
			getTotalRowReviewBoard(conn);
			String sql = "select REVIEW_BNO, REVIEW_BTITLE, REVIEW_BCONTENT, REVIEW_DATE, REVIEW_RATE, USER_USER_ID, PRODUCT_NAME from ("
					+ "	select rownum as rnum, REVIEW_BNO,  REVIEW_BTITLE, REVIEW_BCONTENT, REVIEW_DATE, REVIEW_RATE, USER_USER_ID, PRODUCT_NAME from REVIEW_BOARD where rownum <= ?"
					+ "	order by REVIEW_DATE) where rnum >= ? ";
			Pager page = new Pager(5, 5, totalRow, pageNo);
			// page.setCurrPage(pageNo);

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page.getEndRowNo());
			pstmt.setInt(2, page.getStartRowNo());
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				ReviewBoard reviewBoard = new ReviewBoard();
				reviewBoard.setReviewBno(rs.getString(1));
				reviewBoard.setReviewBtitle(rs.getString(2));
				reviewBoard.setReviewBcontent(rs.getString(3));
				reviewBoard.setReviewDate(rs.getString(4));
				reviewBoard.setReviewRate(rs.getInt(5));
				reviewBoard.setUserId(rs.getString(6));
				reviewBoard.setProductName(rs.getString(7));

				list.add(reviewBoard);
			}

			pstmt.close();
			rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		return list;
	}

	public String detailReviewBoard(String selectBno,Connection conn) {
		JSONObject json = new JSONObject();
		String sql = "select REVIEW_BTITLE, REVIEW_BCONTENT, REVIEW_DATE, REVIEW_RATE, USER_USER_ID, PRODUCT_NAME from REVIEW_BOARD where REVIEW_BNO = ? ";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, selectBno);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				json.put("sf", "success");
				json.put("review_Btitle", rs.getString(1));
				json.put("review_Bcontent", rs.getString(2));
				json.put("review_Date", rs.getString(3));
				json.put("review_Rate", rs.getInt(4));
				json.put("user_Id", rs.getString(5));
				json.put("product_Name", rs.getString(6));
			} else
				json.put("sf", "fail");

			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return json.toString();
	}

	public String deleteReviewBoard(String bno,Connection conn) {
		String sql = "delete from REVIEW_BOARD where REVIEW_BNO = ? ";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			pstmt.executeUpdate();
			pstmt.close();
			Output = "success";

		} catch (Exception e) {
			Output = "fail";
			e.printStackTrace();
		} 
		return Output;
	}

	public String updateReviewBoard(ReviewBoard reviewBoard,Connection conn) {
		String sql = "update REVIEW_BOARD set REVIEW_BTITLE = ?, REVIEW_BCONTENT = ?, REVIEW_DATE = sysdate, REVIEW_RATE = ? where REVIEW_BNO = ? ";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reviewBoard.getReviewBtitle());
			pstmt.setString(2, reviewBoard.getReviewBcontent());
			pstmt.setInt(3, reviewBoard.getReviewRate());
			pstmt.setString(4, reviewBoard.getReviewBno());
			pstmt.executeUpdate();
			pstmt.close();
			Output = "success";

		} catch (Exception e) {
			Output = "fail";
			e.printStackTrace();
		} 
		return Output;
	}
}
