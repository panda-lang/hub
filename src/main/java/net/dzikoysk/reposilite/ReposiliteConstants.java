package net.dzikoysk.reposilite;

import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;

public final class ReposiliteConstants {

    public static final String REPOSILITE_VERSION = "indev-0.0.2";

    public static final String SPRING_BOOT_VERSION = SpringBootVersion.getVersion();

    public static final String SPRING_VERSION = SpringVersion.getVersion();

    private ReposiliteConstants() {
    }

}
