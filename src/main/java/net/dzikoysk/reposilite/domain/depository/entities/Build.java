package net.dzikoysk.reposilite.domain.depository.entities;

import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class Build implements DepositoryEntity {

    private final String version;
    private final Collection<File> content;

    public Build(String version) {
        this.version = version;
        this.content = new HashSet<>();
    }

    public String getVersion() {
        return version;
    }

    public Collection<File> getContent() {
        return Collections.unmodifiableCollection(content);
    }

    public void addContent(File file) {
        content.add(file);
    }

    public void removeContent(File file) {
        //TODO: Delete file?
        content.remove(file);
    }

    public void clearContent() {
        //TODO: Probably uncomment if files are gonna be deleted.
        //for (File file : content) {
        //    removeContent(file);
        //}
        content.clear();
    }

}
