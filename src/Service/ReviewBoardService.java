package Service;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import DAO.ReviewBoardDao;
import DTO.ReviewBoard;

public class ReviewBoardService {
	private ServletContext application;
	private DataSource ds;
	private ReviewBoardDao reviewBoardDao;
	
	public ReviewBoardService(ServletContext application) {
		this.application=application; 
		reviewBoardDao = (ReviewBoardDao)application.getAttribute("reviewBoardDao");
		ds=(DataSource)application.getAttribute("dataSource");
	}
	
	public String writeReviewBoard(ReviewBoard reviewBoard) {
		Connection conn = null;
		String result=null;
		try {
			conn=ds.getConnection();
			result=reviewBoardDao.Insert(reviewBoard,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		return result;
	}
	
	public int getTotalRowReviewBoard() {
		Connection conn = null;
		int totalrow=0;
		try {
			conn=ds.getConnection();
			totalrow=reviewBoardDao.getTotalRowReviewBoard(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		return totalrow;
	}
	
	public ArrayList<ReviewBoard> readReviewBoard(int pageNo) {
		Connection conn = null;
		ArrayList<ReviewBoard> list = new ArrayList<>();
		try {
			conn=ds.getConnection();
			list = reviewBoardDao.readReviewBoard(pageNo,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		return list;
	}
	
	public ReviewBoard detailReviewBoard(String selectBno) {
		Connection conn = null;
		ReviewBoard reviewBoard=null;
		try {
			conn=ds.getConnection();
			reviewBoard=reviewBoardDao.detailReviewBoard(selectBno,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		return reviewBoard;
	}
	
	public String deleteReviewBoard(String bno) {
		Connection conn = null;
		String result=null;
		try {
			conn=ds.getConnection();
			result=reviewBoardDao.deleteReviewBoard(bno,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		return result;
	}
	
	public String updateRb(ReviewBoard reviewBoard) {
		Connection conn = null;
		String result=null;
		try {
			conn=ds.getConnection();
			result=reviewBoardDao.updateReviewBoard(reviewBoard,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		return result;
	}
	
}
