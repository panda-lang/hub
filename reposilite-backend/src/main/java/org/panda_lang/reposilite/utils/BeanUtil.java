package org.panda_lang.reposilite.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.beans.PropertyDescriptor;
import java.util.Arrays;

public final class BeanUtil {

    private BeanUtil() { }

    private static <T> String[] getNullPropertyNames(T source) {
        BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        return Arrays.stream(pds)
                .filter(propertyDescriptor -> src.getPropertyValue(propertyDescriptor.getName()) == null)
                .map(FeatureDescriptor::getName)
                .distinct()
                .toArray(String[]::new);
    }

    public static <T> void copyNonNullProperties(T source, T target) {
        if (source == null || target == null) {
            return;
        }

        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

}
