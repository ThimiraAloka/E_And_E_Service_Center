package dto.tm;

import javafx.scene.control.Button;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemTm {
    private String itemCode;
    private String itemName;
    private String category;
    private Button btn;
    @Override
    public String toString() {
        return "ItemTm{" +
                "itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", category='" + category + '\'' +
                ", btn=" + btn +
                '}';
    }
}
