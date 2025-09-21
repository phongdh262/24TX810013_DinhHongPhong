package vn.iotstar.daos;

import vn.iotstar.models.UserModel;

public interface UserDao {
	
	UserModel findByUserName(String username);

	void insert(UserModel user);

	boolean checkExistEmail(String email);
    
	boolean checkExistUsername(String username);
    
	boolean checkExistPhone(String phone);

}
