package com.platzi.market99.domain;

public class PurchaseItem {

    private int productId;
    private int quantity;
    private double total;
    private boolean avtive;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isAvtive() {
        return avtive;
    }

    public void setAvtive(boolean avtive) {
        this.avtive = avtive;
    }
}
