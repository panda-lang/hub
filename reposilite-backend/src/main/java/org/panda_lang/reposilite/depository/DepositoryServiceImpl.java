package org.panda_lang.reposilite.depository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DepositoryServiceImpl implements DepositoryService {

    private final DepositoryRepository depositoryRepository;

    @Autowired
    public DepositoryServiceImpl(DepositoryRepository depositoryRepository) {
        this.depositoryRepository = depositoryRepository;
    }

    @Override
    public @Nullable Depository getDepository(String name) {
        return depositoryRepository.findDepositoryByName(name);
    }

    @Override
    public @Nullable DepositoryEntity getDepositoryEntity(Depository depository, String entityQualifier) {
        return depositoryRepository.findEntityByURLPath(depository, entityQualifier);
    }

    @Override
    public Set<String> getNames() {
        return depositoryRepository.findAll().stream()
                .map(Depository::getName)
                .collect(Collectors.toSet());
    }

}
