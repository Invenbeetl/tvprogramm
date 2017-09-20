import dto.ProgrammeDTO;
import helpers.CompareProgramsHelper;
import helpers.NormalizeDateHelper;
import helpers.ParseJsonProgrammeHelper;
import helpers.ParseXmlProgrammeHelper;
import helpers.ReceiveTvProgrammeHelper;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class CompareTvProgrammsTest {

    ReceiveTvProgrammeHelper receiveTvProgrammeHelper = new ReceiveTvProgrammeHelper();
    ParseJsonProgrammeHelper parseJsonProgrammeHelper = new ParseJsonProgrammeHelper();
    ParseXmlProgrammeHelper parseXmlProgrammeHelper = new ParseXmlProgrammeHelper();
    NormalizeDateHelper normalizeDateHelper = new NormalizeDateHelper();
    CompareProgramsHelper compareProgramsHelper = new CompareProgramsHelper();

    @Test
    public void tvProgrammesFromTwoFilesShouldBeEqual() {
        List<ProgrammeDTO> programmeFromXml = receiveAndParseXmlDocument();
        List<ProgrammeDTO> programmeFromJson = receiveAndParseJsonDocument();
        assertTrue("Not all entries from JSON are present in XML or content is different",
                compareProgramsHelper.areAllEntriesFromJsonPresentInXml(programmeFromJson, programmeFromXml));
    }

    private List<ProgrammeDTO> receiveAndParseJsonDocument() {
        String unformattedJsonProgramm = receiveTvProgrammeHelper.getJsonProgrammeInString();
        return parseJsonProgrammeHelper.handleJsonProgrammeInString(unformattedJsonProgramm);
    }

    private List<ProgrammeDTO> receiveAndParseXmlDocument() {
        String unformattedXmlProgramm = receiveTvProgrammeHelper.getXmlProgrammeInString();
        List<ProgrammeDTO> programmeFromXml = parseXmlProgrammeHelper.handleXmlProgrammeInString(unformattedXmlProgramm);
        normalizeDateHelper.normalizeAllProgrammsDates(programmeFromXml);
        return programmeFromXml;
    }
}
