package org.panda_lang.reposilite.utils;

@FunctionalInterface
public interface IdentifiableEntity<ID> {

    ID getIdentifier();

}
