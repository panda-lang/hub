package net.dzikoysk.reposilite.repository.depository;

import net.dzikoysk.reposilite.domain.depository.Depository;
import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public class DepositoryRepository {

    public @Nullable Depository findDepositoryByName(String name) {
        //TODO: Make sure name is not null?
        return null;
    }

    public @Nullable DepositoryEntity findEntityByPath(String path) {
        //TODO: Make sure path is not null?
        return null;
    }

}
