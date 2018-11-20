package org.panda_lang.reposilite.depository;

import org.bson.types.ObjectId;
import org.panda_lang.reposilite.utils.IdentifiableEntity;

import java.io.Serializable;

public interface DepositoryOwner extends IdentifiableEntity<ObjectId>, Serializable {

    String getName();

    void setName(String name);

    String getDisplayName();

    void setDisplayName(String displayName);

    String getDescription();

    void setDescription(String description);

    String getEmail();

    void setEmail(String email);

    String getSite();

    void setSite(String site);

}
