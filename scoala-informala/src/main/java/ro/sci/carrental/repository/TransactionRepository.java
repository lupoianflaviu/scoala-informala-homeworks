package ro.sci.carrental.repository;

import java.util.List;

import ro.sci.carrental.calendar.Transaction;

/**
 * Store all transactions in a repository.
 */
public interface TransactionRepository {
    /**
     * Get all
     */
    List<Transaction> getAll();

    /**
     * Get by
     */
    List<Transaction> getTransactionbyId(int id);

    /**
     * Add
     */
    void add(Transaction transaction);

    /**
     * Add all
     */
    void addAll(List<Transaction> transactions);

    /**
     * Delete
     */
    void delete(Transaction transaction);

    /**
     * Update
     */
    void update(Transaction transaction);

}
