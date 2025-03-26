package com.valtech.training.loanservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.loanservice.entities.Loan;
import com.valtech.training.loanservice.entities.Loan.LoanStatus;
import com.valtech.training.loanservice.entities.Loan.LoanType;

public record LoanVO (int id,String userName, int aadhar, int cibilScore, String loanType, String asset, int assetValue,
		int value, int income,String status ){

	public static LoanVO from(Loan l ) {

		
		return new LoanVO(l.getId(),l.getUserName(), l.getAadhar(), l.getCibilScore(), l.getLoanType().name(),
				l.getAsset(), l.getAssetValue(), l.getValue(),l.getIncome(),l.getLoanStatus().name());
	}
	public static List<LoanVO> from(List<Loan> loans){
		return loans.stream().map(loan -> LoanVO.from(loan)).collect(Collectors.toList());
	}
	public Loan to() {
		return new Loan(userName,aadhar,cibilScore,LoanType.valueOf(loanType),asset,assetValue,value,income,LoanStatus.valueOf(status));
	}
}
