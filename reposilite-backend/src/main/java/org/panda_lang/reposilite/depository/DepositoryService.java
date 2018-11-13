package org.panda_lang.reposilite.depository;

import org.springframework.lang.Nullable;

import java.util.Set;

public interface DepositoryService {

    @Nullable
    Depository getDepository(String name);

    @Nullable
    DepositoryEntity getDepositoryEntity(Depository depository, String entityQualifier);

    Set<String> getNames();

}
