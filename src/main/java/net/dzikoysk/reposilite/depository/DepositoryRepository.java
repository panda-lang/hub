package net.dzikoysk.reposilite.depository;

import net.dzikoysk.reposilite.ReposiliteApplication;
import net.dzikoysk.reposilite.depository.DepositoryEntity;
import net.dzikoysk.reposilite.depository.Depository;
import net.dzikoysk.reposilite.depository.DepositoryFactory;
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
    private final Map<String, TreeMapNode<? extends DepositoryEntity>> depositories;

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
            depositories.put(loadedDepository.getName(), loadedDepository.getNode());
        }

        if (depositories.isEmpty()) {
            ReposiliteApplication.getLogger().warn("Repositories not found!");
            return;
        }

        ReposiliteApplication.getLogger().info("Result: " + depositories.size() + " repositories have been found");
    }

    public @Nullable DepositoryEntity findEntityByURLPath(Depository depository, String url) {
        DepositoryEntity entity = depository.find(url.split("/"));

        if (entity == null) {
            entity = depository.findGroupUnit(url.replace("/", "."));
        }

        return entity;
    }

    private @Nullable TreeMapNode<? extends DepositoryEntity> findDepositoryNodeByName(String name) {
        TreeMapNode<? extends DepositoryEntity> node = depositories.get(name);
        return node != null && node.getElement() instanceof Depository ? node : null;
    }

    public Depository findDepositoryByName(String name) {
        return (Depository) depositories.get(name).getElement();
    }

    public Set<Depository> findAll() {
        return depositories.values().stream()
                .filter(node -> node.getElement() instanceof Depository)
                .map(node -> (Depository) node.getElement())
                .collect(Collectors.toSet());
    }

}
