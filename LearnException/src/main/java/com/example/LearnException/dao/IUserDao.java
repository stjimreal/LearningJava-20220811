package com.example.LearnException.dao;

import com.example.LearnException.model.Jduser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends CrudRepository<Jduser, Integer> {
}
