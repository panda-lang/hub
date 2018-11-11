package org.panda_lang.reposilite.utils;

import java.io.Serializable;

@FunctionalInterface
public interface Buildable<T extends Serializable> {

    T build();

}
