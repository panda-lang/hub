package net.dzikoysk.reposilite.domain.depository.entities;

import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;
import org.springframework.lang.NonNull;

import java.io.File;
import java.util.Collection;
import java.util.Collections;

public class Build implements DepositoryEntity {

    private String version;
    private Collection<File> content;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Collection<File> getContent() {
        return Collections.unmodifiableCollection(content);
    }

    public void addContent(@NonNull File file) {
        content.add(file);
    }

    public void removeContent(@NonNull File file) {
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
