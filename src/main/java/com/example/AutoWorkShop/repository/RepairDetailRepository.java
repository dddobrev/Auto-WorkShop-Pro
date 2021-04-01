package com.example.AutoWorkShop.repository;

import com.example.AutoWorkShop.domain.entities.RepairDetail;
import com.example.AutoWorkShop.view.RepairDetailsViewModel;
import com.example.AutoWorkShop.view.RepairViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairDetailRepository extends JpaRepository<RepairDetail, Long> {

//    @Query("SELECT SUM (c.copies)  FROM AlbumEntity c" )
//    @Query("SELECT r.repair.repairDetails FROM repair_details r order by r.repair.id asc")
    List<RepairDetailsViewModel> findAllRepairDetailByRepairId(Long repairId);
}
