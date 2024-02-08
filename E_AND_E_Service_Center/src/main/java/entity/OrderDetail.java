package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
@Entity
public class OrderDetail {
    @EmbeddedId
    private OrderDetailsKey id;

    @ManyToOne
    @MapsId("itemCode")
    @JoinColumn(name = "item_code")
    AdditionalItem additionalItem;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    Orders orders;

    public OrderDetail(OrderDetailsKey id, AdditionalItem additionalItem, Orders orders) {
        this.id = id;
        this.additionalItem = additionalItem;
        this.orders = orders;
    }
    public String getOrderId() {
        return id.getOrderId();
    }
    public String getItemCode() {
        return id.getItemCode();
    }

    private int qty;
    private  double price;
}
