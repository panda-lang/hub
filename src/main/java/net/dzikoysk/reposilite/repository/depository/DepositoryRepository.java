package net.dzikoysk.reposilite.repository.depository;

import net.dzikoysk.reposilite.ReposiliteApplication;
import net.dzikoysk.reposilite.domain.depository.Depository;
import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;
import net.dzikoysk.reposilite.domain.depository.DepositoryFactory;
import net.dzikoysk.reposilite.utils.FilesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepositoryRepository {

    private final File repositoriesRoot;
    private final Map<String, Depository> depositories;

    @Autowired
    public DepositoryRepository(@Qualifier("getRepositoriesDirectory") File repositoriesRoot) {
        this.repositoriesRoot = repositoriesRoot;
        this.depositories = new HashMap<>(FilesUtils.getAmountOfFiles(repositoriesRoot));
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        ReposiliteApplication.getLogger().info("Loading repositories...");

        DepositoryFactory factory = new DepositoryFactory();
        Collection<Depository> loadedDepositories = factory.loadDepositories(repositoriesRoot);

        for (Depository loadedDepository : loadedDepositories) {
            addDepository(loadedDepository);
        }

        if (depositories.isEmpty()) {
            ReposiliteApplication.getLogger().warn("Repositories not found!");
            return;
        }

        ReposiliteApplication.getLogger().info("Result: " + depositories.size() + " repositories have been found");
    }

    public void addDepository(Depository depository) {
        depositories.put(depository.getName(), depository);
    }

    public @Nullable DepositoryEntity findEntityByPath(String path) {
        return null;
    }

    public @Nullable Depository findDepositoryByName(String name) {
        return depositories.get(name);
    }

    public Collection<? extends Depository> findAll() {
        return depositories.values();
    }

}
