package helpers;

import dto.ProgrammeDTO;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static utils.FilesAndFoldersUtil.deleteLocalFile;
import static utils.FilesAndFoldersUtil.saveStringToFile;

public class ParseXmlProgrammeHelper {
    private static final String LOCAL_FOLDER_TO_STORE_FILES = "src/test/resources/files/";
    private static final String TEMPORARY_XML_FILE_NAME = "tmp.xml";

    public List<ProgrammeDTO> handleXmlProgrammeInString(String xmlInString) {
        List<ProgrammeDTO> programmesList = new ArrayList<>();
        return getProgrammesFromXml(xmlInString, programmesList);

    }

    private List<ProgrammeDTO> getProgrammesFromXml(String xmlInString, List<ProgrammeDTO> programmesList) {
        xmlInString = xmlInString.replace("<!DOCTYPE tv SYSTEM \"xmltv.dtd\">", "");
        saveStringToFile(xmlInString, LOCAL_FOLDER_TO_STORE_FILES, TEMPORARY_XML_FILE_NAME);
        try {
            File fXmlFile = new File(LOCAL_FOLDER_TO_STORE_FILES + TEMPORARY_XML_FILE_NAME);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("programme");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                ProgrammeDTO programmeDTO = new ProgrammeDTO();
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    programmeDTO.setStartDate(eElement.getAttribute("start"));
                    programmeDTO.setStopDate(eElement.getAttribute("stop"));
                    programmeDTO.setTitle(eElement.getElementsByTagName("title").item(0).getTextContent());
                }
                programmesList.add(programmeDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            deleteLocalFile(LOCAL_FOLDER_TO_STORE_FILES + TEMPORARY_XML_FILE_NAME);
        }
        return programmesList;
    }


}
