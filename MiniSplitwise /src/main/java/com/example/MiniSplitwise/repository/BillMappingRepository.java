package com.example.MiniSplitwise.repository;

import com.example.MiniSplitwise.model.BillMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface BillMappingRepository extends JpaRepository<BillMapping, UUID> {
    // You can add custom query methods if needed

}

