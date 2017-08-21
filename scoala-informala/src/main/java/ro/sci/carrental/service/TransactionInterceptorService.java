package ro.sci.carrental.service;

import java.util.ArrayList;
import java.util.List;

import ro.sci.carrental.calendar.Transaction;

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
