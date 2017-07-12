package learn.zxl.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learn.zxl.boot.dao.master.UserDao;
import learn.zxl.boot.model.UserModel;
import learn.zxl.boot.service.UserService;

@Service("userService")
public class UserServiceimpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public int save(UserModel saveModel) {
		return userDao.insertRecordInit(saveModel);
	}

	@Override
	public List<UserModel> getUsers() {
		return userDao.selectAll();
	}

}
