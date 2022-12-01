package Service;

import java.util.ArrayList;

import DAO.BoardDao;
import DTO.FreeBoard;
import DTO.ReviewBoard;
import util.Pager;

public class ServiceBoardFunction {
	BoardDao Db = new BoardDao();
	FreeBoard freeBoard = new FreeBoard();
	String Output;
	int totalRow;
	
	public int getTotalRow() {
		Db = new BoardDao();
		totalRow = Db.getTotalRow();
		return totalRow;
	}
	
	
	public String writeFb(FreeBoard freeBoard) {
		Db = new BoardDao();
		Output = Db.Insert(freeBoard);
		return Output;
	}
	
	public ArrayList<FreeBoard> readFb(String readFb) {
		ArrayList<FreeBoard> list = new ArrayList<>();
		Db = new BoardDao();
		list = Db.ReadAll(readFb);
		return list;
	}
	
	public FreeBoard selectFb(FreeBoard freeBoard) {
		Db= new BoardDao();
		FreeBoard freeBoard2 = new FreeBoard();
		freeBoard2 = Db.ReadFb(freeBoard);
		return freeBoard2;
	}
	
	public ArrayList<FreeBoard> readFbPager(Pager pager) {
		ArrayList<FreeBoard> list = new ArrayList<>();
		Db = new BoardDao();
		list = Db.ReadFbpager(pager);
		return list;
	}
	
	public ArrayList<FreeBoard> readMyPost(FreeBoard freeBoard, Pager pager) {
		ArrayList<FreeBoard> list = new ArrayList<>();
		Db = new BoardDao();
		list = Db.readMyPost(freeBoard, pager);
		return list;
	}
	public int getUserIDBoardCount(FreeBoard freeBoard) {
		Db = new BoardDao();
		int getUserIDBoardCount = Db.getUserIDBoardCount(freeBoard);
		return getUserIDBoardCount;
	}
	
	public String DeleteFb(FreeBoard freeBoard) {
		Db = new BoardDao();
		Output = Db.DeleteFb(freeBoard);
		return Output;
	}
	public String Or(String userId) {
		return Db.ordered(userId);
	}
	
	public String writeRb(ReviewBoard rb) {
		return Db.Insert(rb);
	}
	
	public int getTRRb() {
		return Db.getTRRb();
	}
	
	public ArrayList<ReviewBoard> readRb(int pageNo) {
		ArrayList<ReviewBoard> list = new ArrayList<>();
		list = Db.readRb(pageNo);
		return list;
	}
	
	public String detailRb(String selectBno) {
		return Db.detailRb(selectBno);
	}
	
	public String deleteRb(String bno) {
		return Db.deleteRb(bno);
	}
	
	public String updateRb(ReviewBoard rb) {
		return Db.updateRb(rb);
	}
	
	
	
	
	
	
	
}
