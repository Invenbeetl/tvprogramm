import dto.ProgrammeDTO;
import helpers.ParseJsonProgrammeHelper;
import helpers.ParseXmlProgrammeHelper;
import helpers.ReceiveTvProgrammeHelper;
import org.junit.Test;

import java.util.List;

public class CompareTvProgrammsTest {

    ReceiveTvProgrammeHelper receiveTvProgrammeHelper = new ReceiveTvProgrammeHelper();
    ParseJsonProgrammeHelper parseJsonProgrammeHelper = new ParseJsonProgrammeHelper();
    ParseXmlProgrammeHelper parseXmlProgrammeHelper = new ParseXmlProgrammeHelper();

    @Test
    public void tvProgrammesFromTwoFilesShouldBeEqual() {
        String unformattedXmlProgramm = receiveTvProgrammeHelper.getXmlProgrammeInString();
        List<ProgrammeDTO> programmeFromXml = parseXmlProgrammeHelper.handleXmlProgrammeInString(unformattedXmlProgramm);
        String unformattedJsonProgramm = receiveTvProgrammeHelper.getJsonProgrammeInString();
        List<ProgrammeDTO> programmeFromJson = parseJsonProgrammeHelper.handleJsonProgrammeInString(unformattedJsonProgramm);

    }
}
