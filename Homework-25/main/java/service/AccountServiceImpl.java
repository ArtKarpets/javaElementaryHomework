package service;

import dao.AccountDao;
import dao.AccountDaoImpl;
import model.Account;
import org.apache.log4j.Logger;

public class AccountServiceImpl implements AccountService {
    Logger logger = Logger.getLogger(ClientServiceImpl.class);

    @Override
    public void save(Account account) {
        logger.debug(account.toString());
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.save(account);
    }

    @Override
    public void delete(Account account) {
        logger.debug(account.toString());
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.delete(account);
    }

    @Override
    public void update(Account account) {
        logger.debug(account.toString());
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.update(account);
    }

    @Override
    public Account getById(int id) {
        logger.debug(String.format("AccountServiceImpl.getById : ", id));
        AccountDao accountDao = new AccountDaoImpl();
        return accountDao.getById(id);
    }
}

