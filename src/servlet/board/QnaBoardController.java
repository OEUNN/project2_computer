package servlet.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.QnaBoard;
import Service.QnaBoardService;
import util.Pager;

@WebServlet(name = "board.QnaBoardController", urlPatterns =  "/board/QnaBoardController" )
public class QnaBoardController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("QnaBoardController service()실행");
		String strPageNo = request.getParameter("pageNo");
		if(strPageNo==null) {
			strPageNo="1";
		}
		int pageNo=Integer.parseInt(strPageNo);
		ServletContext application = request.getServletContext();
		QnaBoardService boardService= (QnaBoardService)application.getAttribute("qnaBoardService");
		//페이징 대상이 되는 전체 행수 얻기
		int totalBoardNum = boardService.getTotalRow();
		
		//Pager 생성
		Pager pager = new Pager(10,5,totalBoardNum,pageNo);
		
		//pageNo에 해당하는 게시물 가져오기
		List<QnaBoard> qnaList=boardService.readQnaBoardPager(pager);
		//JSP에서 사용할수 있도록 request범위에 저장
		request.setAttribute("pager", pager);
		request.setAttribute("qnaList",qnaList);
		
		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/board/qnaBoard.jsp").forward(request, response);
	}

}
