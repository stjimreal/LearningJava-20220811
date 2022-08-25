package com.examplellj.jdbctemplatedemo;

import lombok.Builder;
import lombok.Data;

/**
 * @program: Learning-20220811
 * @description:
 * @author: liuljing
 * @created: 2022/08/24 20:32
 */
@Data
@Builder
public class Foo {
    private Long id;
    private String bar;
}
