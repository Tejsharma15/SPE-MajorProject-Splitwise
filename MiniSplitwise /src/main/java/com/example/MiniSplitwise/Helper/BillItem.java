package com.example.MiniSplitwise.Helper;
import java.util.UUID;

public class BillItem {
    private UUID userId;
    private Float amount;

    public BillItem(UUID userId, Float amount) {
        this.userId = userId;
        this.amount = amount;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
