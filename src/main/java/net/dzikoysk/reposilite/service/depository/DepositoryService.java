package net.dzikoysk.reposilite.service.depository;

import net.dzikoysk.reposilite.domain.depository.Depository;
import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;
import net.dzikoysk.reposilite.repository.depository.DepositoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class DepositoryService {

    private final DepositoryRepository depositoryRepository;

    public DepositoryService(@Autowired DepositoryRepository depositoryRepository) {
        this.depositoryRepository = depositoryRepository;
    }

    public @Nullable Depository getDepository(String name) {
        //TODO: Make sure name is not null?
        return depositoryRepository.findDepositoryByName(name);
    }

    public @Nullable DepositoryEntity getDepositoryEntity(String entityQualifier) {
        //TODO: Make sure entity qualifier is not null?
        return depositoryRepository.findEntityByPath(entityQualifier);
    }

}
