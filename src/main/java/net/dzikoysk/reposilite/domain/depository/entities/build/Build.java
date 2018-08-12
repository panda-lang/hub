package net.dzikoysk.reposilite.domain.depository.entities.build;

import net.dzikoysk.reposilite.domain.depository.entities.AbstractDepositoryEntity;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Build extends AbstractDepositoryEntity {

    private final String version;
    private final Map<String, Data> content;

    public Build(String version) {
        this.version = version;
        this.content = new HashMap<>();
    }

    public void addContent(File file) {
        content.put(file.getName(), new Data(file));
    }

    public Data getData(String dataName) {
        return content.get(dataName);
    }

    public Collection<? extends Data> getContent() {
        return Collections.unmodifiableCollection(content.values());
    }

    public String getVersion() {
        return version;
    }

    @Override
    public String getName() {
        return getVersion();
    }

}
