package InventoryPackage;

public class products {
    private int product_id;
    private String product_name;
    private float price;
    private int stock;

    public products(int product_id, String product_name, float price, int stock) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.stock = stock;
    }

    public int getProductId() {
        return product_id;
    }

    public String getProductName() {
        return product_name;
    }

    public float getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setProductName(String product_name) {
        this.product_name = product_name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

   
    public String toString() {
        return "Product [ID=" + product_id + ", Name=" + product_name + ", Price=" + price + ", Stock=" + stock + "]";
    }
}
