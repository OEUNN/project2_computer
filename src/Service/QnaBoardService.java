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
	
	public int getTotalRow(String loginId) {
		Connection conn = null;
		int totalRow=0;
		try {
			conn=ds.getConnection();
			totalRow = qnaBoardDao.getTotalRow(conn,loginId);
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
	
	
<<<<<<< HEAD
	
	
	//o
	public ArrayList<QnaBoard> readQnaBoardPager(Pager pager, String loginId) {
=======
	public ArrayList<QnaBoard> readQnaBoardPager(Pager pager) {
>>>>>>> 42a3130f16755fd8a026f9741cae5050f59d9941
		Connection conn = null;
		ArrayList<QnaBoard> list = new ArrayList<>();
		
		try {
			conn=ds.getConnection();
			list = qnaBoardDao.readQnaBoardPager(pager,conn,loginId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		return list;
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
<<<<<<< HEAD
	
=======
>>>>>>> 42a3130f16755fd8a026f9741cae5050f59d9941

	public String updateQnaBoard(QnaBoard qnaBoard) {
		Connection conn = null;
		String Output=null;
		try {
			conn=ds.getConnection();
			Output = qnaBoardDao.updateQnaBoard(qnaBoard,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		return Output;
	}
	
}
