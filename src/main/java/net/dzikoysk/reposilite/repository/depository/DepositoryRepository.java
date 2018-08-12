package net.dzikoysk.reposilite.repository.depository;

import net.dzikoysk.reposilite.ReposiliteApplication;
import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;
import net.dzikoysk.reposilite.domain.depository.entities.Depository;
import net.dzikoysk.reposilite.domain.depository.entities.DepositoryFactory;
import net.dzikoysk.reposilite.utils.collection.TreeMapNode;
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
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class DepositoryRepository {

    private final File repositoriesRoot;
    private final Map<String, TreeMapNode<DepositoryEntity>> depositories;

    @Autowired
    public DepositoryRepository(@Qualifier("getRepositoriesDirectory") File repositoriesRoot) {
        this.repositoriesRoot = repositoriesRoot;
        this.depositories = new HashMap<>();
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        ReposiliteApplication.getLogger().info("Loading repositories...");

        DepositoryFactory factory = new DepositoryFactory();
        Collection<Depository> loadedDepositories = factory.loadDepositories(repositoriesRoot);

        for (Depository loadedDepository : loadedDepositories) {
            depositories.put(loadedDepository.getName(), loadedDepository.toTreeMapNode());
        }

        if (depositories.isEmpty()) {
            ReposiliteApplication.getLogger().warn("Repositories not found!");
            return;
        }

        ReposiliteApplication.getLogger().info("Result: " + depositories.size() + " repositories have been found");
    }

    public @Nullable DepositoryEntity findEntityByURLPath(Depository depository, String url) {
        TreeMapNode<DepositoryEntity> depositoryNode = findDepositoryNodeByName(depository.getName());

        DepositoryEntity entity = null;

        return entity;
    }

    public Depository findDepositoryByName(String name) {
        return (Depository) depositories.get(name).getElement();
    }

    private @Nullable TreeMapNode<DepositoryEntity> findDepositoryNodeByName(String name) {
        TreeMapNode<DepositoryEntity> node = depositories.get(name);
        return node != null && node.getElement() instanceof Depository ? node : null;
    }

    public Set<Depository> findAll() {
        return depositories.values().stream()
                .filter(node -> node.getElement() instanceof Depository)
                .map(node -> (Depository) node.getElement())
                .collect(Collectors.toSet());
    }

}
