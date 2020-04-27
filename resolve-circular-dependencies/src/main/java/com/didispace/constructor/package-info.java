package com.didispace.constructor;
//第一种：构造器参数循环依赖(不要用)

//The dependencies of some of the beans in the application context form a cycle:
//        ┌─────┐
//        |  studentA defined in file [D:\JavaDemo\SpringBoot-Learning\resolve-circular-dependencies\target\classes\com\didispace\constructor\StudentA.class]
//        ↑     ↓
//        |  studentB defined in file [D:\JavaDemo\SpringBoot-Learning\resolve-circular-dependencies\target\classes\com\didispace\constructor\StudentB.class]
//        ↑     ↓
//        |  studentC defined in file [D:\JavaDemo\SpringBoot-Learning\resolve-circular-dependencies\target\classes\com\didispace\constructor\StudentC.class]
//        └─────┘