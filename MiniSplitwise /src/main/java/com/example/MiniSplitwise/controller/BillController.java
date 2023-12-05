package com.example.MiniSplitwise.controller;

import com.example.MiniSplitwise.service.BillService;
import com.example.MiniSplitwise.dto.BillDTO;
import com.example.MiniSplitwise.model.Bill;
import com.example.MiniSplitwise.Helper.BillItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.io.*;

@RestController
@RequestMapping("/Bills")
public class BillController {
    private final BillService billService;
    BillController(BillService billService){
        this.billService = billService;
    }

    @PostMapping("/addBills")
    public ResponseEntity<Map<UUID, String>> addBills (@RequestBody BillDTO billDTO) {
        // Assuming yourService.addDebitors returns a Map<UUID, String>
        System.out.println(billDTO.getAmount());
        Map<UUID, String> insertedData = new HashMap<>();
        UUID result = billService.addBills(billDTO);
        insertedData.put(result, "Added to Bills");
        List<BillItem> bills = billDTO.getDebitors();
        for(int i=0; i<bills.size(); i++){
            System.out.println(bills.get(i).getUserId());
            System.out.println(bills.get(i).getAmount());
        }
        List<UUID> maps = billService.addMappings(billDTO, result);
        for(int i=0; i<maps.size(); i++){
            insertedData.put(maps.get(i), "Added to mapping");
        }

        if (insertedData.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok(insertedData);
    }
}
