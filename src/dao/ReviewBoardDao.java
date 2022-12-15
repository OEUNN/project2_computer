package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.OrderDetail;
import dto.ReviewBoard;
import util.Pager;
public class ReviewBoardDao {
	String Output;
	int countRow;
	int totalRow;
	Pager pager = new Pager();


	public String Insert(ReviewBoard reviewBoard, Connection conn) throws SQLException {
		String sql = "insert into REVIEW_BOARD (review_bno, Review_Btitle,Review_Bcontent, REVIEW_DATE, Review_Rate, USER_USER_ID, ORDER_DETAIL_ORDER_DETAIL_ID, PRODUCT_NAME )  values('28', ? , ? , SYSDATE, ? , ? , ?, ?)";
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

		return Output;
	}

	public int getTotalRowReviewBoard(Connection conn) throws SQLException {
		String sql = "select count(*) from REVIEW_BOARD ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			totalRow = rs.getInt(1);
		} else
			totalRow = 0;
		pstmt.close();
		return totalRow;
	}

	public ArrayList<ReviewBoard> readReviewBoard(Pager page, Connection conn) throws SQLException {
		ArrayList<ReviewBoard> list = new ArrayList<>();
		getTotalRowReviewBoard(conn);
		String sql = "select REVIEW_BNO, REVIEW_BTITLE, REVIEW_BCONTENT, REVIEW_DATE, REVIEW_RATE, USER_ID, PRODUCT_ID from ("
				+ "	select rownum as rnum, REVIEW_BNO,  REVIEW_BTITLE, REVIEW_BCONTENT, REVIEW_DATE, REVIEW_RATE, USER_ID, PRODUCT_ID from REVIEW_BOARD where rownum <= ?"
				+ "	order by REVIEW_DATE) where rnum >= ? ";
		
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

		return list;
	}

	public ReviewBoard detailReviewBoard(String selectBno, Connection conn) throws SQLException {
		// JSONObject json = new JSONObject();
		String sql = "select REVIEW_BTITLE, REVIEW_BCONTENT, REVIEW_DATE, REVIEW_RATE, USER_USER_ID, PRODUCT_NAME from REVIEW_BOARD where REVIEW_BNO = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, selectBno);
		ResultSet rs = pstmt.executeQuery();
		ReviewBoard reviewBoard = new ReviewBoard();
		if (rs.next()) {
			reviewBoard.setReviewBtitle(rs.getString(1));
			reviewBoard.setReviewBcontent(rs.getString(2));
			reviewBoard.setReviewDate(rs.getString(3));
			reviewBoard.setReviewRate(rs.getInt(4));
			reviewBoard.setUserId(rs.getString(5));
			reviewBoard.setProductName(rs.getString(6));
			/*
			 * json.put("sf", "success"); json.put("review_Btitle", rs.getString(1));
			 * json.put("review_Bcontent", rs.getString(2)); json.put("review_Date",
			 * rs.getString(3)); json.put("review_Rate", rs.getInt(4)); json.put("user_Id",
			 * rs.getString(5)); json.put("product_Name", rs.getString(6));
			 */
		} /*
			 * else json.put("sf", "fail");
			 */
		pstmt.close();
		rs.close();

		return reviewBoard;
	}

	public String deleteReviewBoard(String bno, Connection conn) throws SQLException {
		String sql = "delete from REVIEW_BOARD where REVIEW_BNO = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bno);
		pstmt.executeUpdate();
		pstmt.close();
		Output = "success";

		return Output;
	}

	public String updateReviewBoard(ReviewBoard reviewBoard, Connection conn) throws SQLException {
		String sql = "update REVIEW_BOARD set REVIEW_BTITLE = ?, REVIEW_BCONTENT = ?, REVIEW_DATE = sysdate, REVIEW_RATE = ? where REVIEW_BNO = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, reviewBoard.getReviewBtitle());
		pstmt.setString(2, reviewBoard.getReviewBcontent());
		pstmt.setInt(3, reviewBoard.getReviewRate());
		pstmt.setString(4, reviewBoard.getReviewBno());
		pstmt.executeUpdate();
		pstmt.close();
		Output = "success";

		return Output;
	}
}
