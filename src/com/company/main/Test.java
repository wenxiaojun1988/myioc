package com.company.main;

import com.company.factory.BeanFactory;
import com.company.service.ServiceA;
import com.company.service.ServiceEnt;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 描述
 * </p>
 *
 * @author wenxiaojun
 * @since 2020/9/16 15:03
 */
public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        List<Class> list = new ArrayList<>();
        list.add(ServiceA.class);
        list.add(ServiceEnt.class);
        BeanFactory.generateBean(list);
        ServiceEnt serviceEnt = (ServiceEnt) BeanFactory.getBean(ServiceEnt.class);
        serviceEnt.test("fasfsadfsadfsdafdsafads");
    }
}
