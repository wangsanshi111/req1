package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.domain.ResultInfo;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService service;

    @RequestMapping("/login")
    @ResponseBody
    public ResultInfo login(Account login, HttpSession session) {
        Account account = service.findByIdAndPassword(login);
        ResultInfo<Account> Info = new ResultInfo<>();
        if (account == null) {
            Info.setFlag(false);
            Info.setMsg("用户ID或密码错误");
        } else {
            Info.setFlag(true);
            session.setAttribute("account", account);
        }
        return Info;
    }

    @RequestMapping("/checkLogin")
    @ResponseBody
    public Account checkLogin(HttpSession session) {
        return (Account) session.getAttribute("account");
    }

    @RequestMapping("/remaining")
    @ResponseBody
    public Account remaining(HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        if (account != null) {
            return service.findByIdAndPassword(account);
        }
        return null;
    }

    @RequestMapping("/trade")
    @ResponseBody
    public ResultInfo trade(int toAccountID, double money, HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        Account toAccount = service.findById(toAccountID);
        ResultInfo info = new ResultInfo();
        if (account != null) {
            try {
                service.trans(toAccountID,account.getAccountID(),money);
                info.setFlag(true);
                info.setMsg("成功转账："+money+"\n"+"接收人："+toAccount.getAccountID());
            } catch (Exception e) {
                info.setFlag(false);
                info.setMsg("转账异常，请稍后再试");
                throw new RuntimeException(e.getMessage());
            }
        }else {
            info.setFlag(false);
            info.setMsg("未登陆，请先登录");
        }
        return info;
    }
}
