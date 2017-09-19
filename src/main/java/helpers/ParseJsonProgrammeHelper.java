package helpers;

import dto.ProgrammeDTO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static utils.ParseJsonUtil.getInnerJsonByKeyAndValue;
import static utils.ParseJsonUtil.getJsonArray;

public class ParseJsonProgrammeHelper {

    private static final String CHANNEL_TITLE = "title";
    private static final String ONE_PLUS_ONE_CHANNEL = "1+1";
    private static final String DATA_NODE = "data";
    private static final String PROGRAMS_NODE = "programs";
    private static final String START_DATE_NODE = "start_timestamp";
    private static final String STOP_DATE_NODE = "end_timestamp";
    private static final String TITLE_NODE = "title";

    public List<ProgrammeDTO> handleJsonProgrammeInString(String jsonInString) {
        List<ProgrammeDTO> programmesList = new ArrayList<>();
        return getProgrammesFromJson(jsonInString, programmesList);
    }

    private List<ProgrammeDTO> getProgrammesFromJson(String jsonInString, List<ProgrammeDTO> programmesList) {
        JSONArray dataArray = getJsonArray(new JSONObject(jsonInString), DATA_NODE);
        JSONObject jsonWithSpecifiedChannelPrograms =
                getInnerJsonByKeyAndValue(dataArray, CHANNEL_TITLE, ONE_PLUS_ONE_CHANNEL);
        JSONArray arrayOfPrograms = getJsonArray(jsonWithSpecifiedChannelPrograms, PROGRAMS_NODE);
        parseProgramsFromArray(programmesList, arrayOfPrograms);
        return programmesList;
    }

    private void parseProgramsFromArray(List<ProgrammeDTO> programmesList, JSONArray arrayOfPrograms) {
        for (int i = 0; i < arrayOfPrograms.length(); i++) {
            ProgrammeDTO programmeDTO = new ProgrammeDTO();
            JSONObject tvShow = new JSONObject(arrayOfPrograms.get(i).toString());
            programmeDTO.setStartDate(tvShow.get(START_DATE_NODE).toString());
            programmeDTO.setStopDate(tvShow.get(STOP_DATE_NODE).toString());
            programmeDTO.setTitle(tvShow.get(TITLE_NODE).toString());
            programmesList.add(programmeDTO);
        }
    }

}
