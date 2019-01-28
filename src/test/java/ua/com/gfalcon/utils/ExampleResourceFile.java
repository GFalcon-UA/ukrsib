package ua.com.gfalcon.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;



/**
 * @author Oleksii Khalikov
 */
public class ExampleResourceFile {

    private final String path;


    public ExampleResourceFile(String path) {
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
