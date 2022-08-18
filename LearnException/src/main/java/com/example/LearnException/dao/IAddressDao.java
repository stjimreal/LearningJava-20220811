package com.example.LearnException.dao;

import com.example.LearnException.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressDao extends CrudRepository<Address, Integer> {
}
