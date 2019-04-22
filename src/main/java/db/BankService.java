package db;

import java.math.BigDecimal;
import java.sql.SQLException;

public class BankService {

    public void openAccount(BankAccount ba) {
        BankDao.openAccount(ba);
    }

    public void closeAccount(BankAccount ba) {
        BankDao.updateRecord(ba);
    }

	public void deposit(BankAccount ba, BigDecimal amount) throws ClassNotFoundException, SQLException {
        BankAccount bankAccount = BankDao.findRecordById(ba.getAccountNo());
        BigDecimal balance =  bankAccount.getBalance();
        balance = balance.add(amount);
        bankAccount.setBalance(balance);
        //ba.setBalance(ba.getBalance().add(amount));
        BankDao.updateRecord(bankAccount);
	}
	
	public void withdraw(BankAccount ba, BigDecimal amount) throws ClassNotFoundException, SQLException {
        BankAccount bankAccount = BankDao.findRecordById(ba.getAccountNo());
        BigDecimal balance =  bankAccount.getBalance();
        balance = balance.subtract(amount);
        bankAccount.setBalance(balance);
        //ba.setBalance(ba.getBalance().subtract(amount));
        BankDao.updateRecord(bankAccount);
    }

}