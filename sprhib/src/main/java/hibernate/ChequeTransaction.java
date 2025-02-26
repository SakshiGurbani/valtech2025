package hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "ctx")
//@Table(name="ctxper")
public class ChequeTransaction extends Tx {
	
	private int chequeNo;
	

	public ChequeTransaction() {}

	public ChequeTransaction(double amount ,int chequeNo) {
		super(amount);
		this.chequeNo = chequeNo;
	}
	
	

	public int getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(int chequeNo) {
		this.chequeNo = chequeNo;
	}

	@Override
	public String toString() {
		return "ChequeTransaction [chequeNo=" + chequeNo + ", getId()=" + getId() + ", getAmount()=" + getAmount()
				+ "]";
	}

	

}
