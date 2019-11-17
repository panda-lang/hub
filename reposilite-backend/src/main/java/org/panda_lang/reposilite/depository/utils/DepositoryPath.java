/*
 * Copyright (c) 2018-2019 Reposilite Team
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

package org.panda_lang.reposilite.depository.utils;

import org.panda_lang.utilities.commons.StringUtils;

import java.util.ArrayList;
import java.util.List;

final class DepositoryPath {

    private static final int NOT_FOUND = -1;

    private final List<? extends DepositoryUnit> elements;
    private final int wildcardIndex;

    private DepositoryPath(List<? extends DepositoryUnit> elements, int wildcardIndex) {
        this.elements = elements;
        this.wildcardIndex = wildcardIndex;
    }

    DepositoryUnit forElement(int fullLength, int forIndex) {
        boolean wildcard = fullLength > elements.size();

        if (!wildcard) {
            return elements.get(forIndex);
        }

        if (wildcardIndex == NOT_FOUND) {
            throw new IllegalArgumentException("Wildcard based request to non wildcard path");
        }

        if (forIndex < wildcardIndex) {
            return elements.get(forIndex);
        }

        int requiredEnd = elements.size() - wildcardIndex;

        if (forIndex > elements.size()) {
            return elements.get(forIndex - requiredEnd);
        }

        return elements.get(wildcardIndex);
    }

    List<? extends DepositoryUnit> getElements() {
        return elements;
    }

    static DepositoryPath parse(String pattern) {
        List<DepositoryUnit> elements = new ArrayList<>();
        String[] placeholders = StringUtils.split(pattern, "/");

        for (int index = 0; index < placeholders.length; index++) {
            elements.add(DepositoryUnit.of(placeholders[index], index));
        }

        int wildcard = NOT_FOUND;

        for (int index = 0, elementsSize = elements.size(); index < elementsSize; index++) {
            DepositoryUnit element = elements.get(index);

            if (element.isMultipart()) {
                if (wildcard != NOT_FOUND) {
                    throw new IllegalStateException("Pattern cannot contain 2 >= wildcards");
                }

                wildcard = index;
            }
        }

        return new DepositoryPath(elements, wildcard);
    }

}
