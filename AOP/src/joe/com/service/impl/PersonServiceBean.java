package joe.com.service.impl;

import joe.com.service.IPersonService;

public class PersonServiceBean implements IPersonService {
	private String user = null;
	
	public String getUser() {
		return user;
	}
	
	public PersonServiceBean(){}
	public PersonServiceBean(String user) {
		this.user = user;
	}
	
	@Override
	public void save(String name) {
		System.out.println("save() in PersonServiceBean is called.");
	}

	@Override
	public void update(String name, Integer personId) {
		System.out.println("update() in PersonServiceBean is called.");
	}

	@Override
	public String getPersonName(Integer personId) {
		return "xxx";
	}

}
