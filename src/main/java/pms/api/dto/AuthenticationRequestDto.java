package pms.api.dto;

import lombok.Data;
import lombok.Value;

@Data
public class AuthenticationRequestDto {
    public String username;
    public String password;
}
