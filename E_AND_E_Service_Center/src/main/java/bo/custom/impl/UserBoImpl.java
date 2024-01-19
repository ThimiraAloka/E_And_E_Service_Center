package bo.custom.impl;

import bo.custom.UserBo;
import dao.DaoFactory;
import dao.custom.UserDao;
import dao.util.DaoType;
import dto.UserDto;
import entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserBoImpl implements UserBo {
    private UserDao userDao = DaoFactory.getInstance().getDao(DaoType.USER);
    @Override
    public boolean saveUser(UserDto dto) throws SQLException, ClassNotFoundException {
        return userDao.save(new User(
                dto.getEmail(),
                dto.getPassword()
        ));
    }

    @Override
    public boolean updateUser(UserDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteUser(String email) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<UserDto> allUser() throws SQLException, ClassNotFoundException {
        return null;
    }
}
