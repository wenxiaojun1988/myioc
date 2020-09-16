package com.company.factory;

import com.company.service.Autowired;
import com.company.service.Service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 描述
 * </p>
 *
 * @author wenxiaojun
 * @since 2020/9/16 14:12
 */
public class BeanFactory {
    private static final Map<Class, Object> map = new HashMap<>();

    public static void generateBean(List<Class> classes) throws InstantiationException, IllegalAccessException {
        for (Class class1 : classes) {
            if (class1.getAnnotation(Service.class) != null) {
                // 生成class实例
                generateAndGetBean(class1);
            }
        }
    }

    private static Object generateAndGetBean(Class clazz) throws IllegalAccessException, InstantiationException {
        if (!map.containsKey(clazz)) {
            Object obj = clazz.newInstance();
            map.put(clazz, obj);
            setProperties(obj);
            return obj;
        } else {
            return map.get(clazz);
        }
    }

    private static void setProperties(Object obj) throws InstantiationException, IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(Autowired.class) != null) {
                Class fieldClass = field.getType();
                field.setAccessible(true);
                field.set(obj, generateAndGetBean(fieldClass));
            }

        }
    }

    public static Object getBean(Class clazz) {
        return map.get(clazz);
    }

}
