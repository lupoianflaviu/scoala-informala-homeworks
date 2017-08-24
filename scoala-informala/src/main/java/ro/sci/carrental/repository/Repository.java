package ro.sci.carrental.repository;

import java.util.List;

/**
 * Created on 16/07/2017.
 * @author flaviu.lupoian
 */
public interface Repository<T> {
    /**
     * Add object of type T in Repository
     *
     * @param t Can be Car, Customer or Transactions
     */
    void add(T t);

    /**
     * Delete object of type T from Repository
     * @param t Can be Car, Customer or Transactions
     */
    void delete(T t);

    /**
     * Update object of type T in Repository
     * @param t Can be Car, Customer or Transactions
     */
    void update(T t);

    /**
     * Get all objects List from Repository
     * @return List<T> list of objects
     */
    List<T> getAll();
}
