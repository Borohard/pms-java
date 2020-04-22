package pms.api.dto;

import lombok.Data;
import lombok.Value;

@Data
public class UserRegisterDto {
    public String username;

    public String password;

    public String fullName;

    public int departmentId;
}
