/*
 * Copyright (c) 2018-2019 Hub Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.hub.utils;

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
