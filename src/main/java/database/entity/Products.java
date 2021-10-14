package database.entity;

import java.util.Objects;
public class Products {

    private String enName;
    private String skName;
    private double price;
    private int count;

    public Products(String enName, String skName, double price, int count) {
        this.enName = enName;
        this.skName = skName;
        this.price = price;
        this.count = count;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getSkName() {
        return skName;
    }

    public void setSkName(String skName) {
        this.skName = skName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Products{" +
                "enName='" + enName + '\'' +
                ", skName='" + skName + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return Double.compare(products.price, price) == 0 &&
                count == products.count &&
                enName.equals(products.enName) &&
                skName.equals(products.skName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enName, skName, price, count);
    }
}