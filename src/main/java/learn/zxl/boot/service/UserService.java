package learn.zxl.boot.service;

import java.util.List;

import learn.zxl.boot.model.UserModel;

public interface UserService {
	int save(UserModel saveModel);
	
	List<UserModel> getUsers();
}
