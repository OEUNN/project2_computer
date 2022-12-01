package context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import DAO.QnaBoardDao;
import DAO.UsersDao;
import Service.BasketService;
import Service.OrderService;
import Service.ProductService;
import Service.QnaBoardService;
import Service.ReviewBoardService;
import Service.UserService;

//servletContextPath : web app의 실행환경 정보를 가지고 있는 객체
public class WebAppContext implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext(=WebApplication)가 생성 완료됨");
		
		//ServletContext 객체 얻기
		ServletContext application = sce.getServletContext();
		
		//ServletContext 객체에 데이터(객체) 저장
		application.setAttribute("userService", new UserService(application));
		application.setAttribute("basketService", new BasketService(application));
		application.setAttribute("orderService", new OrderService(application));
		application.setAttribute("productService", new ProductService(application));
		application.setAttribute("qnaBoardService", new QnaBoardService(application));
		application.setAttribute("reviewBoardService", new ReviewBoardService(application));
		
		application.setAttribute("usersDao", new UsersDao());
		application.setAttribute("basketDao", new BasketDao());
		application.setAttribute("basketDeatilDao", new BasketDeatilDao());
		application.setAttribute("orderDao", new OrderDao());
		application.setAttribute("orderDeatilDao", new OrderDeatilDao());
		application.setAttribute("productDao", new ProductDao());
		application.setAttribute("productDeatilDao", new ProductDeatilDao());
		application.setAttribute("qnaBoardDao", new QnaBoardDao());
		application.setAttribute("reviewBoardDao", new ReviewBoardDao());
		
	}
	
}
