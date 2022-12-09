package context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import Service.BasketService;
import Service.CapacityService;
import Service.ColorService;
import Service.ImageService;
import Service.OrderService;
import Service.ProductService;
import Service.QnaBoardService;
import Service.ReviewBoardService;
import Service.UserService;
import dao.BasketDao;
import dao.BasketDetailDao;
import dao.CapacityDao;
import dao.ColorDao;
import dao.OrderDao;
import dao.OrderDetailDao;
import dao.ProductCapacityDao;
import dao.ProductColorDao;
import dao.ProductDao;
import dao.ProductImageDao;
import dao.QnaBoardDao;
import dao.ReviewBoardDao;
import dao.UsersDao;
 

//servletContextPath : web app의 실행환경 정보를 가지고 있는 객체
public class WebAppContext implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext(=WebApplication)가 생성 완료됨");
		
		//ServletContext 객체 얻기
		ServletContext application = sce.getServletContext();
		
		
		//ConnectionPool
		DataSource dataSource = ConnectionProvider.getDataSource();
		application.setAttribute("dataSource", dataSource);
		
		//ServletContext 객체에 데이터(객체) 저장
		application.setAttribute("usersDao", new UsersDao());
		application.setAttribute("basketDao", new BasketDao(application));
		application.setAttribute("basketDetailDao", new BasketDetailDao());
		application.setAttribute("orderDao", new OrderDao());
		application.setAttribute("orderDetailDao", new OrderDetailDao());
		application.setAttribute("productDao", new ProductDao());
		application.setAttribute("colorDao", new ColorDao());
		application.setAttribute("capacityDao", new CapacityDao());

		application.setAttribute("qnaBoardDao", new QnaBoardDao());
		application.setAttribute("reviewBoardDao", new ReviewBoardDao());
		application.setAttribute("productColorDao", new ProductColorDao());
		application.setAttribute("productCapacityDao", new ProductCapacityDao());
		application.setAttribute("productImageDao", new ProductImageDao());
		
		application.setAttribute("userService", new UserService(application));
		application.setAttribute("basketService", new BasketService(application));
		application.setAttribute("orderService", new OrderService(application));
		application.setAttribute("productService", new ProductService(application));
		application.setAttribute("qnaBoardService", new QnaBoardService(application));
		application.setAttribute("reviewBoardService", new ReviewBoardService(application));
		application.setAttribute("imageService", new ImageService(application));
		application.setAttribute("capacityService", new CapacityService(application));
		application.setAttribute("colorService", new ColorService(application));
		
		
		
	}
	
}
