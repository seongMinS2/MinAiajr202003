package test;

public class Service {
	// Service 는 dao 는 의존
	//Dao dao = new Dao();
	
	Dao dao;
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	public void print() {
		dao.print();
	}
}
