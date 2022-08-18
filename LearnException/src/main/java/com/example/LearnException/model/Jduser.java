package com.example.LearnException.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.checkerframework.checker.units.qual.A;

import javax.persistence.*;
import java.util.Set;

/**
 * @program: Learning-20220811
 * @description:
 * @author: liuljing
 * @created: 2022/08/17 14:38
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jduser {
    @Id
    @GeneratedValue
    private  Integer id;
    private String name;

    /*
        https://blog.csdn.net/xu180/article/details/53396750
        Hibernate: OneToMany是默认FetchType.LAZY，ManyToOne默认是FetchType.EAGER，session提前
        EAGER关闭了，所以LAZY模式失败。
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jduser", fetch = FetchType.EAGER)
        private Set<Address> addresses;

    @Override
    public String toString() {
        return id + " " + name;
    }

    public Boolean equals(Jduser jduser) {
        return this.toString().equals(jduser.toString());
    }
}
