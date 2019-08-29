package org.panda_lang.reposilite.depository.maven;

import java.nio.file.Path;

final class MavenMetadataPaths {

    private final Path buildDirectory;
    private final Path buildFile;

    MavenMetadataPaths(Path buildDirectory, Path buildFile) {
        this.buildDirectory = buildDirectory;
        this.buildFile = buildFile;
    }

    public Path getBuildFile() {
        return buildFile;
    }

    public Path getBuildDirectory() {
        return buildDirectory;
    }

}
