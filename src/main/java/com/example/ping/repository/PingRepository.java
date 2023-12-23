package com.example.ping.repository;

import com.example.ping.dto.PingDto;
import com.example.ping.entity.Ping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PingRepository extends JpaRepository<Ping,Long> {

    @Query("SELECT p FROM Ping p " +
            "WHERE (:domainKeyword IS NULL OR p.domain = :domainKeyword) " +
            "AND (:ipAddressKeyword IS NULL OR p.ipAddress = :ipAddressKeyword) " +
            "AND p.checkDate BETWEEN :startDate AND :endDate " +
            "AND p.testStatus = :testStatus")
    List<Ping> searchByParameters(
            @Param("domainKeyword") String domainKeyword,
            @Param("ipAddressKeyword") String ipAddressKeyword,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate,
            @Param("testStatus") int testStatus);

    Page<Ping> findAll(Pageable pageable);

}
