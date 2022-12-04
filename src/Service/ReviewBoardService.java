package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import DAO.ReviewBoardDao;
import DTO.QnaBoard;
import DTO.ReviewBoard;
import util.ConnectionProvider;

public class ReviewBoardService {
	ServletContext application;
	public ReviewBoardService(ServletContext application) {
		this.application=application; 
	}
	public String writeReviewBoard(ReviewBoard reviewBoard) {
		Connection conn = ConnectionProvider.getConnection();
		ReviewBoardDao reviewBoardDao = (ReviewBoardDao)application.getAttribute("reviewBoardDao");
		String result=null;
		try {
			result=reviewBoardDao.Insert(reviewBoard,conn);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int getTotalRowReviewBoard() {
		Connection conn = ConnectionProvider.getConnection();
		ReviewBoardDao reviewBoardDao = new ReviewBoardDao();
		int totalrow=0;
		try {
			totalrow=reviewBoardDao.getTotalRowReviewBoard(conn);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalrow;
	}
	
	public ArrayList<ReviewBoard> readReviewBoard(int pageNo) {
		Connection conn = ConnectionProvider.getConnection();
		ReviewBoardDao reviewBoardDao = new ReviewBoardDao();
		ArrayList<ReviewBoard> list = new ArrayList<>();
		try {
			list = reviewBoardDao.readReviewBoard(pageNo,conn);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ReviewBoard detailReviewBoard(String selectBno) {
		Connection conn = ConnectionProvider.getConnection();
		ReviewBoardDao reviewBoardDao = new ReviewBoardDao();
		ReviewBoard reviewBoard=null;
		try {
			reviewBoard=reviewBoardDao.detailReviewBoard(selectBno,conn);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reviewBoard;
	}
	
	public String deleteReviewBoard(String bno) {
		Connection conn = ConnectionProvider.getConnection();
		ReviewBoardDao reviewBoardDao = new ReviewBoardDao();
		String result=null;
		try {
			result=reviewBoardDao.deleteReviewBoard(bno,conn);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String updateRb(ReviewBoard reviewBoard) {
		Connection conn = ConnectionProvider.getConnection();
		ReviewBoardDao reviewBoardDao = new ReviewBoardDao();
		String result=null;
		try {
			result=reviewBoardDao.updateReviewBoard(reviewBoard,conn);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
