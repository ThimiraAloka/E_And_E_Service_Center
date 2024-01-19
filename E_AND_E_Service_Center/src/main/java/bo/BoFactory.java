package bo;

import bo.custom.impl.CustomerBoImpl;
import bo.custom.impl.ItemBoImpl;
import bo.custom.impl.UserBoImpl;
import dao.util.BoType;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory() {
    }

    public static BoFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BoFactory();
        }
        return boFactory;
    }

    public <T extends SuperBo>T getBo(BoType type){
        switch (type){
            case USER: return (T) new UserBoImpl();
            case ITEM: return (T) new ItemBoImpl();
            case CUSTOMER: return (T) new CustomerBoImpl();

        }
        return null;
    }
}
