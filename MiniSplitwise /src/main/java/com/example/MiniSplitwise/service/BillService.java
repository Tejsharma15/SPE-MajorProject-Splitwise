package com.example.MiniSplitwise.service;

import com.example.MiniSplitwise.dto.BillDTO;
import com.example.MiniSplitwise.model.Bill;
import com.example.MiniSplitwise.model.BillMapping;
import com.example.MiniSplitwise.repository.BillRepository;
import com.example.MiniSplitwise.repository.BillMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import  java.util.*;

@Service
public class BillService {
    private final BillRepository billRepository;
    private final BillMappingRepository billMappingRepository;

    BillService(BillRepository billRepository, BillMappingRepository billMappingRepository){
        this.billRepository = billRepository;
        this.billMappingRepository = billMappingRepository;
    }

    public UUID addBills(BillDTO billDTO) {
        System.out.println("ADDING BILLS");
        Bill bill = billDTO.getBillFromDTO();
        return billRepository.save(bill).getBillId();
    }
    public List<UUID> addMappings(BillDTO billDTO, UUID billId){
        List<UUID> addedMappings = new ArrayList();
        List<BillMapping> maps= billDTO.getBillMappingFromDTO(billId);
        for(int i=0; i<maps.size(); i++){
            UUID insertedId = billMappingRepository.save(maps.get(i)).getUserId();
            System.out.println(insertedId);
            addedMappings.add(insertedId);
        }
        return addedMappings;
    }

    public Optional<Bill> getBillById(UUID id){
        return billRepository.findById(id);
    }

    @Transactional
    public void updateStatusToTrue(UUID entityId) {
        Optional<Bill> billEntity = billRepository.findById(entityId);
        billEntity.ifPresent(entity -> {
            entity.setCompleted(true);
            billRepository.save(entity);
        });
    }
}