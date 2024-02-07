package dao.custom;

import dao.CrudDao;
import dto.CustomerDto;
import dto.ItemDto;
import entity.Item;

import java.sql.SQLException;

public interface ItemDao extends CrudDao<Item> {
    ItemDto searchItem(String itemCode)throws SQLException,ClassNotFoundException;
    ItemDto lastItem() throws SQLException,ClassNotFoundException;

}
