package ro.sci.carrental.service;

import java.util.List;

/**
 * Transaction interceptor service
 *
 * @author flaviu.lupoian
 */
public interface TransactionInterceptorService<T> {
    /**
     * Get All Transactions
     *
     * @return List<T>
     */
    List<T> getAll();

    /**
     * Get Transaction by Id
     *
     * @return List<T>
     */
    List<T> findTransactionbyId(int id);

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
}
