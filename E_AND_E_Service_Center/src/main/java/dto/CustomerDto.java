package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CustomerDto {
    private String customerCode;
    private String customerName;
    private int customerContact;
    private String customerEmail;

}
