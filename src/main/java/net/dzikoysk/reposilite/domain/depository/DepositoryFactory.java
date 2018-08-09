package net.dzikoysk.reposilite.domain.depository;

import java.io.File;

public class DepositoryFactory {

    public Depository loadDepository(File depositoryDirectory) {
        if (!depositoryDirectory.isDirectory()) {
            throw new IllegalArgumentException("Depository root file should be a directory");
        }

        Depository depository = new Depository(depositoryDirectory);
        loadGroups(depository);

        return depository;
    }

    private void loadGroups(Depository depository) {
        File[] subdirectories = depository.getRootFile().listFiles();

        if (subdirectories == null) {
            return;
        }
    }

}
