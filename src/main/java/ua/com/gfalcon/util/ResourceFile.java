package ua.com.gfalcon.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;



/**
 * @author Oleksii Khalikov
 */
public class ResourceFile {

    private final String path;


    public ResourceFile(String path) {
        this.path = path;
    }


    public BufferedReader getFileReader() {
        return new BufferedReader(
                new InputStreamReader(
                        getClass().getResourceAsStream(path)
                )
        );
    }

}
