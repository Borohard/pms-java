package pms.api.dto;

import lombok.Data;
import lombok.Value;

@Data
public class DepartmentDto {
    public Long id;
    public String name;
    public Long responsibleUserId;
}
