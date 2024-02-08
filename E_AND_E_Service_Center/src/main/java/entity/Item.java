package entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Item {

    @Id
    private String itemCode;
    private String itemName;
    private String category;
    public Item(String itemCode, String itemName, String category) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.category = category;
    }
}
