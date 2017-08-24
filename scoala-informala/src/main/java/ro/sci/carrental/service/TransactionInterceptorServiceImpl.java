package ro.sci.carrental.service;

import java.util.List;

import ro.sci.carrental.calendar.Transaction;

/**
 * Created on 10/06/2017.
 *
 * @author flaviu.lupoian
 */
public class TransactionInterceptorServiceImpl<T extends Transaction> implements TransactionInterceptorService<T> {
    // to be implemented

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public List<T> findTransactionbyId(int id) {
        return null;
    }

    @Override
    public void add(T transaction) {

    }

    @Override
    public void delete(T transaction) {

    }

    @Override
    public void update(T transaction) {

    }
}
