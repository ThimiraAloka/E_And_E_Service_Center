package bo.custom.impl;

import bo.custom.CustomerBo;
import dto.CustomerDto;

import java.sql.SQLException;
import java.util.List;

public class CustomerBoImpl implements CustomerBo {
    @Override
    public boolean saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteCustomer(String customerCode) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<CustomerDto> allCustomers() throws SQLException, ClassNotFoundException {
        return null;
    }
}
