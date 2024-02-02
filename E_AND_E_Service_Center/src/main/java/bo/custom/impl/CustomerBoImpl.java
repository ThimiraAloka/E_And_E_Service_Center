package bo.custom.impl;

import bo.custom.CustomerBo;
import dao.DaoFactory;
import dao.custom.CustomerDao;
import dao.custom.impl.CustomerDaoImpl;
import dao.util.DaoType;
import dto.CustomerDto;
import entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBoImpl implements CustomerBo {

    private CustomerDao customerDao = new CustomerDaoImpl();
    @Override
    public boolean saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return customerDao.save(new Customer(
                dto.getId(),
                dto.getName(),
                dto.getContact(),
                dto.getEmail()
        ));
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return customerDao.update(new Customer(
                dto.getId(),
                dto.getName(),
                dto.getContact(),
                dto.getEmail()
        ));
    }

    @Override
    public boolean deleteCustomer(String customerCode) throws SQLException, ClassNotFoundException {
        return customerDao.delete(customerCode);
    }

    @Override
    public List<CustomerDto> allCustomers() throws SQLException, ClassNotFoundException {
        List<Customer> entityList = customerDao.getAll();
        List<CustomerDto> list = new ArrayList<>();
        for (Customer customer:entityList) {
            list.add(new CustomerDto(
                    customer.getId(),
                    customer.getName(),
                    customer.getContact(),
                    customer.getEmail()
            ));
        }
        return list;
    }

    @Override
    public String generateId() throws SQLException, ClassNotFoundException {
         try {
                CustomerDto dto =customerDao.lastCustomer();
                if (dto!=null){
                    String id = customerDao.lastCustomer().getId();
                    int num = Integer.parseInt(id.split("[C]")[1]);
                    num++;
                    return String.format("C%03d", num);
                }else{
                    return "C001";
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
         }

    }
}
