package com.valtech.training.loanservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.loanservice.entities.Loan;
import com.valtech.training.loanservice.entities.Loan.LoanStatus;
import com.valtech.training.loanservice.entities.Loan.LoanType;

public record LoanVO(int id,String userName,int aadhar,int cibilScore, String LoanType,String assest,int assetValue,int value
		int income, String loanStatus) {
	
	public static LoanVO from(Loan l) {
		return new LoanVO(l.getId(),l.getUserName(),l.getAadhar(),l.getCibilScore(),l.getLoanType(),l.getAsset()
				l.getAssertValue(),l.getValue(),l.getIncome(),l.getLoanStatus()); 
	}
	
	public Loan to() {
		return new Loan(userName,aadhar,cibilScore,LoanType.valueOf(loanType),asset,assertValue,income,LoanStatus.valueOf(loanStatus));
	}
	
	public static List<LoanVO> from(List<Loan>loan){
		return loan.stream().map(l->LoanVO.from(l)).collect(Collectors.toList());
	}

}
