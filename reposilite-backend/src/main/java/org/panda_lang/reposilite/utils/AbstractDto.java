package org.panda_lang.reposilite.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractDto<T extends IdentifiableEntity<?>> {

    public T toEntity() {
        throw new UnsupportedOperationException();
    }

    public String toJson() {
        try {
            return new ObjectMapper().writer().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

}
