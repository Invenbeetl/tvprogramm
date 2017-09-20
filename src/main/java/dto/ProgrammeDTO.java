package dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProgrammeDTO extends BaseDTO {

    private String startDate;
    private String stopDate;
    private String title;

}
