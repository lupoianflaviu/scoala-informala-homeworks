package ro.sci.carrental.domain.car;

/**
 * Car Class initialisation
 *
 * @author Flaviu Lupoian
 * @version 1.0
 * @since 1.8
 */
public class Car {
    private String make;
    private String model;
    private float size;
    private String color;
    private int seats;
    private int doors;
    private boolean ac = false;
    private boolean gps = false;
    private Gearbox gearbox;
    private FuelType fuelType;
    private VehicleCategory vehicleCategory;
    private boolean reserved = false;
    private Price rentPrice;

    /**
     * Default constructor
     */
    public Car() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public boolean hasAc() {
        return ac;
    }

    public void setAc(boolean ac) {
        this.ac = ac;
    }

    public boolean isGps() {
        return gps;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void isReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public Price getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Price rentPrice) {
        this.rentPrice = rentPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (Float.compare(car.size, size) != 0) return false;
        if (seats != car.seats) return false;
        if (doors != car.doors) return false;
        if (ac != car.ac) return false;
        if (gps != car.gps) return false;
        if (reserved != car.reserved) return false;
        if (make != null ? !make.equals(car.make) : car.make != null) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        if (color != null ? !color.equals(car.color) : car.color != null) return false;
        if (gearbox != car.gearbox) return false;
        if (fuelType != car.fuelType) return false;
        return vehicleCategory == car.vehicleCategory;
    }

    @Override
    public int hashCode() {
        int result = make != null ? make.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (size != +0.0f ? Float.floatToIntBits(size) : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + seats;
        result = 31 * result + doors;
        result = 31 * result + (ac ? 1 : 0);
        result = 31 * result + (gps ? 1 : 0);
        result = 31 * result + (gearbox != null ? gearbox.hashCode() : 0);
        result = 31 * result + (fuelType != null ? fuelType.hashCode() : 0);
        result = 31 * result + (vehicleCategory != null ? vehicleCategory.hashCode() : 0);
        result = 31 * result + (reserved ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(make).append(",").append(model).append(",").append(size).append(",")
                .append(color).append(",").append(seats).append(",").append(doors).append(",").append(ac).append(",")
                .append(gps).append(",").append(gearbox).append(",").append(fuelType).append(",").append(vehicleCategory)
                .append(",").append(reserved).append(",").append(rentPrice);
        return result.toString();
    }
}
