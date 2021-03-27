package service;

import database.Database;
import entity.Account;
import entity.Client;
import entity.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientService {

    private static final Connection connect = Database.getConnection();
    private static final String SELECT_ALL_CLIENT_QUERY = "SELECT * FROM clients";
    private static final String SAVE_CLIENT_QUERY = "INSERT INTO clients (name,email,phone,age,about) VALUES (?,?,?,?,?)";
    private static final String UPDATE_CLIENT_QUERY = "UPDATE clients SET name = ?, email=?, phone=?, age=?, about=? WHERE id=? ";
    private static final String DELETE_CLIENT_QUERY = "DELETE FROM clients WHERE id=?";
    private static final String SELECT_BY_PHONE_QUERY = "SELECT * FROM clients WHERE phone=?";
    private static final String SELECT_CLIENT_JOIN_ACCOUNT_QUERY = "SELECT * FROM clients c INNER JOIN accounts a ON c.id = a.client_id ";
    private static final String SELECT_CLIENT_JOIN_STATUS_QUERY = "SELECT c.name, c.email, s.alias FROM clients c INNER JOIN client_status cs ON c.id = cs.client_id INNER JOIN statuses s ON cs.status_id = s.id WHERE age>18 ";


    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        try (Statement statement = connect.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CLIENT_QUERY);
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getString("phone"));
                client.setAge(resultSet.getInt("age"));
                client.setAbout(resultSet.getString("about"));
                clients.add(client);
            }
            connect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public void save(Client client) {
        try (PreparedStatement preparedStatement = connect.
                prepareStatement(SAVE_CLIENT_QUERY)) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getEmail());
            preparedStatement.setString(3, client.getPhone());
            preparedStatement.setInt(4, client.getAge());
            preparedStatement.setString(5, client.getAbout());
            preparedStatement.execute();
            connect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Client client) {
        try (PreparedStatement preparedStatement = connect.
                prepareStatement(UPDATE_CLIENT_QUERY)) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getEmail());
            preparedStatement.setString(3, client.getPhone());
            preparedStatement.setInt(4, client.getAge());
            preparedStatement.setString(5, client.getAbout());
            preparedStatement.setInt(6, client.getId());
            preparedStatement.execute();
            connect.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(Client client) {
        try (PreparedStatement preparedStatement = connect.
                prepareStatement(DELETE_CLIENT_QUERY)) {
            preparedStatement.setInt(1, client.getId());
            preparedStatement.execute();
            connect.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Client> getByPhone(String phone) {
        List<Client> clients = new ArrayList<>();
        try (PreparedStatement preparedStatement = connect.
                prepareStatement(SELECT_BY_PHONE_QUERY)) {
            preparedStatement.setString(1, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getString("phone"));
                client.setAge(resultSet.getInt("age"));
                client.setAbout(resultSet.getString("about"));
                clients.add(client);
            }
            connect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public Map<Client, Account> getClientJoinAccount() {
        HashMap<Client, Account> clientsAccounts = new HashMap<>();
        try (PreparedStatement preparedStatement = connect.
                prepareStatement(SELECT_CLIENT_JOIN_ACCOUNT_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Client client = new Client();
                Account account = new Account();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getString("phone"));
                client.setAge(resultSet.getInt("age"));
                client.setAbout(resultSet.getString("about"));
                account.setId(resultSet.getInt("id"));
                account.setClientId(resultSet.getInt("client_id"));
                account.setNumber(resultSet.getString("number"));
                account.setValue(resultSet.getDouble("value"));
                clientsAccounts.put(client, account);
            }
            connect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientsAccounts;
    }

    public Map<Client, Status> getClientJoinStatus() {
        HashMap<Client, Status> clientsStatuses = new HashMap<>();
        try (PreparedStatement preparedStatement = connect.
                prepareStatement(SELECT_CLIENT_JOIN_STATUS_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Client client = new Client();
                Status status = new Status();
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                status.setAlias(resultSet.getString("alias"));
                clientsStatuses.put(client, status);
            }
            connect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientsStatuses;
    }
}

