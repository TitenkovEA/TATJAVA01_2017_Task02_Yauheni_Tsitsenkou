package com.epam.at.sportshop.beans;

/**
 * Represents information model about SportEquipment.
 * Contains category, title and price of product.
 *
 * @author Eugeny Titenkov
 */
public class SportEquipment {
    private String category;
    private String title;
    private int price;

    public SportEquipment(String category, String title, int price) {
        this.category = category;
        this.title = title;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        return "SportEquipment{" +
                "category='" + category + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SportEquipment that = (SportEquipment) o;

        return (
                price == that.price &&
                (category != null ? category.equals(that.category) : that.category == null) &&
                (title != null ? title.equals(that.title) : that.title == null)
        );
    }

    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }
}
