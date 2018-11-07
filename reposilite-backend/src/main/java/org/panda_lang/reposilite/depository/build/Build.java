package org.panda_lang.reposilite.depository.build;

import org.panda_lang.reposilite.depository.AbstractDepositoryEntity;
import org.springframework.lang.Nullable;

import java.io.File;
import java.util.Collection;

public class Build extends AbstractDepositoryEntity {

    Build(String version) {
        super(version);
    }

    public void addContent(File file) {
        super.addElement(new Data(file));
    }

    public @Nullable Data getData(String dataName) {
        return super.getMappedChildrenOfType(Data.class).get(dataName);
    }

    public Collection<? extends Data> getContent() {
        return super.getChildrenOfType(Data.class);
    }

}
