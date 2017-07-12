package learn.zxl.boot.controller.rest;

import java.util.HashMap;
import java.util.Map;

import learn.zxl.boot.model.UserModel;
import learn.zxl.boot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserRestController {
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "api/data/users", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Object getPersons() {
		return userService.getUsers();
	}
	
	@ResponseBody
	@RequestMapping(value = "api/data/users", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Object savePerson(UserModel saveModel) {
		int result = userService.save(saveModel);
		Map<String, String> resultMap = new HashMap<>();
		if(result > 0) {
			resultMap.put("success", "true");
		} else {
			resultMap.put("success", "false");
		}
		
		return resultMap;
	}
}
