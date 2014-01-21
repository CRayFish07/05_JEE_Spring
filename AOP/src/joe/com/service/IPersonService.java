package joe.com.service;

public interface IPersonService {
	public void save(String name);
	public void update(String name, Integer personId);
	public String getPersonName(Integer personId);
}
