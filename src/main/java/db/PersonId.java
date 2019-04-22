package db;

import java.io.Serializable;

public class PersonId implements Serializable {

    private static final long serialVersionUID = 1L;
    private String personId;
    private String accountNo;

    public PersonId() {
    }

    public PersonId(String personId, String accountNo) {
        this.personId = personId;
        this.accountNo = accountNo;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setBankAccount(String accountNo) {
        this.accountNo = accountNo;
    }
}
