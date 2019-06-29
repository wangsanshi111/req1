package cn.itcast.domain;

public class Account {
    private int accountID;
    private String password;
    private double remaining;

    @Override
    public String toString() {
        return "account{" +
                "accountID=" + accountID +
                ", password='" + password + '\'' +
                ", remaining=" + remaining +
                '}';
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getRemaining() {
        return remaining;
    }

    public void setRemaining(double remaining) {
        this.remaining = remaining;
    }
}