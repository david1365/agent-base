package ir.daak.base.util;

/**
 * @author Davood Akbari - 1398
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class File {
    public static String readFromFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, Charset.defaultCharset());
    }
}
