package poker.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProjectUtils {
    public static List<String> readFile(String fileName) {
    	List<String> lines = new ArrayList<>();
    	try(BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
    	    String line = reader.readLine();
    	    while (line != null) {
    	    	lines.add(line);
    	        line = reader.readLine();
    	    }
    	} catch (IOException ex) {
    		System.out.println("Error reading from \"" + fileName + "\": " + ex.getMessage());
    	}	
    	return lines;
    }
}
