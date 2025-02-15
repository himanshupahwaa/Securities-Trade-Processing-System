package com.Himanshu.TradesPostProcessingSystem.model;

import java.util.UUID;

public class Trade {
    private String tradeId;
    private String symbol;
    private int quantity;
    private double price;

    // ✅ No-argument constructor required for JSON deserialization
    public Trade() {
    }

    // ✅ Parameterized constructor for creating new trade instances
    public Trade(String symbol, int quantity, double price) {
        this.tradeId = UUID.randomUUID().toString(); // Generate a unique ID
        this.symbol = symbol;
        this.quantity = quantity;
        this.price = price;
    }

    // ✅ Getters and Setters
    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // ✅ toString() method for debugging
    @Override
    public String toString() {
        return "Trade{" +
                "tradeId='" + tradeId + '\'' +
                ", symbol='" + symbol + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
