package Service;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.CapacityDao;
import dao.ProductImageDao;
import dto.Capacity;
import dto.ProductImage;

public class CapacityService {
	private ServletContext application; 
	private DataSource ds;

	private CapacityDao capacityDao; 
	
	public CapacityService(ServletContext application) {
		this.application=application;
		
		capacityDao= (CapacityDao)this.application.getAttribute("capacityDao");		
		ds=(DataSource)this.application.getAttribute("dataSource");
	}

	public Capacity getCapacity(String capacityId) {
		Connection conn = null;
		Capacity capacity = new Capacity();
		try {		
			conn=ds.getConnection();
			capacity = capacityDao.selectCapacity(capacityId, conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{ conn.close(); }catch(Exception e) {}
		}
		
		return capacity;
	}
	
}
