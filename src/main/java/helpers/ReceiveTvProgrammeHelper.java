package helpers;

import utils.RestUtil;

public class ReceiveTvProgrammeHelper {

    public static final String GET_TV_PROGRAMME_XML_URL = "http://www.vsetv.com/export/megogo/epg/3.xml";
    public static final String GET_TV_PROGRAMME_JSON_URL = "http://epg.megogo.net/channel?external_id=295";

    public String getXmlProgrammeInString() {
        return RestUtil.sendGetRequest(GET_TV_PROGRAMME_XML_URL);
    }

    public String getJsonProgrammeInString() {
        return RestUtil.sendGetRequest(GET_TV_PROGRAMME_JSON_URL);
    }
}
