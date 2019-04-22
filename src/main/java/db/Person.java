package db;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person")
@IdClass(PersonId.class)
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "person_id", unique = true)
    private String personId;
    @Id
    @Column(name = "account_no")
    private String accountNo;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = BankAccount.class)
    @JoinColumn(name = "account_no", insertable = false, updatable = false)
    private BankAccount bankAccount;

    @Column(name = "full_name")
    private String fullName;
    @Column(name = "status")
    private Integer status;

    public Person() {
    }

    public Person(String personId, BankAccount bankAccount, String fullName, Integer status) {
        this.personId = personId;
        this.bankAccount = bankAccount;
        this.accountNo = bankAccount.getAccountNo();
        this.fullName = fullName;
        this.status = status;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[FULL_NAME=");
        sb.append(fullName);
        sb.append(", STATUS=");
        sb.append(status);
        sb.append(", ACCOUNT_NO=");
        sb.append(bankAccount.getAccountNo());
        sb.append(", BALANCE=");
        sb.append(bankAccount.getBalance().doubleValue());
        sb.append("]");
        return sb.toString();
    }
}
