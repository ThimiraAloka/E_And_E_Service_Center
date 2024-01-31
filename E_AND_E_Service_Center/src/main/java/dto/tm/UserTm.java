package dto.tm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserTm {
    private String email;
    private  String password;
    private String jobRole;
    @Override
    public String toString() {
        return "UsersTm{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", jobRole='" + jobRole +
                '}';
    }

}
