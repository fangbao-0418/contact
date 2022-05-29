package com.eiot6.Utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JpaUtil {
    public static void copyNotNullProperties(Object src, Object target, String ...propertyName){
        String[] propertyName2 = getNullPropertyNames(src);
        
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(propertyName2));
        list.addAll(Arrays.asList(propertyName));
        String[] ignoreProperties = list.toArray(new String[list.size()]);

        BeanUtils.copyProperties(
            src, target, ignoreProperties
        );
    }

    private static String[] getNullPropertyNames(Object object) {
        final BeanWrapperImpl wrapper = new BeanWrapperImpl(object);
        return Stream.of(wrapper.getPropertyDescriptors())
                .map(PropertyDescriptor::getName)
                .filter(propertyName -> wrapper.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }
}