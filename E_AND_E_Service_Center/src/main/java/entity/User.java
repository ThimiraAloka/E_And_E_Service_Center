package entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class User {
    @Id
    private String email;
    private String password;
    private String jobRole;
    public User(String email, String password, String jobRole) {
        this.email = email;
        this.password = password;
        this.jobRole = jobRole;
    }



}
