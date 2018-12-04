package org.panda_lang.reposilite.depository.maven;

import org.panda_lang.reposilite.ReposiliteApplication;
import org.panda_lang.reposilite.depository.DepositoryEntity;
import org.panda_lang.reposilite.depository.DepositoryNotFoundException;
import org.panda_lang.reposilite.utils.collection.TreeMapNode;
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
public class MavenDepositoryRepository {

    private final File repositoriesRoot;
    private final Map<String, TreeMapNode<? extends DepositoryEntity>> depositories;

    @Autowired
    public MavenDepositoryRepository(@Qualifier("mavenRepositoryDirectory") File repositoriesRoot) {
        this.repositoriesRoot = repositoriesRoot;
        this.depositories = new HashMap<>();
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        ReposiliteApplication.getLogger().info("Loading maven repositories...");

        MavenDepositoryFactory factory = new MavenDepositoryFactory();
        Collection<MavenDepository> loadedDepositories = factory.loadDepositories(this.repositoriesRoot);

        for (MavenDepository loadedMavenDepository : loadedDepositories) {
            this.depositories.put(loadedMavenDepository.getName(), loadedMavenDepository.getNode());
        }

        if (this.depositories.isEmpty()) {
            ReposiliteApplication.getLogger().warn("Repositories not found!");
            return;
        }

        ReposiliteApplication.getLogger().info("Result: " + this.depositories.size() + " repositories have been found");
    }

    public DepositoryEntity findEntityByURLPath(MavenDepository mavenDepository, String url) {
        DepositoryEntity entity = mavenDepository.find(url.split("/"));

        if (entity == null) {
            entity = mavenDepository.findGroupUnit(url.replace("/", "."));
        }

        return entity;
    }

    private @Nullable TreeMapNode<? extends DepositoryEntity> findDepositoryNodeByName(String name) {
        TreeMapNode<? extends DepositoryEntity> node = this.depositories.get(name);
        return node != null && node.getElement() instanceof MavenDepository ? node : null;
    }

    public @Nullable MavenDepository findDepositoryByName(String name) {
        if (this.depositories.get(name) == null) {
            throw new DepositoryNotFoundException();
        }

        return (MavenDepository) this.depositories.get(name).getElement();
    }

    public Set<MavenDepository> findAll() {
        return this.depositories.values().stream()
                .filter(node -> node.getElement() instanceof MavenDepository)
                .map(node -> (MavenDepository) node.getElement())
                .collect(Collectors.toSet());
    }

}
