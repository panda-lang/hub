package net.dzikoysk.reposilite.domain.depository.entities.build;

import net.dzikoysk.reposilite.domain.depository.entities.AbstractDepositoryEntity;

import java.io.File;

public class Data extends AbstractDepositoryEntity {

    private final File file;

    Data(File file) {
        super(file.getName());
        this.file = file;
    }

    public File getFile() {
        return file;
    }

}
