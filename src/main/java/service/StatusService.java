package service;

import database.Database;
import entity.Status;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatusService {
    private static final String SELECT_ALL_STATUS_QUERY = "SELECT * FROM statuses";
    private static final String SAVE_STATUS_QUERY = "INSERT INTO statuses (alias,description) VALUES (?,?)";
    private static final String UPDATE_STATUS_QUERY = "UPDATE statuses SET alias=?, description=? WHERE id=? ";
    private static final String DELETE_STATUS_QUERY = "DELETE FROM statuses WHERE id=?";

    public List<Status> getAll() {
        List<Status> statuses = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_STATUS_QUERY);
            while (resultSet.next()) {
                Status status = new Status();
                status.setId(resultSet.getInt("id"));
                status.setAlias(resultSet.getString("alias"));
                status.setDescriptions(resultSet.getString("description"));
                statuses.add(status);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statuses;
    }

    public void save(Status status) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(SAVE_STATUS_QUERY)) {
            preparedStatement.setString(1, status.getAlias());
            preparedStatement.setString(2, status.getDescriptions());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Status status) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(UPDATE_STATUS_QUERY)) {
            preparedStatement.setString(1, status.getAlias());
            preparedStatement.setString(2, status.getDescriptions());
            preparedStatement.setInt(6, status.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(Status status) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(DELETE_STATUS_QUERY)) {
            preparedStatement.setInt(1, status.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}



