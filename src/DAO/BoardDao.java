package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import DTO.FreeBoard;
import DTO.ReviewBoard;
import util.ConnectionProvider;
import util.Pager;

public class BoardDao {
	String Output;
	int countRow;
	int totalRow;
	Pager pager = new Pager();
	
	public String Insert(FreeBoard freeBoard) {
		String sql = "insert into free_board (free_bno, free_btitle, free_bcontent, free_date, free_comment_num, users_User_Id) "
				+ " values ('17', ?, ?, sysdate, free_conum.nextval, ? ) ";
		Connection conn = ConnectionProvider.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//입력됨.
			pstmt.setString(1, freeBoard.getFreeBtitle());
			pstmt.setString(2, freeBoard.getFreeBcontent());
			pstmt.setString(3, freeBoard.getUserId());
			pstmt.executeUpdate();
			pstmt.close();
			Output = "success";
				
		} catch (Exception e) {
			Output = "fail";
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return Output;	
	}
	public FreeBoard ReadFb(FreeBoard freeBoard) {
		String sql = "select Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno "
				+ "from free_board "
				+ "where free_bno = ? ";
		FreeBoard free_Board2 = new FreeBoard();
		Connection conn = ConnectionProvider.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, freeBoard.getFreeBno());
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				free_Board2.setFreeBtitle(rs.getString(1));
				free_Board2.setFreeBcontent(rs.getString(2));
				free_Board2.setFreeDate(rs.getString(3));
				free_Board2.setUserId(rs.getString(4));
				free_Board2.setFreeBno(rs.getString(5));
			}
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return free_Board2;
	}
	
	
	
	
	
	public ArrayList<FreeBoard> ReadAll(String readFb) {
		
		ArrayList<FreeBoard> list = new ArrayList<>();
		String sql = "select rnum, Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno "
				+" from ( "
						+" select rownum as rnum, Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno "
						+" from (select rownum, Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno "
						+" from free_board " 
						+" order by free_date desc "
						+" ) where rownum <= 5 "
						+" )" 
						+" where rnum >= 1 " ;
		Connection conn = ConnectionProvider.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				FreeBoard free_Board = new FreeBoard();
				free_Board.setFreeBtitle(rs.getString(2));
				free_Board.setFreeBcontent(rs.getString(3));
				free_Board.setFreeDate(rs.getString(4));
				free_Board.setUserId(rs.getString(5));
				free_Board.setFreeBno(rs.getString(6));
				list.add(free_Board);
			}
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public int getTotalRow() {
		String sql = "select count (*) as count from free_board";
		Connection conn = ConnectionProvider.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				countRow = rs.getInt("count");
			}
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return countRow;
	}
	
	
	public ArrayList<FreeBoard> ReadFbpager(Pager pager) {
		
		ArrayList<FreeBoard> list = new ArrayList<>();
		String sql = "select rnum, Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno "
			+" from ( "
					+" select rownum as rnum, Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno "
					+" from (select Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno "
					+" from free_board " 
					+" order by free_date desc "
					+" ) where rownum <= ? "
					+" )" 
					+" where rnum >= ? " ;
		Connection conn = ConnectionProvider.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setInt(1, pager.getEndRowNo());
			pstmt.setInt(2, pager.getStartRowNo());

			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				FreeBoard free_Board = new FreeBoard();
				free_Board.setFreeBtitle(rs.getString(2));
				free_Board.setFreeBcontent(rs.getString(3));
				free_Board.setFreeDate(rs.getString(4));
				free_Board.setUserId(rs.getString(5));
				free_Board.setFreeBno(rs.getString(6));
				
				
				list.add(free_Board);
			}
			
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<FreeBoard> readMyPost(FreeBoard freeBoard, Pager pager) {
	ArrayList<FreeBoard> list = new ArrayList<>();
	String sql = "select rnum, Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno "
			+" from ( "
			+" select rownum as rnum, Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno "
			+" from (select Free_Btitle, Free_Bcontent, Free_Date, users_user_id,  free_bno "
			+" from free_board " 
			+" order by free_date desc "
			+" ) where rownum <= ? and users_user_id = ? "
			+" )" 
			+" where rnum >= ? " ;
	
	Connection conn = ConnectionProvider.getConnection();
	try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, pager.getEndRowNo());
		pstmt.setString(2, freeBoard.getUserId());
		pstmt.setInt(3, pager.getStartRowNo());

		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			FreeBoard freeBoard1 = new FreeBoard();
			freeBoard1.setFreeBtitle(rs.getString(2));
			freeBoard1.setFreeBcontent(rs.getString(3));
			freeBoard1.setFreeDate(rs.getString(4));
			freeBoard1.setUserId(rs.getString(5));
			freeBoard1.setFreeBno(rs.getString(6));
			
			list.add(freeBoard1);
		}
		
		pstmt.close();
		rs.close();
	} catch (Exception e) {
		e.getStackTrace();
	} finally {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return list;
}
	public int getUserIDBoardCount(FreeBoard free_Board) {
		String sql = "select count (*) as count from free_board where users_user_id = ? ";
		Connection conn = ConnectionProvider.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, free_Board.getUserId());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				countRow = rs.getInt("count");
			}
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return countRow;
	}
	
	
	public String DeleteFb(FreeBoard freeBoard) {
		String answer = "";
		String sql = "delete from free_board where users_user_id = ? and free_bno = ? ";
		Connection conn = ConnectionProvider.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, freeBoard.getUserId());
			pstmt.setString(2, freeBoard.getFreeBno());
			pstmt.executeUpdate();
			
			answer = "success";
			
			pstmt.close();
		} catch (Exception e) {
			e.getStackTrace();
			answer = "fail";
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return answer;
	}
		public String ordered(String userId) {  
			String sql="select ORDER_DETAIL_ID, PRODUCT_NAME from ORDER_DETAIL, PRODUCT "
					+ "where ORDERS_ORDER_ID in (select ORDER_ID from ORDERS where USER_USER_ID = ? ) "
					+ "and PRODUCT_ID=(select PRODUCT_PRODUCT_ID from PRODUCT_DETAIL where DETAIL_ID=PRODUCT_DETAIL_DETAIL_ID)"; //얘도 필드로
			Connection conn = ConnectionProvider.getConnection();
			JSONObject returnjson = new JSONObject().put("sf", "fail");
			JSONArray ja = new JSONArray();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userId);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					do {
						returnjson.put("sf", "success");
						JSONObject jo = new JSONObject(); 
						jo.put("ORDER_DETAIL_ID",rs.getString("ORDER_DETAIL_ID"));
						jo.put("PRODUCT_NAME", rs.getString("PRODUCT_NAME"));
						ja.put(jo);
					} while(rs.next());
					returnjson.put("json", ja);
				} 		
			} catch(Exception e) {
				e.printStackTrace();
			}	finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
			return returnjson.toString();
		}
		
		public String Insert(ReviewBoard rb) {
			String sql = "insert into REVIEW_BOARD (review_bno, Review_Btitle,Review_Bcontent, REVIEW_DATE, Review_Rate, USER_USER_ID, ORDER_DETAIL_ORDER_DETAIL_ID, PRODUCT_NAME )  values('28', ? , ? , SYSDATE, ? , ? , ?, ?)";
			Connection conn = ConnectionProvider.getConnection();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, rb.getReviewBtitle());
				pstmt.setString(2, rb.getReviewBcontent());
				pstmt.setInt(3, rb.getReviewRate());
				pstmt.setString(4, rb.getUserId());
				pstmt.setString(5, rb.getOrderDetailId());
				pstmt.setString(6, rb.getProductName());
				pstmt.executeUpdate();
				pstmt.close();
				Output = "success";
					
			} catch (Exception e) {
				Output = "fail";
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return Output;	
		}
		
		public int getTRRb() {
			Connection conn = ConnectionProvider.getConnection();
			
			try {
				String sql = "select count(*) from REVIEW_BOARD ";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					totalRow = rs.getInt(1);
				} else totalRow = 0;			
			}catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return totalRow;
		}
		
		public ArrayList<ReviewBoard> readRb(int pageNo) {
			Connection conn = ConnectionProvider.getConnection();
			ArrayList<ReviewBoard> list = new ArrayList<>();
			try {
				getTRRb();			
				 String sql = "select REVIEW_BNO, REVIEW_BTITLE, REVIEW_BCONTENT, REVIEW_DATE, REVIEW_RATE, USER_USER_ID, PRODUCT_NAME from ("
					+ "	select rownum as rnum, REVIEW_BNO,  REVIEW_BTITLE, REVIEW_BCONTENT, REVIEW_DATE, REVIEW_RATE, USER_USER_ID, PRODUCT_NAME from REVIEW_BOARD where rownum <= ?"
					+ "	order by REVIEW_DATE) where rnum >= ? ";
				Pager page = new Pager(5, 5, totalRow, pageNo);
				//page.setCurrPage(pageNo);
			
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, page.getEndRowNo());
				pstmt.setInt(2, page.getStartRowNo());
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) {
					ReviewBoard rb = new ReviewBoard();
					rb.setReviewBno(rs.getString(1));
					rb.setReviewBtitle(rs.getString(2));
					rb.setReviewBcontent(rs.getString(3));
					rb.setReviewDate(rs.getString(4));
					rb.setReviewRate(rs.getInt(5));
					rb.setUserId(rs.getString(6));
					rb.setProductName(rs.getString(7));
					
					list.add(rb);
				}
				
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return list;
		}
		
		public String detailRb(String selectBno) {
			JSONObject json = new JSONObject();
			String sql = "select REVIEW_BTITLE, REVIEW_BCONTENT, REVIEW_DATE, REVIEW_RATE, USER_USER_ID, PRODUCT_NAME from REVIEW_BOARD where REVIEW_BNO = ? ";
			Connection conn = ConnectionProvider.getConnection();
			try{
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, selectBno);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					json.put("sf", "success");
					json.put("review_Btitle", rs.getString(1));
					json.put("review_Bcontent", rs.getString(2));
					json.put("review_Date", rs.getString(3));
					json.put("review_Rate", rs.getInt(4));
					json.put("user_Id", rs.getString(5));
					json.put("product_Name", rs.getString(6));				
				} else json.put("sf", "fail");
							
				pstmt.close();
				rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return json.toString();
		}
		
		public String deleteRb(String bno) {
			String sql = "delete from REVIEW_BOARD where REVIEW_BNO = ? ";
			Connection conn = ConnectionProvider.getConnection();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bno);
				pstmt.executeUpdate();
				pstmt.close();
				Output = "success";
					
			} catch (Exception e) {
				Output = "fail";
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return Output;			
		}
		
		public String updateRb(ReviewBoard rb) {		
			String sql = "update REVIEW_BOARD set REVIEW_BTITLE = ?, REVIEW_BCONTENT = ?, REVIEW_DATE = sysdate, REVIEW_RATE = ? where REVIEW_BNO = ? ";
			Connection conn = ConnectionProvider.getConnection();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, rb.getReviewBtitle());
				pstmt.setString(2, rb.getReviewBcontent());
				pstmt.setInt(3, rb.getReviewRate());
				pstmt.setString(4, rb.getReviewBno());
				pstmt.executeUpdate();
				pstmt.close();
				Output = "success";
					
			} catch (Exception e) {
				Output = "fail";
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return Output;
	}
}
