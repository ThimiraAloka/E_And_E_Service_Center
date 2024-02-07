package bo.custom.impl;

import bo.custom.ItemBo;
import dao.DaoFactory;
import dao.custom.CustomerDao;
import dao.custom.ItemDao;
import dao.custom.impl.CustomerDaoImpl;
import dao.custom.impl.ItemDaoImpl;
import dao.util.DaoType;
import dto.CustomerDto;
import dto.ItemDto;
import entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBoImpl implements ItemBo {

    private ItemDao itemDao = new ItemDaoImpl();


    @Override
    public boolean saveItem(ItemDto dto) throws SQLException, ClassNotFoundException {
        return itemDao.save(new Item(
                dto.getItemCode(),
                dto.getItemName(),
                dto.getCategory()
        ));
    }

    @Override
    public boolean updateItem(ItemDto dto) throws SQLException, ClassNotFoundException {
        return itemDao.update(new Item(
                dto.getItemCode(),
                dto.getItemName(),
                dto.getCategory()
        ));
    }

    @Override
    public boolean deleteItem(String itemCode) throws SQLException, ClassNotFoundException {
        return itemDao.delete(itemCode);
    }

    @Override
    public List<ItemDto> allItems() throws SQLException, ClassNotFoundException {
        List<Item> entityList = itemDao.getAll();
        List<ItemDto> list = new ArrayList<>();
        for (Item item:entityList) {
            list.add(new ItemDto(
                    item.getItemCode(),
                    item.getItemName(),
                    item.getCategory()
            ));
        }
        return list;
    }

    @Override
    public String generateId() throws SQLException, ClassNotFoundException, NullPointerException {
        try {
            ItemDto dto =itemDao.lastItem();
            if (dto!=null){
                String id = itemDao.lastItem().getItemCode();
                int num = Integer.parseInt(id.split("[I]")[1]);
                num++;
                return String.format("I%03d", num);
            }else{
                return "I001";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
