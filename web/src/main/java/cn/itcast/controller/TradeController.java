package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.domain.ResultInfo;
import cn.itcast.domain.Trade;
import cn.itcast.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/trade")
public class TradeController {
    @Autowired
    private TradeService service;
    @RequestMapping("/tradeLog")
    @ResponseBody
    public ResultInfo<Trade> tradeLog(@DateTimeFormat(pattern = "yyyy-MM-dd")Date begin, @DateTimeFormat(pattern = "yyyy-MM-dd")Date end, HttpSession session){
        ResultInfo<Trade> info = new ResultInfo<>();
        Account account = (Account) session.getAttribute("account");
        if (account != null) {
            List<Trade> tradeList = service.findByDate(begin, end, account.getAccountID());
            info.setFlag(true);
            info.setList(tradeList);
        }else {
            info.setFlag(false);
            info.setMsg("查询异常，请稍后再试");
        }
        return info;
    }
}
