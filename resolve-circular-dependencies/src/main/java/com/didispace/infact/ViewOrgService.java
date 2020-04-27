package com.didispace.infact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author duhongming
 * @version 1.0
 * @description TODO
 * @date 2020/4/27 11:19
 */
@Service("viewOrgService")
public class ViewOrgService {
    @Resource
    private DcCompanyIpoService dcCompanyIpoService;
    @Resource
    private ViewCompanyService viewCompanyService;
}