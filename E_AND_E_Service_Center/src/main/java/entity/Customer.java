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
    private String id;
    private String name;
    private int contact;
    private String email;



}
