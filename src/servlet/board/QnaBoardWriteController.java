package servlet.board;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.QnaBoardService;
import dto.QnaBoard;
 
@WebServlet(name="board.QnaBoardWriteController",urlPatterns="/board/QnaBoardWriteController")
public class QnaBoardWriteController extends HttpServlet {
	
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			ServletContext application = request.getServletContext();
			QnaBoardService qnaBoardService = (QnaBoardService)application.getAttribute("qnaBoardService");
			HttpSession session = request.getSession();
			String loginId =(String)session.getAttribute("loginId");
			
			QnaBoard qnaBoard = new QnaBoard();
			
			System.out.println("글을 씁니다.");
			qnaBoard.setQnaBtitle(request.getParameter("title"));
			qnaBoard.setQnaBcontent(request.getParameter("inquiryContent"));
			qnaBoard.setUserId(loginId);
			/*HttpSession session=request.getSession();
			qnaBoard.setUserId((String)session.getAttribute("bwriter"));
			*/
			System.out.println(qnaBoard);
			String result=qnaBoardService.writeQnaBoard(qnaBoard);
			System.out.println(result);
			response.sendRedirect("QnaBoardController");
		}
		
}
