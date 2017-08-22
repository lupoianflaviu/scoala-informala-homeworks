package ro.sci.carrental.repository;

import java.util.List;

import ro.sci.carrental.calendar.Transaction;

/**
 * Store all transactions in a repository.
 * @author flaviu.lupoian
 */
public interface TransactionRepository<T extends Transaction> extends Repository<T> {
    /**
     * Get Transaction by Id
     * @return List<T>
     */
    List<T> getTransactionbyId(int id);

    /**
     * Add transaction
     */
    void add(T transaction);

    /**
     * Delete transaction
     */
    void delete(T transaction);

    /**
     * Update transaction
     */
    void update(T transaction);

    /**
     * Get All Transactions
     * @return List<T>
     */
    List<T> getAll();

}
