package dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProgrammeDTO extends BaseDTO {

    private String startDate;
    private String startTime;
    private String title;
    private String description;

}
