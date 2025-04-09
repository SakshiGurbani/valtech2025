package com.valtech.training.loanservice.services;

import java.util.List;

import com.valtech.training.loanservice.entities.Loan;
import com.valtech.training.loanservice.vos.LoanVO;

public interface LoanService {
	LoanVO saveLoan(LoanVO lvo);

	LoanVO getLoan(int id);

	List<LoanVO> getAllLoans();

	LoanVO applyForLoan(LoanVO lvo);

	Loan processLoan(LoanVO loanVO);

}