package database.entity;

import java.util.Objects;

public class Product {

    private String enName;
    private String skName;
    private int count;
    private double price;

    public Product(String enName, String skName, double price, int count) {
        this.enName = enName;
        this.skName = skName;
        this.count = count;
        this.price = price;
    }

    public Product(String enName, int count, double price) {
        this.enName = enName;
        this.count = count;
        this.price = price;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return count == product.count &&
                enName.equals(product.enName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(enName, count);
    }

    @Override
    public String toString() {
        return "Product{" +
                "enName='" + enName + '\'' +
                ", count=" + count +
                '}';
    }
}
