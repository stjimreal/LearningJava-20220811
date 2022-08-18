package com.example.LearnException.service;

import com.example.LearnException.exceptions.DefaultAddressNotDeleteException;
import com.example.LearnException.exceptions.NotFindAddressException;
import com.example.LearnException.exceptions.NotFindUserException;
import com.example.LearnException.exceptions.NotMatchUserAddressException;
import com.example.LearnException.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IAddressService {

    /**
     * 创建收货地址
     * @param uid
     * @param address
     * @return
     */
    Address createAddress(Integer uid,Address address) throws NotFindUserException;

    /**
     * 删除收货地址
     * @param uid
     * @param aid
     */
    void deleteAddress(Integer uid,Integer aid) throws DefaultAddressNotDeleteException, NotMatchUserAddressException, NotFindAddressException, NotFindUserException;

    /**
     * 查询用户的所有收货地址
     * @param uid
     * @return
     */
    List<Address> listAddresses(Integer uid) throws NotFindUserException;
}
