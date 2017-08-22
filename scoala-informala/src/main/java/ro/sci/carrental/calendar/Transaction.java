package ro.sci.carrental.calendar;

/**
 * Transaction
 *
 * @author flaviu.lupoian
 */
public class Transaction {

    private int id;
    private String name;
    private String argument;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }
}
