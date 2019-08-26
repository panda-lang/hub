package org.panda_lang.reposilite.depository;

import java.util.Optional;
import java.util.Set;

public interface DepositoryService {

    Optional<DepositorySubService> getSubService(String subServiceName);

    Set<String> getSubServicesNames();

}
