package service;

import model.Status;

public interface StatusService {

    void save(Status status);

    void delete(Status status);

    void update(Status status);

    Status getById(int id);
}
