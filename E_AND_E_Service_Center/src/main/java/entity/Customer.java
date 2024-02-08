package entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

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

    public Customer(String id, String name, int contact, String email) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.email = email;
    }
}
