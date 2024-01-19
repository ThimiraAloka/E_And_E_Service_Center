package bo.custom;

import bo.SuperBo;
import dto.UserDto;

import java.sql.SQLException;
import java.util.List;

public interface UserBo extends SuperBo {
    boolean saveUser(UserDto dto) throws SQLException, ClassNotFoundException;
    boolean updateUser(UserDto dto) throws SQLException, ClassNotFoundException;
    boolean deleteUser(String email) throws SQLException, ClassNotFoundException;
    List<UserDto> allUser() throws SQLException, ClassNotFoundException;
    boolean isValidPassCode(String code);

    boolean isValidPassword(String code);

}
