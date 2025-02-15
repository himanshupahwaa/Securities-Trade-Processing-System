package com.Himanshu.TradesPostProcessingSystem.repository;

import com.Himanshu.TradesPostProcessingSystem.entity.TradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<TradeEntity, Long> {

    // Custom query methods

    // Find trades by symbol
    List<TradeEntity> findBySymbol(String symbol);

    // Find a trade by its unique tradeId
    TradeEntity findByTradeId(String tradeId);
}
