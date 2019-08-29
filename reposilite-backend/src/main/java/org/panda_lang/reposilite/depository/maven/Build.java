package org.panda_lang.reposilite.depository.maven;

import org.panda_lang.reposilite.depository.AbstractDepositoryEntity;
import org.springframework.lang.Nullable;

import java.io.File;
import java.util.Collection;

public final class Build extends AbstractDepositoryEntity {

    Build(String version) {
        super(version);
    }

    public void addContent(File file) {
        super.addEntity(new Data(file));
    }

    public @Nullable Data getData(String dataName) {
        return super.getMappedChildrenOfType(Data.class).get(dataName);
    }

    public Collection<? extends Data> getContent() {
        return super.getChildrenOfType(Data.class);
    }

}
