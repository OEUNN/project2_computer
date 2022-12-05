package servlet.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "board.QnaBoardController", urlPatterns =  "/board/QnaBoardController" )
public class QnaBoardController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("QnaBoardController service()실행");
		
		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/board/qnaBoard.jsp").forward(request, response);
	}

}
