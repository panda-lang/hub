/*
 * Copyright (c) 2020 Hub Team of panda-lang organization
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
package org.panda_lang.hub.utils

import org.springframework.beans.BeanUtils
import org.springframework.beans.BeanWrapper
import org.springframework.beans.BeanWrapperImpl
import java.beans.PropertyDescriptor

object BeanUtil {

    private fun <T> getNullPropertyNames(source: T): Array<String> {
        val src: BeanWrapper = BeanWrapperImpl(source)
        val propertyDescriptors: Array<PropertyDescriptor> = src.propertyDescriptors

        return propertyDescriptors
                .filter { propertyDescriptor: PropertyDescriptor -> src.getPropertyValue(propertyDescriptor.name) == null }
                .map { obj: PropertyDescriptor -> obj.name }
                .distinct()
                .toTypedArray()
    }

    fun <T> copyNonNullProperties(source: T?, target: T?) {
        if (source == null || target == null) {
            return
        }

        BeanUtils.copyProperties(source, target, *getNullPropertyNames(source))
    }

}