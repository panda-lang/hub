package org.panda_lang.reposilite.utils.converter;

@FunctionalInterface
interface Converter<R, T> {

  R convert(T value);

}
