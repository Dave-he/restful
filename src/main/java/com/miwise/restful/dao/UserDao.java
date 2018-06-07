package com.miwise.restful.dao;

import com.miwise.restful.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<UserEntity,Long> {

	public UserEntity findByUsernameAndPassword(String username,String password);


}
