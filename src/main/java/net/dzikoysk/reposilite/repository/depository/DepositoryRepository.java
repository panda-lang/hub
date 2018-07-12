package net.dzikoysk.reposilite.repository.depository;

import net.dzikoysk.reposilite.domain.depository.Depository;
import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public class DepositoryRepository {

    public @Nullable Depository findDepositoryByName(@NonNull String name) {
        return null;
    }

    public @Nullable DepositoryEntity findEntityByPath(@NonNull String path) {
        return null;
    }

}
