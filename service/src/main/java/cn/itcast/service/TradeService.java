package cn.itcast.service;

import cn.itcast.domain.Trade;

import java.util.Date;
import java.util.List;

public interface TradeService {

    List<Trade> findByDate(Date begin,Date end,int AccountID);
}
