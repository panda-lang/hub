package org.panda_lang.reposilite.utils.entity;

@FunctionalInterface
public interface IdentifiableEntity<ID> {

    ID getIdentifier();

}
