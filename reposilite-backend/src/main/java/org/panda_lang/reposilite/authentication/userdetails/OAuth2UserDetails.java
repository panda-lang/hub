package org.panda_lang.reposilite.authentication.userdetails;

import java.util.Map;

public interface OAuth2UserDetails {

    String getProviderId();

    String getName();

    String getDisplayName();

    String getEmail();

    String getAvatar();

    Map<String, Object> getAttributes();

}
