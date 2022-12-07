package servlet.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.QnaBoardService;
import dto.QnaBoard;
import util.Pager;

@WebServlet(name = "board.QnaBoardDeleteController", urlPatterns =  "/board/QnaBoardDeleteController" )
public class QnaBoardDeleteController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("QnaBoardDeleteController service()실행");
		
		ServletContext application = request.getServletContext();
		QnaBoardService qnaBoardService = (QnaBoardService)application.getAttribute("qnaBoardService");
		
		QnaBoard qnaBoard = new QnaBoard();
		
		
		
		qnaBoard.setQnaBno(request.getParameter("bno"));
		
		
		String result=qnaBoardService.deleteQnaBoard(qnaBoard);
		System.out.println(result);
		response.sendRedirect("QnaBoardController");
	}

}
