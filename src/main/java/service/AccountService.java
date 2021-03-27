package service;

import database.Database;
import entity.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountService {

    private static final Connection connect = Database.getConnection();
    private static final String SELECT_ALL_ACCOUNT_QUERY = "SELECT * FROM accounts ";
    private static final String SAVE_ACCOUNT_QUERY = "INSERT INTO accounts (client_id,number,value) VALUES (?,?,?)";
    private static final String UPDATE_ACCOUNT_QUERY = "UPDATE accounts SET client_id=?, number=?, value=? WHERE id=? ";
    private static final String DELETE_ACCOUNT_QUERY = "DELETE FROM accounts WHERE id=?";
    private static final String GET_NUMBER_QUERY = "SELECT number FROM accounts WHERE value > ?";

    public List<Account> getAll() {
        List<Account> accounts = new ArrayList<>();
        try (Statement statement = connect.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_ACCOUNT_QUERY);
            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setClientId(resultSet.getInt("client_id"));
                account.setNumber(resultSet.getString("number"));
                account.setValue(resultSet.getDouble("value"));
                accounts.add(account);
            }
            connect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public void save(Account account) {
        try (PreparedStatement preparedStatement = connect.
                     prepareStatement(SAVE_ACCOUNT_QUERY)) {
            preparedStatement.setInt(1, account.getClientId());
            preparedStatement.setString(2, account.getNumber());
            preparedStatement.setDouble(3, account.getValue());
            preparedStatement.execute();
            connect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Account account) {
        try (PreparedStatement preparedStatement = connect.
                     prepareStatement(UPDATE_ACCOUNT_QUERY)) {
            preparedStatement.setInt(1, account.getClientId());
            preparedStatement.setString(2, account.getNumber());
            preparedStatement.setDouble(3, account.getValue());
            preparedStatement.setInt(6, account.getId());
            preparedStatement.execute();
            connect.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(Account account) {
        try (PreparedStatement preparedStatement = connect.
                     prepareStatement(DELETE_ACCOUNT_QUERY)) {
            preparedStatement.setInt(1, account.getId());
            preparedStatement.execute();
            connect.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Account> getNumberByValue(int value) {
        List<Account> accounts = new ArrayList<>();
        try (PreparedStatement preparedStatement = connect.
                prepareStatement(GET_NUMBER_QUERY)) {
            preparedStatement.setString(1,Integer.toString(value) );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Account account = new Account();
                account.setNumber(resultSet.getString("number"));
                accounts.add(account);
            }
            connect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }
}


