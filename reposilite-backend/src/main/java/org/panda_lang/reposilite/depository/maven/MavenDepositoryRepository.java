package org.panda_lang.reposilite.depository.maven;

import org.panda_lang.panda.utilities.commons.collection.map.TreemapNode;
import org.panda_lang.reposilite.ReposiliteApplication;
import org.panda_lang.reposilite.depository.DepositoryEntity;
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
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
class MavenDepositoryRepository {

    private final File repositoriesRoot;
    private final Map<String, TreemapNode<? extends MavenDepository>> depositories;

    @Autowired
    public MavenDepositoryRepository(@Qualifier("mavenRepositoryDirectory") File repositoriesRoot) {
        this.repositoriesRoot = repositoriesRoot;
        this.depositories = new HashMap<>();
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        ReposiliteApplication.getLogger().info("Loading maven repositories from " + repositoriesRoot + "...");

        MavenDepositoryFactory factory = new MavenDepositoryFactory();
        Collection<MavenDepository> loadedDepositories = factory.loadDepositories(this.repositoriesRoot);

        for (MavenDepository loadedMavenDepository : loadedDepositories) {
            TreemapNode node = loadedMavenDepository.getNode();
            //noinspection unchecked
            this.depositories.put(loadedMavenDepository.getName(), (TreemapNode<? extends MavenDepository>) node);
        }

        if (this.depositories.isEmpty()) {
            ReposiliteApplication.getLogger().warn("Repositories not found!");
            return;
        }

        ReposiliteApplication.getLogger().info("Result: " + this.depositories.size() + " repositories have been found");
    }

    public @Nullable DepositoryEntity findEntityByURLPath(String uri) {
        int index = uri.indexOf('/');
        MavenDepository depository = findDepositoryByName(index == -1 ? uri : uri.substring(0, index));

        if (index == -1 || depository == null) {
            return depository;
        }

        Optional<DepositoryEntity> entity = depository.find(uri.substring(index + 1));

        if (!entity.isPresent()) {
            entity = depository.find(uri);
        }

        return entity.orElse(null);
    }

    private @Nullable TreemapNode<? extends DepositoryEntity> findDepositoryNodeByName(String name) {
        return this.depositories.get(name);
    }

    public @Nullable MavenDepository findDepositoryByName(String name) {
        TreemapNode<? extends MavenDepository> node = depositories.get(name);

        if (node == null) {
            return null;
        }

        return node.getElement();
    }

    public Set<MavenDepository> findAll() {
        return this.depositories.values().stream()
                .map(TreemapNode::getElement)
                .collect(Collectors.toSet());
    }

}
