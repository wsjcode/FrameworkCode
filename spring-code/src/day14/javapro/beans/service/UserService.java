package day14.javapro.beans.service;

import java.util.List;

import day14.javapro.beans.annotation.Autowired;
import day14.javapro.beans.annotation.Service;
import day14.javapro.beans.dao.UserDao;
import day14.javapro.beans.pojo.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public User get(Integer id) {
		User user = userDao.selectOne(id);
		return user;
	}
	
	public List<User> queryAll(){
		List<User> userList = userDao.selectList();
		return userList;
	}
}
