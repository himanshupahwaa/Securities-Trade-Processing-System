package com.Himanshu.TradesPostProcessingSystem.service;

import com.Himanshu.TradesPostProcessingSystem.entity.TradeEntity;
import com.Himanshu.TradesPostProcessingSystem.model.Trade;
import com.Himanshu.TradesPostProcessingSystem.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TradeConsumerService {

    @Autowired
    private TradeRepository tradeRepository;

    @KafkaListener(topics = "trades", groupId = "trade-group", containerFactory = "kafkaListenerContainerFactory")
    public void consumeTrade(Trade trade) {
        System.out.println("✅ Received Trade: " + trade);

        // Convert Trade model to TradeEntity (for database storage)
        TradeEntity tradeEntity = new TradeEntity(trade.getTradeId(), trade.getSymbol(), trade.getQuantity(), trade.getPrice());

        // Save trade to PostgreSQL
        tradeRepository.save(tradeEntity);

        System.out.println("✅ Trade stored in database: " + tradeEntity);
    }
}
