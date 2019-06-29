package cn.itcast.service.impl;

import cn.itcast.domain.Trade;
import cn.itcast.mapper.TradeMapper;
import cn.itcast.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private TradeMapper mapper;
    @Override
    public List<Trade> findByDate(Date begin, Date end, int AccountID) {
        return mapper.findByDate(begin,end,AccountID);
    }
}
