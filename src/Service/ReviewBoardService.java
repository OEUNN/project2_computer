package Service;

import java.util.ArrayList;

import DAO.ReviewBoardDao;
import DTO.QnaBoard;
import DTO.ReviewBoard;

public class ReviewBoardService {
	QnaBoard freeBoard = new QnaBoard();
	String Output;
	int totalRow;
	
	public String writeRb(ReviewBoard rb) {
		ReviewBoardDao Rd = new ReviewBoardDao();
		return Rd.Insert(rb);
	}
	
	public int getTRRb() {
		ReviewBoardDao Rd = new ReviewBoardDao();
		return Rd.getTRRb();
	}
	
	public ArrayList<ReviewBoard> readRb(int pageNo) {
		ReviewBoardDao Rd = new ReviewBoardDao();
		ArrayList<ReviewBoard> list = new ArrayList<>();
		list = Rd.readRb(pageNo);
		return list;
	}
	
	public String detailRb(String selectBno) {
		ReviewBoardDao Rd = new ReviewBoardDao();
		return Rd.detailRb(selectBno);
	}
	
	public String deleteRb(String bno) {
		ReviewBoardDao Rd = new ReviewBoardDao();
		return Rd.deleteRb(bno);
	}
	
	public String updateRb(ReviewBoard rb) {
		ReviewBoardDao Rd = new ReviewBoardDao();
		return Rd.updateRb(rb);
	}
	
	
	
	
	
	
	
}
