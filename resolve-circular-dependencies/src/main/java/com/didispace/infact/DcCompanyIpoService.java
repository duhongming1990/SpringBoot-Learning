package com.didispace.infact;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author duhongming
 * @version 1.0
 * @description TODO
 * @date 2020/4/27 11:20
 */
@Service("dcCompanyIpoService")
public class DcCompanyIpoService {
    @Resource
    private ViewCompanyService viewCompanyService;
}