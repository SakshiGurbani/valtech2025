package com.valtech.training.loanservice.services;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.valtech.training.loanservice.entities.Loan;
import com.valtech.training.loanservice.repos.LoanRepo;
import com.valtech.training.loanservice.vos.LoanVO;

@WebService(endpointInterface = "com.valtech.training.loanservice.webservices.LoanServiceWS",name="LoanService",
portName="LoanServicePort")
public class LoanServiceImpl implements LoanService  {
	
	@Autowired
	private LoanRepo loanRepo;
	
	public LoanServiceImpl (LoanService loanService) {
		this.loanService=loanService;
	}
	
	@Override
	public Loan saveLoan(Loan loan) {
		return loanService.saveLoan(LoanVO.from(loan)).to();
	}
	
	@Override
	public Loan getLoan(int id) {
		return loanService.getLoan(id).to();
	}
	
	@Override
	public Loan applyLoan(Loan loan) {
		return loanService.applyLoan(LoanVO.from(loan)).to();
	}

	@Override
	public LoanVO saveLoan(LoanVO from) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoanVO applyLoan(LoanVO from) {
		// TODO Auto-generated method stub
		return null;
	}



}
