package cn.itcast.service.impl;

import cn.itcast.domain.Account;
import cn.itcast.domain.Trade;
import cn.itcast.mapper.AccountMapper;
import cn.itcast.mapper.TradeMapper;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account findByIdAndPassword(Account account) {
        return accountMapper.findByIdAndPassword(account);
    }

    @Autowired
    private TradeMapper tradeMapper;

    @Override
    public void trans(int transInID, int transOutID, double money) {
        accountMapper.transIn(transInID,money);
        accountMapper.transOut(transOutID,money);
        Trade trade = new Trade();
        trade.setAccountID(transOutID);
        trade.setTrademoney(money);
        trade.setTradetime(new Date());
        trade.setTradetype("转出");
        trade.setTradedigest("接收账号："+transInID);
        tradeMapper.save(trade);
    }

    @Override
    public Account findById(int accountID) {
        return accountMapper.findById(accountID);
    }
}
