package db;

import java.math.BigDecimal;
import java.sql.SQLException;

public class TestDB {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        BankAccount ba =  new BankAccount();
        ba.setAccountNo("Acc-2");
        ba.setBalance(BigDecimal.valueOf(500.00));
        ba.setStatus(1);
        ba.setPersonId("CUST-2");
        //BankDao.openAccount(ba);

        //ba.setBalance(BigDecimal.valueOf(1000.00));
        //BankDao.updateRecord(ba);

        //ba.setBalance(BigDecimal.valueOf(800.00));
        //BankDao.updateRecord(ba);

        //ba.setStatus(0);
        //BankDao.updateRecord(ba);
        
        //ba.setAccountNo("Acc-1");
        BankService bs = new BankService();
        //bs.deposit(ba, BigDecimal.valueOf(500000.00));

        bs.withdraw(ba, BigDecimal.valueOf(100000.00));

 
    }
}