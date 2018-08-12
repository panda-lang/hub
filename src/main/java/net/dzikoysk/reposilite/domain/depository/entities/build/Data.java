package net.dzikoysk.reposilite.domain.depository.entities.build;

import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;

import java.io.File;

public class Data implements DepositoryEntity {

    private final File file;

    public Data(File file) {
        this.file = file;
    }

    public String getName() {
        return file.getName();
    }

    public File getFile() {
        return file;
    }

}
