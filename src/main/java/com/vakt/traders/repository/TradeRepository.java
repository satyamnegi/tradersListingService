package com.vakt.traders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vakt.traders.entity.TradeEntity;

@Repository
public interface TradeRepository extends JpaRepository<TradeEntity,Long>{

}
