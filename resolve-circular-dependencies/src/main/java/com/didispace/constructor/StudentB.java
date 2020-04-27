package com.didispace.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author duhongming
 * @version 1.0
 * @description TODO
 * @date 2020/4/27 9:30
 */
//@Component
public class StudentB {

    private StudentC studentC;

//    @Autowired
    public StudentB(StudentC studentC) {
        this.studentC = studentC;
    }
}