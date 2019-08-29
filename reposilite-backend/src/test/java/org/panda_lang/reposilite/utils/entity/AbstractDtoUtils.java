package org.panda_lang.reposilite.utils.entity;

import org.panda_lang.reposilite.utils.entity.AbstractDto;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public final class AbstractDtoUtils {

    public static void perform(MockMvc mockMvc, String uri, AbstractDto<?> dto, ResultMatcher resultMatcher) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(dto.toJson().getBytes())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(resultMatcher);
    }

}
