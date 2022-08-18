package com.example.LearnException.service;

import com.example.LearnException.dao.IAddressDao;
import com.example.LearnException.dao.IUserDao;
import com.example.LearnException.exceptions.DefaultAddressNotDeleteException;
import com.example.LearnException.exceptions.NotFindAddressException;
import com.example.LearnException.exceptions.NotFindUserException;
import com.example.LearnException.exceptions.NotMatchUserAddressException;
import com.example.LearnException.model.Address;
import com.example.LearnException.model.Jduser;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Learning-20220811
 * @description:
 * 约束条件：
 * 1. 用户id不能为空，且此用户确实是存在的
 * 2. 收货地址的必要字段不能为空
 * 3. 如果用户还没有收货地址，当此收货地址创建时设置成默认收货地址
 * @author: liuljing
 * @created: 2022/08/17 15:26
 */

@Service
public class AddressServiceImpl implements IAddressService {


    @Resource
    private IUserDao userDao;
    @Resource
    private IAddressDao addressDao;

    @Override
    public Address createAddress(Integer uid, Address address) throws NotFindUserException {
        //============ 以下为约束条件   ==============
        //1.用户id不能为空，且此用户确实是存在的
        Preconditions.checkNotNull(uid);
        Jduser jduser = userDao.findById(uid).orElse(null);
        if(null == jduser){
            throw new NotFindUserException();
        }
        //2.收货地址的必要字段不能为空

//        BandValidators.validateWithException(validator, address);
        //3.如果用户还没有收货地址，当此收货地址创建时设置成默认收货地址
        address.setIsDefault(ObjectUtils.isEmpty(jduser.getAddresses()));

        //============ 以下为正常执行的业务逻辑   ==============
        address.setJduser(jduser);
        return addressDao.save(address);
    }

    @Override
    public void deleteAddress(Integer uid, Integer aid) throws DefaultAddressNotDeleteException, NotMatchUserAddressException, NotFindAddressException, NotFindUserException {
        //============ 以下为约束条件   ==============
        //1.用户id不能为空，且此用户确实是存在的
        checkNotNull(uid);
        Jduser jduser = userDao.findById(uid).orElse(null);
        if(null == jduser){
            throw new NotFindUserException();
        }
        //2.收货地址不能为空，且此收货地址确实是存在的
        checkNotNull(aid);
        Address address = addressDao.findById(aid).orElse(null);
        if(null == address){
            throw new NotFindAddressException();
        }
        //3.判断此收货地址是否是用户的收货地址
        if(!address.getJduser().equals(jduser)){
            throw new NotMatchUserAddressException();
        }
        //4.判断此收货地址是否为默认收货地址，如果是默认收货地址，那么不能进行删除
        if(address.getIsDefault()){
            throw new DefaultAddressNotDeleteException();
        }

        //============ 以下为正常执行的业务逻辑   ==============
        addressDao.delete(address);
    }

    @Override
    public List<Address> listAddresses(Integer uid) throws NotFindUserException {
        //============ 以下为约束条件   ==============
        //1.用户id不能为空，且此用户确实是存在的
        checkNotNull(uid);
        Jduser jduser = userDao.findById(uid).orElse(null);
        if(null == jduser){
            throw new NotFindUserException();
        }

        //============ 以下为正常执行的业务逻辑   ==============

        return new ArrayList<>(jduser.getAddresses());
    }
}
