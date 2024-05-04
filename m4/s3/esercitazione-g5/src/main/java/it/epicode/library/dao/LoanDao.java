package it.epicode.library.dao;

import it.epicode.library.entities.Loan;

import java.util.List;

public interface LoanDao {

    List<Loan> getLoansByUserTessera(int cardNumber);

    List<Loan> getOverdueLoans();

}
