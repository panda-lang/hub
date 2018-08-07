package net.dzikoysk.reposilite.service.depository;

import net.dzikoysk.reposilite.domain.depository.Depository;
import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;
import net.dzikoysk.reposilite.repository.depository.DepositoryRepository;
import net.dzikoysk.reposilite.repository.depository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DepositoryService {

    private final DepositoryRepository depositoryRepository;
    private final GroupRepository groupRepository;

    @Autowired
    public DepositoryService(DepositoryRepository depositoryRepository, GroupRepository groupRepository) {
        this.depositoryRepository = depositoryRepository;
        this.groupRepository = groupRepository;
    }

    public @Nullable Depository getDepository(String name) {
        return depositoryRepository.findDepositoryByName(name);
    }

    public @Nullable DepositoryEntity getDepositoryEntity(String entityQualifier) {
        return depositoryRepository.findEntityByPath(entityQualifier);
    }

    public Set<String> getNames() {
        return depositoryRepository.findAll().stream()
                .map(Depository::getName)
                .collect(Collectors.toSet());
    }

}
