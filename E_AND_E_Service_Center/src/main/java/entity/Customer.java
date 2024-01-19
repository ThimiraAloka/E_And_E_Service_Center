package entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Customer {
    @Id
    private String customerCode;
    private String customerName;
    private int customerContact;
    private String customerEmail;



}
