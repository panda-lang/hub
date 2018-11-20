package org.panda_lang.reposilite.depository;

import org.bson.types.ObjectId;
import org.panda_lang.reposilite.utils.IdentifiableEntity;

import java.io.Serializable;

public interface DepositoryOwner extends IdentifiableEntity<ObjectId>, Serializable {

    void setName(String name);

    void setDisplayName(String displayName);

    void setDescription(String description);

    void setEmail(String email);

    void setSite(String site);

    String getName();

    String getDisplayName();

    String getDescription();

    String getEmail();

    String getSite();

}
