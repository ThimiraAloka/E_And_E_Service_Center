package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class UserDto {

    private String email;
    private String password;

    public String toString(){
        return "Users{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
