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
	String Output;
	int totalRow;
	ServletContext application;
	public QnaBoardService(ServletContext application) {
		this.application=application; 
	}
	public int getTotalRow() {
		Connection conn = ConnectionProvider.getConnection();
		QnaBoardDao qnaBoardDao = (QnaBoardDao) application.getAttribute("qnaBoardDao");
		
		totalRow = qnaBoardDao.getTotalRow(conn);
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalRow;
	}
	
	
	public String writeQnaBoard(QnaBoard qnaBoard) {
		Connection conn = ConnectionProvider.getConnection();
		QnaBoardDao qnaBoardDao = (QnaBoardDao) application.getAttribute("qnaBoardDao");
		
		Output = qnaBoardDao.Insert(qnaBoard,conn);
		try {
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
		
		list = qnaBoardDao.ReadAll(readQnaBoard,conn);
		try {
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
		qnaBoard2 = qnaBoardDao.readQnaBoard(qnaBoard,conn);
		try {
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
		
		list = qnaBoardDao.readQnaBoardPager(pager,conn);
		try {
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
		
		list = qnaBoardDao.readMyPost(qnaBoard, pager,conn);
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int getUserIDBoardCount(QnaBoard qnaBoard) {
		Connection conn = ConnectionProvider.getConnection();
		QnaBoardDao qnaBoardDao = (QnaBoardDao) application.getAttribute("qnaBoardDao");
		
		int getUserIDBoardCount = qnaBoardDao.getUserIDBoardCount(qnaBoard,conn);
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getUserIDBoardCount;
	}
	
	public String deleteQnaBoard(QnaBoard qnaBoard) {
		Connection conn = ConnectionProvider.getConnection();
		QnaBoardDao qnaBoardDao = (QnaBoardDao) application.getAttribute("qnaBoardDao");
		
		Output = qnaBoardDao.deleteQnaBoard(qnaBoard,conn);
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Output;
	}
	public String Or(String userId) {
		Connection conn = ConnectionProvider.getConnection();
		QnaBoardDao qnaBoardDao = (QnaBoardDao) application.getAttribute("qnaBoardDao");
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qnaBoardDao.ordered(userId,conn);
	}
	
}
