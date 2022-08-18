package com.example.LearnException.dto;

import com.example.LearnException.model.Jduser;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @program: Learning-20220811
 * @description:
 * @author:
 * @created: 2022/08/17 19:44
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressDTO {
    @NotNull
    private String province;//省
    @NotNull
    private String city;//市
    @NotNull
    private String county;//区
    private Boolean isDefault;//是否是默认地址
    @NotNull
    private Integer userId;

}
