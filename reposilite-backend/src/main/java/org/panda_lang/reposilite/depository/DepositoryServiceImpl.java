package org.panda_lang.reposilite.depository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
final class DepositoryServiceImpl implements DepositoryService {

    private final Map<String, DepositorySubService> subServiceMap;

    @Autowired
    protected DepositoryServiceImpl(List<DepositorySubService> subServices) {
        this.subServiceMap = new HashMap<>(subServices.size());

        for (DepositorySubService subService : subServices) {
            subServiceMap.put(subService.getName().toLowerCase(), subService);
        }
    }

    @Override
    public Optional<DepositorySubService> getSubService(String subServiceName) {
        return Optional.ofNullable(subServiceMap.get(subServiceName.toLowerCase()));
    }

    @Override
    public Set<String> getSubServicesNames() {
        return subServiceMap.keySet();
    }

}
