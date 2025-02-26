package teluskoHib;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	
	
	@Id 
	private int srollno;
	private String sName;
	private int sAge;
	
	
	public int getSrollno() {
		return srollno;
	}
	public void setSrollno(int srollno) {
		this.srollno = srollno;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getsAge() {
		return sAge;
	}
	public void setsAge(int sAge) {
		this.sAge = sAge;
	}
	
	@Override
	public String toString() {
		return "Student [srollno=" + srollno + ", sName=" + sName + ", sAge=" + sAge + "]";
	}
	
	
	
	

}
