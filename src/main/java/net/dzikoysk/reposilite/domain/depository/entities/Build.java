package net.dzikoysk.reposilite.domain.depository.entities;

import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;

import java.io.File;
import java.util.Collection;

public class Build implements DepositoryEntity {

    private String version;
    private Collection<File> content;

}
