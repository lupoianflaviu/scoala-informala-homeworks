package ro.sci.carrental.repository;

import java.util.List;

/**
 * Created by CCA on 16/07/2017.
 */
public interface Repository<T> {

    void addAll(List<T> t);

    void add(T t);

    void delete(T t);

    void update(T t);
}
