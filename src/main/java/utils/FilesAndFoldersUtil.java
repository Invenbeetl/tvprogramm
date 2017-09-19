package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilesAndFoldersUtil {

    public static void saveStringToFile(String content, String filePath, String fileName) {
        final File file = new File(filePath + fileName);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            if (!file.exists()) {
                file.createNewFile();
            }
            byte[] contentInBytes = content.getBytes();
            fileOutputStream.write(contentInBytes);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            throw new IllegalStateException("Unable to write data to file " + fileName, e);
        }
    }

    public static void deleteLocalFile(String fileName) {
        File localFile = new File(fileName);
        if (localFile.exists()) {
            try {
                localFile.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
