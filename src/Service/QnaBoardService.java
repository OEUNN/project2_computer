package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import DAO.QnaBoardDao;
import DTO.QnaBoard;
import util.ConnectionProvider;
import util.Pager;

public class QnaBoardService {
	
	ServletContext application;
	public QnaBoardService(ServletContext application) {
		this.application=application; 
	}
	public int getTotalRow() {
		Connection conn = ConnectionProvider.getConnection();
		QnaBoardDao qnaBoardDao = (QnaBoardDao) application.getAttribute("qnaBoardDao");
		int totalRow=0;
		
		try {
			totalRow = qnaBoardDao.getTotalRow(conn);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalRow;
	}
	
	
	public String writeQnaBoard(QnaBoard qnaBoard) {
		Connection conn = ConnectionProvider.getConnection();
		QnaBoardDao qnaBoardDao = (QnaBoardDao) application.getAttribute("qnaBoardDao");
		String Output=null;
		try {
			Output = qnaBoardDao.Insert(qnaBoard,conn);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Output;
	}
	
	public ArrayList<QnaBoard> readQnaBoard(String readQnaBoard) {
		Connection conn = ConnectionProvider.getConnection();
		QnaBoardDao qnaBoardDao = (QnaBoardDao) application.getAttribute("qnaBoardDao");
		ArrayList<QnaBoard> list = new ArrayList<>();
		
		try {
			list = qnaBoardDao.ReadAll(readQnaBoard,conn);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public QnaBoard selectQnaBoard(QnaBoard qnaBoard) {
		Connection conn = ConnectionProvider.getConnection();
		QnaBoardDao qnaBoardDao = (QnaBoardDao) application.getAttribute("qnaBoardDao");
		
		QnaBoard qnaBoard2 = new QnaBoard();
		try {
			qnaBoard2 = qnaBoardDao.readQnaBoard(qnaBoard,conn);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qnaBoard2;
	}
	
	public ArrayList<QnaBoard> readQnaBoardPager(Pager pager) {
		Connection conn = ConnectionProvider.getConnection();
		QnaBoardDao qnaBoardDao = (QnaBoardDao) application.getAttribute("qnaBoardDao");
		ArrayList<QnaBoard> list = new ArrayList<>();
		
		try {
			list = qnaBoardDao.readQnaBoardPager(pager,conn);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<QnaBoard> readMyPost(QnaBoard qnaBoard, Pager pager) {
		Connection conn = ConnectionProvider.getConnection();
		QnaBoardDao qnaBoardDao = (QnaBoardDao) application.getAttribute("qnaBoardDao");
		ArrayList<QnaBoard> list = new ArrayList<>();
		
		try {
			list = qnaBoardDao.readMyPost(qnaBoard, pager,conn);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int getUserIDBoardCount(QnaBoard qnaBoard) {
		Connection conn = ConnectionProvider.getConnection();
		QnaBoardDao qnaBoardDao = (QnaBoardDao) application.getAttribute("qnaBoardDao");
		
		int getUserIDBoardCount = 0;
		try {
			getUserIDBoardCount = qnaBoardDao.getUserIDBoardCount(qnaBoard,conn);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getUserIDBoardCount;
	}
	
	public String deleteQnaBoard(QnaBoard qnaBoard) {
		Connection conn = ConnectionProvider.getConnection();
		QnaBoardDao qnaBoardDao = (QnaBoardDao) application.getAttribute("qnaBoardDao");
		String Output=null;
		try {
			Output = qnaBoardDao.deleteQnaBoard(qnaBoard,conn);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Output;
	}
	//주문내역 가져오는 메소드
	/*public String Or(String userId) {
		Connection conn = ConnectionProvider.getConnection();
		QnaBoardDao qnaBoardDao = (QnaBoardDao) application.getAttribute("qnaBoardDao");
		String result=null;
		try {
			result=qnaBoardDao.ordered(userId,conn);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}*/
	
}
