package com.example.MiniSplitwise.dto;
import com.example.MiniSplitwise.model.Bill;
import com.example.MiniSplitwise.model.BillMapping;
import com.example.MiniSplitwise.Helper.BillItem;
import lombok.Data;

import java.util.*;

public class BillDTO{
    private UUID billId;
    private String billName;
    private UUID creditorId;
    private Float amount;
    private List<BillItem> debitors;

    public Bill getBillFromDTO(){
        Bill bill = new Bill();
        bill.setBillId(billId);
        bill.setBillName(billName);
        bill.setCreditorId(creditorId);
        bill.setAmount(amount);
        System.out.println(amount);
        return bill;
    }
    public List<BillMapping> getBillMappingFromDTO(UUID bId){
        List<BillMapping> maps = new ArrayList<>();
        for(int i=0; i<debitors.size(); i++){
            BillMapping billMapping = new BillMapping();
            UUID userId = debitors.get(i).getUserId();
            billMapping.setUserId(userId);
            billMapping.setBillId(bId);
            Float amount = debitors.get(i).getAmount();
            billMapping.setDueAmount(amount);
            maps.add(billMapping);
        }
        return maps;
    }

    public Float getAmount() {
        return amount;
    }

    public List<BillItem> getDebitors(){
        return debitors;
    }

    public UUID getBillId() {
        return billId;
    }

    public String getBillName() {
        return billName;
    }

    public UUID getCreditorId() {
        return creditorId;
    }
}