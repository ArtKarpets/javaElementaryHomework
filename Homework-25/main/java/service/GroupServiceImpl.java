package service;

import dao.GroupDao;
import dao.GroupDaoImpl;
import model.Group;
import org.apache.log4j.Logger;

public class GroupServiceImpl implements GroupService {
    Logger logger = Logger.getLogger(ClientServiceImpl.class);

    @Override
    public void save(Group group) {
        logger.debug(group.toString());
        GroupDao clientDao = new GroupDaoImpl();
        clientDao.save(group);
    }
}
