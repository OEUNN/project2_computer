package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.QnaBoard;
import util.Pager;

public class QnaBoardDao {
	String Output;
	int countRow;

	public String Insert(QnaBoard qnaBoard, Connection conn) throws SQLException {
		String sql = "insert into qna_board (QNA_BNO, QNA_BTITLE, QNA_BCONTENT, QNA_DATE, USER_ID, IS_REPLY) "
				+ " values ('Qna'||qna_bno.nextval, ?, ?, sysdate,  ? ,0) ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// 입력됨.
		pstmt.setString(1, qnaBoard.getQnaBtitle());
		pstmt.setString(2, qnaBoard.getQnaBcontent());
		pstmt.setString(3, qnaBoard.getUserId());
		pstmt.executeUpdate();
		pstmt.close();
		Output = "success";

		return Output;
	}

	public QnaBoard readQnaBoard(QnaBoard qnaBoard, Connection conn) throws SQLException {
		String sql = "select Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno " + "from free_board "
				+ "where free_bno = ? ";
		QnaBoard qnaBoard2 = new QnaBoard();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, qnaBoard.getQnaBno());
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			qnaBoard2.setQnaBtitle(rs.getString(1));
			qnaBoard2.setQnaBcontent(rs.getString(2));
			qnaBoard2.setQnaDate(rs.getString(3));
			qnaBoard2.setUserId(rs.getString(4));
			qnaBoard2.setQnaBno(rs.getString(5));
		}
		pstmt.close();
		rs.close();

		return qnaBoard2;
	}

	public ArrayList<QnaBoard> ReadAll(String readFb, Connection conn) throws SQLException {
		ArrayList<QnaBoard> list = new ArrayList<>();
		String sql = "select rnum, Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno " + " from ( "
				+ " select rownum as rnum, Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno "
				+ " from (select rownum, Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno "
				+ " from free_board " + " order by free_date desc " + " ) where rownum <= 5 " + " )"
				+ " where rnum >= 1 ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			QnaBoard qnaBoard = new QnaBoard();
			qnaBoard.setQnaBtitle(rs.getString(2));
			qnaBoard.setQnaBcontent(rs.getString(3));
			qnaBoard.setQnaDate(rs.getString(4));
			qnaBoard.setUserId(rs.getString(5));
			qnaBoard.setQnaBno(rs.getString(6));
			list.add(qnaBoard);
		}
		pstmt.close();
		rs.close();

		return list;
	}

	public int getTotalRow(Connection conn) throws SQLException {
		String sql = "select count (*) as count from qna_board";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			countRow = rs.getInt("count");
		}
		pstmt.close();
		rs.close();

		return countRow;
	}

	public ArrayList<QnaBoard> readQnaBoardPager(Pager pager, Connection conn) throws SQLException {
		ArrayList<QnaBoard> list = new ArrayList<>();
		String sql = "select rnum, QNA_BTITLE, QNA_BCONTENT, QNA_DATE, USER_ID,  QNA_BNO,IS_REPLY " 
				+ " from ( "
				+ " select rownum as rnum, QNA_BTITLE, QNA_BCONTENT, QNA_DATE, USER_ID,  QNA_BNO, IS_REPLY "
				+ " from (select QNA_BTITLE, QNA_BCONTENT, QNA_DATE, USER_ID,  QNA_BNO, IS_REPLY " 
				+ " from qna_board "
				+ " order by QNA_DATE desc " + " ) where rownum <= ? " + " )" + " where rnum >= ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pager.getEndRowNo());
		pstmt.setInt(2, pager.getStartRowNo());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			QnaBoard qna_Board = new QnaBoard();
			qna_Board.setQnaBtitle(rs.getString(2));
			qna_Board.setQnaBcontent(rs.getString(3));
			qna_Board.setQnaDate(rs.getString(4));
			qna_Board.setUserId(rs.getString(5));
			qna_Board.setQnaBno(rs.getString(6));
			qna_Board.setReply(rs.getBoolean(7));
			list.add(qna_Board);
		}
		pstmt.close();
		rs.close();

		return list;
	}

	public ArrayList<QnaBoard> readMyPost(QnaBoard qnaBoard, Pager pager, Connection conn) throws SQLException {
		ArrayList<QnaBoard> list = new ArrayList<>();
		String sql = "select rnum, Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno " + " from ( "
				+ " select rownum as rnum, Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno "
				+ " from (select Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno " + " from free_board "
				+ " order by free_date desc " + " ) where rownum <= ? and users_user_id = ? " + " )"
				+ " where rnum >= ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pager.getEndRowNo());
		pstmt.setString(2, qnaBoard.getUserId());
		pstmt.setInt(3, pager.getStartRowNo());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			QnaBoard qnaBoard1 = new QnaBoard();
			qnaBoard1.setQnaBtitle(rs.getString(2));
			qnaBoard1.setQnaBcontent(rs.getString(3));
			qnaBoard1.setQnaDate(rs.getString(4));
			qnaBoard1.setUserId(rs.getString(5));
			qnaBoard1.setQnaBno(rs.getString(6));
			list.add(qnaBoard1);
		}
		pstmt.close();
		rs.close();

		return list;
	}

	public int getUserIDBoardCount(QnaBoard qnaBoard, Connection conn) throws SQLException {
		String sql = "select count (*) as count from free_board where users_user_id = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, qnaBoard.getUserId());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			countRow = rs.getInt("count");
		}
		pstmt.close();
		rs.close();
		return countRow;
	}

	public String deleteQnaBoard(QnaBoard qnaBoard, Connection conn) throws SQLException {
		String answer = "";
		String sql = "delete from free_board where users_user_id = ? and free_bno = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, qnaBoard.getUserId());
		pstmt.setString(2, qnaBoard.getQnaBno());
		pstmt.executeUpdate();
		answer = "success";
		pstmt.close();

		return answer;
	}
	// 주문내역 가져오는 메소드
	/*
	 * public String ordered(String userId,Connection conn)throws SQLException {
	 * String sql =
	 * "select ORDER_DETAIL_ID, PRODUCT_NAME from ORDER_DETAIL, PRODUCT " +
	 * "where ORDERS_ORDER_ID in (select ORDER_ID from ORDERS where USER_USER_ID = ? ) "
	 * +
	 * "and PRODUCT_ID=(select PRODUCT_PRODUCT_ID from PRODUCT_DETAIL where DETAIL_ID=PRODUCT_DETAIL_DETAIL_ID)"
	 * ; // 얘도 // 필드로
	 * 
	 * JSONObject returnjson = new JSONObject().put("sf", "fail"); JSONArray ja =
	 * new JSONArray();
	 * 
	 * PreparedStatement pstmt = conn.prepareStatement(sql); pstmt.setString(1,
	 * userId); ResultSet rs = pstmt.executeQuery();
	 * 
	 * if (rs.next()) { do { returnjson.put("sf", "success"); JSONObject jo = new
	 * JSONObject(); jo.put("ORDER_DETAIL_ID", rs.getString("ORDER_DETAIL_ID"));
	 * jo.put("PRODUCT_NAME", rs.getString("PRODUCT_NAME")); ja.put(jo); } while
	 * (rs.next()); //returnjson.put("json", ja); } pstmt.close(); return
	 * returnjson.toString(); }
	 */

	public String updateQnaBoard(QnaBoard qnaBoard, Connection conn)throws Exception {
		String answer = "";
		String sql = "update qna_board set qna_btitle = ? , qna_bcontent = ? where qna_bno = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, qnaBoard.getQnaBtitle());
		pstmt.setString(2, qnaBoard.getQnaBcontent());
		pstmt.setString(3, qnaBoard.getQnaBno());
		pstmt.executeUpdate();
		answer = "success";
		pstmt.close();

		return answer;
	}
}
