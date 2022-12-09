package Service;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.ColorDao;
import dao.ProductImageDao;
import dto.Capacity;
import dto.Color;

public class ColorService {
	private ServletContext application; 
	private DataSource ds;

	private ColorDao colorDao; 
	
	public ColorService(ServletContext application) {
		this.application=application;
		
		colorDao= (ColorDao)this.application.getAttribute("colorDao");
		
		ds=(DataSource)this.application.getAttribute("dataSource");
	}

	public Color getColor(String colorId) {
		Connection conn = null;
		Color color = new Color();
		try {		
			conn=ds.getConnection();
			color = colorDao.selectColor(colorId, conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}		
		return color;
	}
	
}
