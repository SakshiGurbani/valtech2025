package practicSpr;

import java.util.List;

public class Person {
	
	private String name;
	private int personId;
	private Certi cer;
	private List<String> list;
	
	
	public Person(String name,int personId,Certi cer,List<String> list) {
		this.name=name;
		this.personId=personId;
		this.cer=cer;
		this.list=list; 
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}


	public Certi getCer() {
		return cer;
	}

	public void setCer(Certi cer) {
		this.cer = cer;
	}

	public List<String> getList() {
		return list;
	}


	public void setList(List<String> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return this.name+" : "+this.personId +"{"+this.cer+"}"+this.list;
	}
	
	

}
