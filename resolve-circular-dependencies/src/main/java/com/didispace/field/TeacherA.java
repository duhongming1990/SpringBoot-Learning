package com.didispace.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author duhongming
 * @version 1.0
 * @description TODO
 * @date 2020/4/27 9:27
 */
@Component
public class TeacherA {

    @Autowired
    private TeacherB teacherB;

    @Autowired
    public void setTeacherB(TeacherB teacherB) {
        this.teacherB = teacherB;
    }
}