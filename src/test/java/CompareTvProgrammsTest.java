import helpers.ReceiveTvProgrammeHelper;
import org.junit.Test;

public class CompareTvProgrammsTest {

    ReceiveTvProgrammeHelper receiveTvProgrammeHelper = new ReceiveTvProgrammeHelper();

    @Test
    public void tvProgrammesFromTwoFilesShouldBeEqual() {
        String unformattedXmlProgramm = receiveTvProgrammeHelper.getXmlProgrammeInString();
        String unformattedJsonProgramm = receiveTvProgrammeHelper.getJsonProgrammeInString();

    }
}
