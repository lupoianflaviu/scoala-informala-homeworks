package ro.sci.carrental.reader;

/**
 * Created by CCA on 15/07/2017.
 */
public interface Convertor<T> {

    /**
     * Convert string from file for Object persistence
     * @param convertedString
     * @return
     * @throws InvalidEntityException When reading invalid data from file
     */
    T convert(String convertedString) throws InvalidEntityException;
}
