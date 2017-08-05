package ro.sci.carrental.writer;

import java.io.File;
import java.util.List;

/**
 * Generic Object writer interface
 */
public interface EntityWriter<T> {

    /**
     * Writes objects to a specified file
     *
     * @param t Objects to write
     * @param file File output
     */
    void writeObjects(List<T> t, File file);
}
