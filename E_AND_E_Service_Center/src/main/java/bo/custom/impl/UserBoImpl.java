package bo.custom.impl;

import bo.custom.UserBo;
import dao.DaoFactory;
import dao.custom.UserDao;
import dao.util.DaoType;
import dto.UserDto;
import entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class UserBoImpl implements UserBo {
    private UserDao userDao = DaoFactory.getInstance().getDao(DaoType.USER);
    @Override
    public boolean isValidPassCode(String code){
        return  !Objects.equals(code, "e&eAdmin");
    }

    @Override
    public boolean isValidPassword(String passwordhere) {

        Pattern specailCharPatten = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
        Pattern lowerCasePatten = Pattern.compile("[a-z ]");
        Pattern digitCasePatten = Pattern.compile("[0-9 ]");

        boolean isValid = true;

        if (passwordhere.length() < 8) {
            isValid=false;
        }
        if (!specailCharPatten.matcher(passwordhere).find()) {
            isValid=false;
        }
        if (!UpperCasePatten.matcher(passwordhere).find()) {
            isValid=false;
        }
        if (!lowerCasePatten.matcher(passwordhere).find()) {
            isValid=false;
        }
        if (!digitCasePatten.matcher(passwordhere).find()) {
            isValid=false;
        }
        return isValid;
    }

    @Override
    public boolean saveUser(UserDto dto) throws SQLException, ClassNotFoundException {
        return userDao.save(new User(
                dto.getEmail(),
                dto.getPassword(),
                dto.getJobRole()
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
        List<User> entityList = userDao.getAll();
        List<UserDto> list = new ArrayList<>();
        for (User users:entityList) {
            list.add(new UserDto(
                    users.getEmail(),
                    users.getPassword(),
                    users.getJobRole()
            ));
        }
        return list;
    }
}
