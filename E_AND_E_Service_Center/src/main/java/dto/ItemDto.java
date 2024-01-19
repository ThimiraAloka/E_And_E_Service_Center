package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ItemDto {
    private String itemCode;
    private String itemName;
    private String category;


}
