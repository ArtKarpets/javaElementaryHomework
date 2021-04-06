package dao;

import model.Account;


public interface AccountDao {

    void save(Account account);

    void delete(Account account);

    void update(Account account);

    Account getById(int id);
}
