package cn.itcast.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Trade {
/*
    accountID` VARCHAR(50) DEFAULT NULL,
  `tradetype` VARCHAR(10) DEFAULT NULL,
  `trademoney` DOUBLE(7,2) NOT NULL,
  `tradetime` DATE NOT NULL,
  `tradedigest` VARCHAR(1024) DEFAULT NULL,
 */
    private int id;
    private int accountID;

    private String tradetype;

    private double trademoney;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tradetime;

    private String tradedigest;
    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                "accountID=" + accountID +
                ", tradetype='" + tradetype + '\'' +
                ", trademoney=" + trademoney +
                ", tradetime=" + tradetime +
                ", tradedigest='" + tradedigest + '\'' +
                '}';
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTradetype() {
        return tradetype;
    }

    public void setTradetype(String tradetype) {
        this.tradetype = tradetype;
    }

    public double getTrademoney() {
        return trademoney;
    }

    public void setTrademoney(double trademoney) {
        this.trademoney = trademoney;
    }

    public Date getTradetime() {
        return tradetime;
    }

    public void setTradetime(Date tradetime) {
        this.tradetime = tradetime;
    }

    public String getTradedigest() {
        return tradedigest;
    }

    public void setTradedigest(String tradedigest) {
        this.tradedigest = tradedigest;
    }
}
