package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtil 
{
	public static List<String> readTextFile(String filename)
	{
		List<String> result = null;
		Path filepath = Paths.get(filename);
		
		try {
			result = Files.readAllLines(filepath);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		return result;
	}

	public static String[] readTextFileToArray(String filename)
	{
		String[] result = null;
		
		List<String> list = readTextFile(filename);
		if (list != null)
		{
			result = new String[list.size()];
			for (int idx=0; idx < list.size(); idx++)
				result[idx] = list.get(idx);
		}		
		
		return result;
	}
}
