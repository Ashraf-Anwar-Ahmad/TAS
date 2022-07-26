package com.icg.service;

import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.icg.model.User;
import com.icg.util.MessageExtension;
import com.icg.util.RestClientForPost;

@Service
public class UserServiceImpl implements UserService {

	
	@Override
	public String validateUser(String ... varArg) {
				
		String url = MessageExtension.BASE_URL+"login?userName="+varArg[0]+"&password="+varArg[1];
		RestClientForPost restClientForPost = new RestClientForPost();
		//System.out.println("URL ::: "+url);
		String response = restClientForPost.getRestClientForPost(url);
		
		

	return response;
		
	}
	
	
	
	@Override
	public User validateUser(User user) {

//		System.out.println(user.getUserId());
//		System.out.println(user.getPassword());
//		System.out.println("-------------------------------------------------------------");
		
		//restClientForPost.getRestClientForPost("http://localhost:8082/LogHubAPI/webapi/login",user);
		//user=restTemplate.getForObject(baseURL+"account/1", User.class);
		//Account account = new Account("Arnav Rajput", "Noida", 312.33);
		/*User user1 = restTemplate.postForObject(baseURL+"login", user, User.class);
*/
		
		RestClientForPost restClientForPost = new RestClientForPost();
		User user1 = new User();
		try {
		String url = MessageExtension.BASE_URL+"login?userName="+URLEncoder.encode(user.getUserId(),"UTF-8")+"&password="+URLEncoder.encode(user.getPassword(),"UTF-8")+"";
		
		
		//System.out.println("URL ::: "+url);
		String responseObj = restClientForPost.getRestClientForPost(url);
		
		JSONObject jsonObject = new JSONObject(responseObj);
		
		JSONArray jsonArray = jsonObject.optJSONArray("object");
		//System.out.println(jsonObject.toString());
		 if (jsonArray != null) {
			 for (int i = 0; i < jsonArray.length(); i++) {
                 JSONObject jsonObjects = jsonArray.optJSONObject(i);
             
                  user1.setUserName(jsonObjects.optString("userName"));
    			 user1.setOrgUnit(jsonObjects.optString("orgUnit"));
    			 user1.setOrgUnitId(jsonObjects.optString("orgUnitId"));
    			 user1.setpId(jsonObjects.optString("pId"));
//    			 System.out.println(jsonObjects.optString("userName"));
//    			 System.out.println(jsonObjects.optString("orgUnit"));
//    			 System.out.println(jsonObjects.optString("orgUnitId"));
             
         }
		 }
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user1;
	}

}
