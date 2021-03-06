package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.EmpDao;
import jdbc.ConnectionProvider;
import model.Emp;

public class EmpListService {
	
	private EmpListService() {}
	
	private static EmpListService service = new EmpListService();
	
	public static EmpListService getInstance() {
		return service;
	}
	
	EmpDao dao;
	
	public List<Emp> getEmpList(){
		
		// 사용할 Dao 인스턴스 
		dao = EmpDao.getInstance();
		
		// Connection
		Connection conn=null;
		List<Emp> list = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			list = dao.getEmpList(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
