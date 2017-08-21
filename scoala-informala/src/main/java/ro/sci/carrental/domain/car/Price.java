package ro.sci.carrental.domain.car;

import java.text.DecimalFormat;

/**
 * Created by CCA on 25/06/2017.
 */
public class Price {
    private double value = 0;
    private String formattedValue;

    public Price() {
    }

    public Price(double value) {

        this.value = value;
        DecimalFormat df = new DecimalFormat("###.00");
        this.formattedValue = df.format(this.value);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getFormattedValue() {
        return formattedValue;
    }

    public void setFormattedValue(String formattedValue) {
        this.formattedValue = formattedValue;
    }

    @Override
    public String toString() {
        return formattedValue;
    }
}
