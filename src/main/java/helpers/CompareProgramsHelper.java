package helpers;

import dto.ProgrammeDTO;

import java.util.List;

public class CompareProgramsHelper {

    public boolean areAllEntriesFromJsonPresentInXml(List<ProgrammeDTO> programmeFromJson, List<ProgrammeDTO> programmeFromXml) {
        for (ProgrammeDTO tvShowFromJson : programmeFromJson) {
            if (!isListContainEntry(programmeFromXml, tvShowFromJson)) {
                return false;
            }
        }
        return true;
    }

    private boolean isListContainEntry (List<ProgrammeDTO> list, ProgrammeDTO entry) {
        for (ProgrammeDTO programme : list) {
            if (programme.equals(entry)) {
                return true;
            }
        }
        return false;
    }
}
