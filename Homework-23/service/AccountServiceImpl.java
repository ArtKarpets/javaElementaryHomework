package service;

import dao.AccountDao;
import dao.AccountDaoImpl;
import model.Account;

public class AccountServiceImpl implements AccountService {

    @Override
    public void save(Account account) {
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.save(account);
    }

    @Override
    public void delete(Account account) {
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.delete(account);
    }

    @Override
    public void update(Account account) {
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.update(account);
    }

    @Override
    public Account getById(int id) {
        AccountDao accountDao = new AccountDaoImpl();
        return accountDao.getById(id);
    }
}

