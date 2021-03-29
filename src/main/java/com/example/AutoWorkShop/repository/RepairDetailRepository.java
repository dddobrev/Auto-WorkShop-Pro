package com.example.AutoWorkShop.repository;

import com.example.AutoWorkShop.domain.entities.RepairDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairDetailRepository extends JpaRepository<RepairDetail, Long> {
    List<RepairDetail> findRepairDetailByRepairId(Long repairId);
}
