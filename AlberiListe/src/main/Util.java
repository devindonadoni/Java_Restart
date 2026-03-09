package main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Util {
	
	public List<String> readFile(String filename){
		List<String> list = null;
		
		try {
			Path path = Paths.get(filename);
			list = Files.readAllLines(path, StandardCharsets.UTF_8);
		}catch (IOException e) {
			
		}
		
		list.remove(0);
		return list;
	}
}



