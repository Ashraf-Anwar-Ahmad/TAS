package com.icg.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.icg.model.Role;
import com.icg.util.MessageExtension;
import com.icg.util.RestClientForGet;
import com.icg.util.VMSUtils;

@Service
public class RolesServiceImpl implements RolesService {

	
	public List<Role> getRoles(String userId) {
		
		String url=null;
		RestClientForGet restClientForGet = new RestClientForGet();
		try{
	 url = MessageExtension.BASE_URL+MessageExtension.URL_GET_ROLE+"?userId="+userId+"";
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//System.out.println("URL ::: "+url);
		String finalUrl=VMSUtils.URLify(url);
		///System.out.println(" Final URL ::: "+finalUrl);
		String responseObj = restClientForGet.getRestClientForGet(finalUrl);
		
		JSONObject jsonObject = new JSONObject(responseObj);
		JSONArray jsonArray = jsonObject.optJSONArray("object");
		///System.out.println(jsonObject.toString());
		
		List<Role> roleList=new ArrayList<Role>();
		
		 if (jsonArray != null) {
             for (int i = 0; i < jsonArray.length(); i++) {
            	 Role role = new Role();
                 JSONObject jsonObjects = jsonArray.optJSONObject(i);
                 role.setRole(jsonObjects.optString("role"));
                 role.setRoleId(jsonObjects.optString("roleId"));
                 roleList.add(role);
             }
           //  System.out.println("roleList :: "+roleList.size());
         }
		
		return roleList;
	}

	
}
