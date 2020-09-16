package com.company.service;

/**
 * <p>
 * 描述
 * </p>
 *
 * @author wenxiaojun
 * @since 2020/9/16 15:00
 */
@Service
public class ServiceEnt {
    @Autowired
    private ServiceA serviceA;

    public void test(String str) {
        serviceA.test(str);
    }
}
