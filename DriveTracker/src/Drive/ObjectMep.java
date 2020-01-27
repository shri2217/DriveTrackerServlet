package Drive;

import com.fasterxml.jackson.databind.ObjectMapper;


public class ObjectMep {
	
private static final ObjectMapper obj=new ObjectMapper();
	
	public static Object getObject(String jsonString,Class<CderivePojo> req) {
		Object ob=null;
		
		try {
			ob=obj.readValue(jsonString,req);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return ob;
	}
	
	public static Object getJSONFromObject(Object object) {
		String jsondata = null;

		try
		{
			jsondata = obj.writeValueAsString(object);
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}

		return jsondata;

	}

}
