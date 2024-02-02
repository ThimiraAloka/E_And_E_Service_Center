package dao.custom;

import dao.CrudDao;
import dto.CustomerDto;
import entity.Customer;

import java.sql.SQLException;

public interface CustomerDao extends CrudDao<Customer> {
    CustomerDto searchCustomer(String id) throws SQLException,ClassNotFoundException;
    CustomerDto lastCustomer() throws SQLException,ClassNotFoundException;
}
