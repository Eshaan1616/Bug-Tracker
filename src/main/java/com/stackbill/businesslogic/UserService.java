package com.stackbill.businesslogic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackbill.entitys.UserEntity;
import com.stackbill.repositories.UserRepository;

@Service
public class UserService {
	@Autowired 
	 private UserRepository dao;

    public List<UserEntity> getAllPojos() {
        return dao.findAll();
    }

    public Optional<UserEntity> getPojoById(int id) {
        return dao.findById(id);
    }

    public UserEntity createPojo(UserEntity pojo) {
        return dao.save(pojo);
    }
    
    

    public UserEntity updatePojo(int id, UserEntity updatedPojo) {
        UserEntity pojo = dao.findById(id).orElseThrow(() -> new RuntimeException("Pojo not found"));
        pojo.setUsername(updatedPojo.getUsername());
        pojo.setPhoneNumber(updatedPojo.getPhoneNumber());
        pojo.setId(updatedPojo.getId());
        pojo.setEmail(updatedPojo.getEmail());
        pojo.setPassword(updatedPojo.getPassword());
        pojo.setConfirmPassword(updatedPojo.getConfirmPassword());
        return dao.save(pojo);
    }

    public void deletePojo(int id) {
        dao.deleteById(id);
    }

	public UserEntity getloginauthetiction(String username, String pwd) {
		UserEntity user = dao.getUserDetails(username);
		if (user != null && user.getPassword() != null && user.getPassword().equals(pwd)) {
			return user;
		} else {
			return new UserEntity();
		}
	}
}


