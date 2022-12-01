package Service;

import java.util.ArrayList;

import DAO.QnaBoardDao;
import DTO.QnaBoard;
import DTO.ReviewBoard;
import util.Pager;

public class QnaBoardService {
	QnaBoard freeBoard = new QnaBoard();
	String Output;
	int totalRow;
	
	public int getTotalRow() {
		QnaBoardDao Db = new QnaBoardDao();
		Db = new QnaBoardDao();
		totalRow = Db.getTotalRow();
		return totalRow;
	}
	
	
	public String writeFb(QnaBoard freeBoard) {
		QnaBoardDao Db = new QnaBoardDao();
		Db = new QnaBoardDao();
		Output = Db.Insert(freeBoard);
		return Output;
	}
	
	public ArrayList<QnaBoard> readFb(String readFb) {
		QnaBoardDao Db = new QnaBoardDao();
		ArrayList<QnaBoard> list = new ArrayList<>();
		Db = new QnaBoardDao();
		list = Db.ReadAll(readFb);
		return list;
	}
	
	public QnaBoard selectFb(QnaBoard freeBoard) {
		QnaBoardDao Db = new QnaBoardDao();
		Db= new QnaBoardDao();
		QnaBoard freeBoard2 = new QnaBoard();
		freeBoard2 = Db.ReadFb(freeBoard);
		return freeBoard2;
	}
	
	public ArrayList<QnaBoard> readFbPager(Pager pager) {
		QnaBoardDao Db = new QnaBoardDao();
		ArrayList<QnaBoard> list = new ArrayList<>();
		Db = new QnaBoardDao();
		list = Db.ReadFbpager(pager);
		return list;
	}
	
	public ArrayList<QnaBoard> readMyPost(QnaBoard freeBoard, Pager pager) {
		QnaBoardDao Db = new QnaBoardDao();
		ArrayList<QnaBoard> list = new ArrayList<>();
		Db = new QnaBoardDao();
		list = Db.readMyPost(freeBoard, pager);
		return list;
	}
	public int getUserIDBoardCount(QnaBoard freeBoard) {
		QnaBoardDao Db = new QnaBoardDao();
		Db = new QnaBoardDao();
		int getUserIDBoardCount = Db.getUserIDBoardCount(freeBoard);
		return getUserIDBoardCount;
	}
	
	public String DeleteFb(QnaBoard freeBoard) {
		QnaBoardDao Db = new QnaBoardDao();
		Db = new QnaBoardDao();
		Output = Db.DeleteFb(freeBoard);
		return Output;
	}
	public String Or(String userId) {
		QnaBoardDao Db = new QnaBoardDao();
		return Db.ordered(userId);
	}
	
	
	
	
	
	
	
	
	
}
