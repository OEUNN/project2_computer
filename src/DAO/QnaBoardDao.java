package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import DTO.QnaBoard;
import DTO.ReviewBoard;
import util.ConnectionProvider;
import util.Pager;

public class QnaBoardDao {
	String Output;
	int countRow;
	int totalRow;
	Pager pager = new Pager();

	public String Insert(QnaBoard freeBoard) {
		String sql = "insert into free_board (free_bno, free_btitle, free_bcontent, free_date, free_comment_num, users_User_Id) "
				+ " values ('17', ?, ?, sysdate, free_conum.nextval, ? ) ";
		Connection conn = ConnectionProvider.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 입력됨.
			pstmt.setString(1, freeBoard.getQnaBtitle());
			pstmt.setString(2, freeBoard.getQnaBcontent());
			pstmt.setString(3, freeBoard.getUserId());
			pstmt.executeUpdate();
			pstmt.close();
			Output = "success";

		} catch (Exception e) {
			Output = "fail";
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return Output;
	}

	public QnaBoard ReadFb(QnaBoard freeBoard) {
		String sql = "select Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno " + "from free_board "
				+ "where free_bno = ? ";
		QnaBoard free_Board2 = new QnaBoard();
		Connection conn = ConnectionProvider.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, freeBoard.getQnaBno());
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				free_Board2.setQnaBtitle(rs.getString(1));
				free_Board2.setQnaBcontent(rs.getString(2));
				free_Board2.setQnaDate(rs.getString(3));
				free_Board2.setUserId(rs.getString(4));
				free_Board2.setQnaBno(rs.getString(5));
			}
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return free_Board2;
	}

	public ArrayList<QnaBoard> ReadAll(String readFb) {

		ArrayList<QnaBoard> list = new ArrayList<>();
		String sql = "select rnum, Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno " + " from ( "
				+ " select rownum as rnum, Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno "
				+ " from (select rownum, Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno "
				+ " from free_board " + " order by free_date desc " + " ) where rownum <= 5 " + " )"
				+ " where rnum >= 1 ";
		Connection conn = ConnectionProvider.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				QnaBoard free_Board = new QnaBoard();
				free_Board.setQnaBtitle(rs.getString(2));
				free_Board.setQnaBcontent(rs.getString(3));
				free_Board.setQnaDate(rs.getString(4));
				free_Board.setUserId(rs.getString(5));
				free_Board.setQnaBno(rs.getString(6));
				list.add(free_Board);
			}
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int getTotalRow() {
		String sql = "select count (*) as count from free_board";
		Connection conn = ConnectionProvider.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				countRow = rs.getInt("count");
			}
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return countRow;
	}

	public ArrayList<QnaBoard> ReadFbpager(Pager pager) {

		ArrayList<QnaBoard> list = new ArrayList<>();
		String sql = "select rnum, Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno " + " from ( "
				+ " select rownum as rnum, Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno "
				+ " from (select Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno " + " from free_board "
				+ " order by free_date desc " + " ) where rownum <= ? " + " )" + " where rnum >= ? ";
		Connection conn = ConnectionProvider.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, pager.getEndRowNo());
			pstmt.setInt(2, pager.getStartRowNo());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				QnaBoard free_Board = new QnaBoard();
				free_Board.setQnaBtitle(rs.getString(2));
				free_Board.setQnaBcontent(rs.getString(3));
				free_Board.setQnaDate(rs.getString(4));
				free_Board.setUserId(rs.getString(5));
				free_Board.setQnaBno(rs.getString(6));

				list.add(free_Board);
			}

			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public ArrayList<QnaBoard> readMyPost(QnaBoard freeBoard, Pager pager) {
		ArrayList<QnaBoard> list = new ArrayList<>();
		String sql = "select rnum, Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno " + " from ( "
				+ " select rownum as rnum, Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno "
				+ " from (select Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno " + " from free_board "
				+ " order by free_date desc " + " ) where rownum <= ? and users_user_id = ? " + " )"
				+ " where rnum >= ? ";

		Connection conn = ConnectionProvider.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, pager.getEndRowNo());
			pstmt.setString(2, freeBoard.getUserId());
			pstmt.setInt(3, pager.getStartRowNo());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				QnaBoard freeBoard1 = new QnaBoard();
				freeBoard1.setQnaBtitle(rs.getString(2));
				freeBoard1.setQnaBcontent(rs.getString(3));
				freeBoard1.setQnaDate(rs.getString(4));
				freeBoard1.setUserId(rs.getString(5));
				freeBoard1.setQnaBno(rs.getString(6));

				list.add(freeBoard1);
			}

			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int getUserIDBoardCount(QnaBoard freeBoard) {
		String sql = "select count (*) as count from free_board where users_user_id = ? ";
		Connection conn = ConnectionProvider.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, freeBoard.getUserId());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				countRow = rs.getInt("count");
			}
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return countRow;
	}

	public String DeleteFb(QnaBoard freeBoard) {
		String answer = "";
		String sql = "delete from free_board where users_user_id = ? and free_bno = ? ";
		Connection conn = ConnectionProvider.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, freeBoard.getUserId());
			pstmt.setString(2, freeBoard.getQnaBno());
			pstmt.executeUpdate();

			answer = "success";

			pstmt.close();
		} catch (Exception e) {
			e.getStackTrace();
			answer = "fail";
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return answer;
	}

	public String ordered(String userId) {
		String sql = "select ORDER_DETAIL_ID, PRODUCT_NAME from ORDER_DETAIL, PRODUCT "
				+ "where ORDERS_ORDER_ID in (select ORDER_ID from ORDERS where USER_USER_ID = ? ) "
				+ "and PRODUCT_ID=(select PRODUCT_PRODUCT_ID from PRODUCT_DETAIL where DETAIL_ID=PRODUCT_DETAIL_DETAIL_ID)"; // 얘도
																																// 필드로
		Connection conn = ConnectionProvider.getConnection();
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
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return returnjson.toString();
	}

}
