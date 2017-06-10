package ro.sci.carrental.service;

import ro.sci.carrental.calendar.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Transaction interceptor service
 */
public interface TransactionInterceptorService {
    /**
     * Find same make cars in system.
     */
    List<Transaction> findTransactionbyId(int id);
    /**
     * find all
     */
    List<Transaction> findAll(ArrayList<Transaction> transactions);
}
