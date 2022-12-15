package servlet.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import Service.ProductService;
import dto.Product;
import util.Pager;

@WebServlet(name = "product.ProductListController", urlPatterns =  "/product/ProductListController" )
public class ProductListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ProductListController service()실행!!!!");
		String strPageNo = request.getParameter("pageNo");
		Product product=new Product();
		if(strPageNo==null) {
			strPageNo="1";
		}
		
		int pageNo=Integer.parseInt(strPageNo);
		ServletContext application = request.getServletContext();
		ProductService productService= (ProductService)application.getAttribute("productService");
		//페이징 대상이 되는 전체 행수 얻기
		int totalBoardNum = productService.getTotalRow(product);
		
		//Pager 생성
		Pager pager = new Pager(6,5,totalBoardNum,pageNo);
		
		//pageNo에 해당하는 게시물 가져오기
		List<Product> productList=productService.getList(pager,product);
		//JSP에서 사용할수 있도록 request범위에 저장
		Product categoryList=productService.getCategory();
		request.setAttribute("pager", pager);
		request.setAttribute("productList",productList);
		request.setAttribute("graProList",categoryList.getGraphcCardList() );
		request.setAttribute("cpuProList",categoryList.getCpuList() );
		request.setAttribute("meProList",categoryList.getMemoryList() );
		request.setAttribute("maProList",categoryList.getMainboardList() );
		request.setAttribute("osProList",categoryList.getOsList() );
		/*for(Product product:productList) {
			System.out.println(product);
			
		}*/
		//System.out.println(categoryList.getGraphcCardList());
		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/product/productList.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ProductListController service()실행!!!!");
		String strPageNo = request.getParameter("pageNo");
		String graphicCard = request.getParameter("graphic");
		String cpu = request.getParameter("cpu");
		String memoryCard = request.getParameter("memoryCard");
		String mainBoard = request.getParameter("mainBoard");
		String os = request.getParameter("os");
		String price = request.getParameter("price");
		String searchVal = request.getParameter("searchVal");
		Product product=new Product();
		
		if(graphicCard!=null) {
			product.setProductGraphicCard(graphicCard);
		}
		if(cpu!=null) {
			product.setCPU(cpu);
		}
		if(memoryCard!=null) {
			product.setMemory(memoryCard);
		}
		if(mainBoard!=null) {
			product.setMainboard(mainBoard);
		}
		if(os!=null) {
			product.setOs(os);
		}
		if(searchVal!=null) {
			product.setProductName(searchVal);
		}
		if(price!=null) {
			product.setProductPrice(Integer.parseInt(price));
		}else {
			product.setProductPrice(0);
		}
		if(strPageNo==null) {
			strPageNo="1";
		}
		int pageNo=Integer.parseInt(strPageNo);
		ServletContext application = request.getServletContext();
		ProductService productService= (ProductService)application.getAttribute("productService");
		//페이징 대상이 되는 전체 행수 얻기
		int totalBoardNum = productService.getTotalRow(product);
		
		//Pager 생성
		Pager pager = new Pager(6,5,totalBoardNum,pageNo);
		
		//pageNo에 해당하는 게시물 가져오기
		List<Product> productList=productService.getList(pager,product);
		//JSP에서 사용할수 있도록 request범위에 저장
		request.setAttribute("pager", pager);
		request.setAttribute("productList",productList);
		request.getRequestDispatcher("/WEB-INF/views/product/product.jsp").forward(request, response);
		/*response.setContentType("application/json; charset=UTF-8");

		JSONObject root = new JSONObject();
		root.put("pager", pager);
		root.put("productList", productList);
		
		String json=root.toString();
		
		PrintWriter pw = response.getWriter();
		pw.println(json);
		pw.flush();
		pw.close();*/
		
	}

}
