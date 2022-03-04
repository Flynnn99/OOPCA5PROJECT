package org.example;

import java.util.Objects;

public class Product {
    int product_Id;
    String name;
    String product_Type;
    double percentage;
    double price;

    public Product(int product_Id, String name, String product_Type, double percentage, double price) {
        this.product_Id = product_Id;
        this.name = name;
        this.product_Type = product_Type;
        this.percentage = percentage;
        this.price = price;

    }

    public int getProduct_Id() {
        return product_Id;
    }

    public void setProduct_Id(int product_Id) {
        this.product_Id = product_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct_Type() {
        return product_Type;
    }

    public void setProduct_Type(String product_Type) {
        this.product_Type = product_Type;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return "Product{" +
                " product_Id= " + product_Id +
                " name= '" + name + '\'' +
                " product_Type= '" + product_Type + '\'' +
                " percentage= " + percentage +
                " price= " + price +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        final Product other = (Product) o;
        if (this.product_Id != other.product_Id)
        {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;

    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 89 * hash + this.product_Id;
        hash = 89 * hash + Objects.hashCode(this.name);
        return hash;
    }
}

