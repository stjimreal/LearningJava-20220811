package com.example.LearnException.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @program: Learning-20220811
 * @description: 地址实体
 * @author: liuljing
 * @created: 2022/08/17 14:37
 */
@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String province;//省
    @NotNull
    private String city;//市
    @NotNull
    private String county;//区
    private Boolean isDefault;//是否是默认地址

    @javax.persistence.ManyToOne
    @javax.persistence.JoinColumn(name = "jduser_id")
    private Jduser jduser;

}
