package com.didispace.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author duhongming
 * @version 1.0
 * @description TODO
 * @date 2020/4/27 9:27
 */
//@Component
public class StudentA {

    private StudentB studentB;

//    @Autowired
    public StudentA(StudentB studentB) {
        this.studentB = studentB;
    }
}