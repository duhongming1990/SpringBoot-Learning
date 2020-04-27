package com.didispace.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author duhongming
 * @version 1.0
 * @description TODO
 * @date 2020/4/27 9:30
 */
@Component
public class TeacherB {

    @Autowired
    private TeacherC teacherC;

    @Autowired
    public void setTeacherC(TeacherC teacherC) {
        this.teacherC = teacherC;
    }
}