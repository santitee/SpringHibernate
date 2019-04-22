package db;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BankDao {
    public final static Logger logger = LogManager.getLogger(BankDao.class);

    public static String openAccount(Person person) {
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        Transaction transObj = sessionObj.beginTransaction();
        sessionObj.save(person);
        transObj.commit();
        sessionObj.close();
        logger.info("Successfully Created " + person.toString());
        return person.getBankAccount().getAccountNo();
    }

    @SuppressWarnings("unchecked")
    public static List<Person> getAllPeople() {
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        List<Person> people = sessionObj.createQuery("FROM Person").list();
        sessionObj.close();
        logger.info("Person Records Available In Database Are?= " + people.size());
        return people;
    }

    public static void updateBankAccount(BankAccount bankAccount) {
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        Transaction transObj = sessionObj.beginTransaction();
        BankAccount bankAccountObj = (BankAccount) sessionObj.load(BankAccount.class, bankAccount.getAccountNo());
        bankAccountObj.setBalance(bankAccount.getBalance());
        sessionObj.update(bankAccountObj);
        transObj.commit();
        sessionObj.close();
        logger.info("Bank Account Record Is Successfully Updated!= " + bankAccountObj.toString());
    }

    public static void updatePerson(Person person) {
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        Transaction transObj = sessionObj.beginTransaction();
        Person personObj = (Person) sessionObj.load(Person.class, person.getPersonId());
        personObj.setStatus(person.getStatus());
        personObj.setFullName(person.getFullName());
        sessionObj.update(personObj);
        transObj.commit();
        sessionObj.close();
        logger.info("Person Is Successfully Updated!= " + personObj.toString());
    }

    public static Person findPersonById(Person person) {
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        Person personObj = (Person) sessionObj.load(Person.class,
                new PersonId(person.getPersonId(), person.getBankAccount().getAccountNo()));
        sessionObj.close();
        return personObj;
    }

    public static void deletePerson(Person person) {
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        Transaction transObj = sessionObj.beginTransaction();
        Person personObj = findPersonById(person);
        sessionObj.delete(personObj);
        transObj.commit();
        sessionObj.close();
        logger.info("Successfully Record Is Successfully Deleted!=  " + person.toString());
    }

}
