package helpers;

import dto.ProgrammeDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class NormalizeDateHelper {

    public void normalizeAllProgrammsDates(List<ProgrammeDTO> programmesList) {
        for (int i = 0; i < programmesList.size(); i++) {
            programmesList.get(i).setStartDate(convertDateToTimestamp(programmesList.get(i).getStartDate()));
            programmesList.get(i).setStopDate(convertDateToTimestamp(programmesList.get(i).getStopDate()));
        }
    }

    private String convertDateToTimestamp(String unformattedDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd kk:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Kiev"));
        Date date = null;
        try {
            date = dateFormat.parse(unformattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return String.valueOf(date.getTime() / 1000);
    }
}
