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
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reviewBoardDao.Insert(reviewBoard,conn);
	}
	
	public int getTotalRowReviewBoard() {
		Connection conn = ConnectionProvider.getConnection();
		ReviewBoardDao reviewBoardDao = new ReviewBoardDao();
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reviewBoardDao.getTotalRowReviewBoard(conn);
	}
	
	public ArrayList<ReviewBoard> readReviewBoard(int pageNo) {
		Connection conn = ConnectionProvider.getConnection();
		ReviewBoardDao reviewBoardDao = new ReviewBoardDao();
		ArrayList<ReviewBoard> list = new ArrayList<>();
		list = reviewBoardDao.readReviewBoard(pageNo,conn);
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public String detailReviewBoard(String selectBno) {
		Connection conn = ConnectionProvider.getConnection();
		ReviewBoardDao reviewBoardDao = new ReviewBoardDao();
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reviewBoardDao.detailReviewBoard(selectBno,conn);
	}
	
	public String deleteReviewBoard(String bno) {
		Connection conn = ConnectionProvider.getConnection();
		ReviewBoardDao reviewBoardDao = new ReviewBoardDao();
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reviewBoardDao.deleteReviewBoard(bno,conn);
	}
	
	public String updateRb(ReviewBoard reviewBoard) {
		Connection conn = ConnectionProvider.getConnection();
		ReviewBoardDao reviewBoardDao = new ReviewBoardDao();
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reviewBoardDao.updateReviewBoard(reviewBoard,conn);
	}
	
}
