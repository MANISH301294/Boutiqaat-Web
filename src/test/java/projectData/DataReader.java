package projectData;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException 
	{
		//user.dir - project path 
		//path where we store the JSON 
		//String path = System.getProperty("user.dir")+"\\src\\test\\java\\projectData\\ContryAddress.json";
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		
		//CONVERT STRING TO HASHMAP 
		// For this we need a dependency JacksonDatabind
		
		ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String,String>>  data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
		
		return data;
	}

}
