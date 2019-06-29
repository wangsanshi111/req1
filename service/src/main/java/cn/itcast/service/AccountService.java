package cn.itcast.service;

import cn.itcast.domain.Account;

public interface AccountService {


    Account findByIdAndPassword(Account account);

    void trans (int transInID,int transOutID,double money);

    Account findById(int accountID);
}
