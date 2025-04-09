package com.valtech.training.loanservice.services;

import java.util.List;

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
	
	@Override
	public LoanVO saveLoan(LoanVO lvo) {
		return LoanVO.from(loanRepo.save(lvo.to()));
	}
	@Override
	public LoanVO getLoan(int id) {
		return LoanVO.from(loanRepo.getReferenceById(id));
	}
	@Override
	public List<LoanVO> getAllLoans(){
		return LoanVO.from(loanRepo.findAll());
	}
	@Override
	public LoanVO applyForLoan(LoanVO lvo) {
		Loan loan = lvo.to();
		loan.setStatus(Status.APPLIED);
		return saveLoan(LoanVO.from(processLoan(LoanVO.from(loan))));
	}
	@Override
	public Loan processLoan(LoanVO loanVO) {
		Loan loan = loanVO.to();
		int cibilScore = loan.getCibilScore();
		int assetValue = loan.getAssetValue();
		int value  = loan.getValue();
		int income = loan.getIncome();
		if (cibilScore < 600) {
			loan.setStatus(Status.REJECTED);
			return loan;
		}
		else if(cibilScore < 800) {
			if (assetValue >= value * 0.7 && income * 5 >= value) {
				loan.setStatus(Status.APPROVED);
				return loan;
			}
			else {
				loan.setStatus(Status.REJECTED);
				return loan;
			}
		}
		else {
			if (assetValue >= value * 0.6 && income * 4 >= value) {
				loan.setStatus(Status.APPROVED);
				return loan;
			 }
			else {
				loan.setStatus(Status.REJECTED);
				return loan;
			}
		}
	}



}
