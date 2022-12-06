package Service;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.QnaBoardDao;
import dto.QnaBoard;
import util.Pager;

public class QnaBoardService {
	private ServletContext application;
	private DataSource ds;
	private QnaBoardDao qnaBoardDao;
	
	public QnaBoardService(ServletContext application) {
		this.application=application;
		qnaBoardDao = (QnaBoardDao)application.getAttribute("qnaBoardDao");
		ds=(DataSource)application.getAttribute("dataSource");
	}
	
	public int getTotalRow() {
		Connection conn = null;
		int totalRow=0;
		try {
			conn=ds.getConnection();
			totalRow = qnaBoardDao.getTotalRow(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		return totalRow;
	}
	
	
	public String writeQnaBoard(QnaBoard qnaBoard) {
		Connection conn = null;
		String Output=null;
		try {
			System.out.println("글쓰기 서비스");
			conn=ds.getConnection();
			Output = qnaBoardDao.Insert(qnaBoard,conn);
			System.out.println(Output);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {e.printStackTrace();}
		}
		return Output;
	}
	
	public ArrayList<QnaBoard> readQnaBoard(String readQnaBoard) {
		Connection conn = null;
		ArrayList<QnaBoard> list = new ArrayList<>();
		
		try {
			conn=ds.getConnection();
			list = qnaBoardDao.ReadAll(readQnaBoard,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		return list;
	}
	
	public QnaBoard selectQnaBoard(QnaBoard qnaBoard) {
		Connection conn = null;
		QnaBoard qnaBoard2 = new QnaBoard();
		try {
			conn=ds.getConnection();
			qnaBoard2 = qnaBoardDao.readQnaBoard(qnaBoard,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		return qnaBoard2;
	}
	
	public ArrayList<QnaBoard> readQnaBoardPager(Pager pager) {
		Connection conn = null;
		ArrayList<QnaBoard> list = new ArrayList<>();
		
		try {
			conn=ds.getConnection();
			list = qnaBoardDao.readQnaBoardPager(pager,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		return list;
	}
	
	public ArrayList<QnaBoard> readMyPost(QnaBoard qnaBoard, Pager pager) {
		Connection conn = null;
		ArrayList<QnaBoard> list = new ArrayList<>();
		
		try {
			conn=ds.getConnection();
			list = qnaBoardDao.readMyPost(qnaBoard, pager,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		return list;
	}
	public int getUserIDBoardCount(QnaBoard qnaBoard) {
		Connection conn = null;
		
		int getUserIDBoardCount = 0;
		try {
			conn=ds.getConnection();
			getUserIDBoardCount = qnaBoardDao.getUserIDBoardCount(qnaBoard,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		return getUserIDBoardCount;
	}
	
	public String deleteQnaBoard(QnaBoard qnaBoard) {
		Connection conn = null;
		String Output=null;
		try {
			conn=ds.getConnection();
			Output = qnaBoardDao.deleteQnaBoard(qnaBoard,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
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
