/*
 * MIT License
 *
 * Copyright (c) 2018 Coachy
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
