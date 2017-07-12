package learn.zxl.boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@ResponseBody
	@RequestMapping(value = "/api/test/test.json")
	public Object test() {
		Map<String, String> map = new HashMap<>();
		map.put("test", "test");
		return map;
	}
}
