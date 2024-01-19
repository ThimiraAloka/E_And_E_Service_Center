package dto.tm;

import javafx.scene.control.Button;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CustomerTm {
    private String customerCode;
    private String customerName;
    private int customerContact;
    private String customerEmail;
    private Button btn;

    @Override
    public String toString() {
        return "CustomerTm{" +
                "customerCode='" + customerCode + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerContact='" + customerContact + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", btn=" + btn +
                '}';
    }
}
