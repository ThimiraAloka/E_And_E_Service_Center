package bo.custom.impl;

import bo.custom.UserBo;
import dto.UserDto;

import java.sql.SQLException;
import java.util.List;

public class UserBoImpl implements UserBo {
    @Override
    public boolean saveUser(UserDto dto) throws SQLException, ClassNotFoundException {
        return false;
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
