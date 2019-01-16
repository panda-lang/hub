package org.panda_lang.reposilite.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public final class BeanUtil {

  private BeanUtil() {
  }

  public static <T> void copyNonNullProperties(T source, T target) {
    if (source == null || target == null) {
      return;
    }

    BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
  }

  private static <T> String[] getNullPropertyNames(T source) {
    final BeanWrapper src = new BeanWrapperImpl(source);
    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

    Set<String> emptyNames = Arrays.stream(pds)
        .filter(propertyDescriptor -> src.getPropertyValue(propertyDescriptor.getName()) == null)
        .map(FeatureDescriptor::getName)
        .collect(Collectors.toSet());
    String[] result = new String[emptyNames.size()];
    return emptyNames.toArray(result);
  }

}
