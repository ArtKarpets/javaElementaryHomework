package dao;

import model.Status;

public interface StatusDao {

    void save(Status status);

    void delete(Status status);

    void update(Status status);

    Status getById(int id);
}
