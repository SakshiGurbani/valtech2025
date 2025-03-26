package practicSpr;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Emp {
	
	private String ename;
	private List<String> phones;
	private Set<String> address;
	private Map<String,String> course;
	private Properties props;
	
	
	public Properties getProps() {
		return props;
	}
	public void setProps(Properties props) {
		this.props = props;
	}



	public Emp() {}
	
	

	public Emp(String ename, List<String> phones, Set<String> address, Map<String, String> course,Properties props) {
		super();
		this.ename = ename;
		this.phones = phones;
		this.address = address;
		this.course = course;
		this.props=props;
	}



	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public List<String> getPhones() {
		return phones;
	}

	public void setPhones(List<String> phones) {
		this.phones = phones;
	}

	public Set<String> getAddress() {
		return address;
	}

	public void setAddress(Set<String> address) {
		this.address = address;
	}

	public Map<String, String> getCourse() {
		return course;
	}

	public void setCourse(Map<String, String> course) {
		this.course = course;
	}
	
	

}
