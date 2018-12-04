package org.panda_lang.reposilite.depository;

import java.io.Serializable;

public class DepositoryResponse implements Serializable {

    private String path;
    private String[] files;

    public DepositoryResponse(String path, String[] files) {
        this.path = path;
        this.files = files;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String[] getFiles() {
        return this.files;
    }

    public void setFiles(String[] files) {
        this.files = files;
    }

}
