package com.example.LearnException.controller;

import com.example.LearnException.dto.AddressDTO;
import com.example.LearnException.exceptions.AddressErrorCode;
import com.example.LearnException.exceptions.ApiException;
import com.example.LearnException.exceptions.NotFindUserException;
import com.example.LearnException.model.Address;
import com.example.LearnException.service.AddressServiceImpl;
import com.example.LearnException.service.IAddressService;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @program: Learning-20220811
 * @description:
 * @author:
 * @created: 2022/08/17 19:29
 */
@Controller
public class AddressCrudController {
    @Resource
    private IAddressService addressService;

    @PutMapping("/address")
    public @ResponseBody AddressDTO addAddress(@Valid @RequestBody AddressDTO addressDTO) {
        Address address1 = new Address();
        BeanUtils.copyProperties(addressDTO, address1);
        Address result;
        try {
            result = addressService.createAddress(addressDTO.getUserId(), address1);
        } catch (NotFindUserException e) {
            throw new ApiException(AddressErrorCode.NotFindUserErrorCode, e.getMessage(), e);
        } catch (Exception e) {
            throw new ApiException(e);
        }
        AddressDTO resultDTO = new AddressDTO();
        BeanUtils.copyProperties(result,resultDTO);
        resultDTO.setUserId(result.getJduser().getId());
        return resultDTO;
    }
}
