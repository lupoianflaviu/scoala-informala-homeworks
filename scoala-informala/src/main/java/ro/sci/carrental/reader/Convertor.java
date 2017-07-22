package ro.sci.carrental.reader;

/**
 * Generic interface for string to object conversion
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
