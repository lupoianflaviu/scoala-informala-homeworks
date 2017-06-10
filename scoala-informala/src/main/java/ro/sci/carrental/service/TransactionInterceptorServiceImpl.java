package ro.sci.carrental.service;

import ro.sci.carrental.calendar.Transaction;
import ro.sci.carrental.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CCA on 10/06/2017.
 */
public class TransactionInterceptorServiceImpl implements TransactionInterceptorService{
    // to be implemented

    private TransactionRepository transactionRepository;

    public List<Transaction> findTransactionbyId(int id) {
        return null;
    }

    public List<Transaction> findAll(ArrayList<Transaction> transactions) {
        return null;
    }
}
