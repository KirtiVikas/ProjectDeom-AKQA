package CommonFunctionality;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public  class Configfile  {
public static String Testcasename=null;
	
/*****************************************************************************************************************************************
	*  Method            : GetJsonTestData
	*  Arguments 		  : Key
	*  Return value 	  : value corresponding to Key
	*  Method Description : This method will return test data from JsonTestDatat.txt under Input folder 
	* Date Created        : 10/08/2019
	* Author              : Kirti Vikas
	*
*****************************************************************************************************************************************/
	public String GetJsonTestData(String Key) throws Exception {
		String value =null;
		JSONParser parser = new JSONParser();		
		Object obj = parser.parse(new FileReader(".\\Input\\JsonTestData.txt"));
		JSONObject jsonObject = (JSONObject) obj;
		value = (String) jsonObject.get(Key);
		System.out.println("Key: " + value);	
		return value;
	}
	
/*****************************************************************************************************************************************
	*  Method            : GetJsonOjectRepository
	*  Arguments 		  : Key
	*  Return value 	  : value corresponding to Key
	*  Method Description : This method will return WebElement locator from JsonObjectRepository.txt file under Input folder.
	* Date Created        : 10/08/2019
	* Author              : Kirti Vikas
	*
*****************************************************************************************************************************************/
	public String GetJsonObjectRepository(String Key)throws Exception {
		String value =null;
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(".\\Input\\JsonObjecctRepoistory.txt"));
		JSONObject jsonObject = (JSONObject) obj;
		value = (String) jsonObject.get(Key);
		System.out.println("Key: " + value);
		return value;
	}	
	
}
