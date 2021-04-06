package service;

import model.Account;

public interface AccountService {
    void save(Account account);

    void delete(Account account);

    void update(Account account);

    Account getById(int id);
}
