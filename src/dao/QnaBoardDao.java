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



	public int getTotalRow(Connection conn, String loginId) throws SQLException {
		String sql = "select count (*) as count from qna_board where user_id =? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginId);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			countRow = rs.getInt("count");
		}
		pstmt.close();
		rs.close();

		return countRow;
	}

	public ArrayList<QnaBoard> readQnaBoardPager(Pager pager, Connection conn, String loginId) throws SQLException {
		ArrayList<QnaBoard> list = new ArrayList<>();
		String sql = "select rnum, QNA_BTITLE, QNA_BCONTENT, QNA_DATE, USER_ID,  QNA_BNO,IS_REPLY " 
				+ " from ( "
				+ " select rownum as rnum, QNA_BTITLE, QNA_BCONTENT, QNA_DATE, USER_ID,  QNA_BNO, IS_REPLY "
				+ " from (select QNA_BTITLE, QNA_BCONTENT, QNA_DATE, USER_ID,  QNA_BNO, IS_REPLY " 
				+ " from qna_board where user_id=? "
				+ " order by QNA_DATE desc " + " ) where rownum <= ? " + " )" + " where rnum >= ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,loginId);
		pstmt.setInt(2, pager.getEndRowNo());
		pstmt.setInt(3, pager.getStartRowNo());
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

	

	public String deleteQnaBoard(QnaBoard qnaBoard, Connection conn) throws SQLException {
		String answer = "";
		String sql = "delete from qna_board where qna_bno = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, qnaBoard.getQnaBno());
		pstmt.executeUpdate();
		answer = "success";
		pstmt.close();

		return answer;
	}
	

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
