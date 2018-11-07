package org.panda_lang.reposilite.depository;

import java.io.Serializable;

class DepositoryResponse implements Serializable {

    private String path;
    private String[] filesList;

    DepositoryResponse(String path, String[] filesList) {
        this.path = path;
        this.filesList = filesList;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String[] getFilesList() {
        return this.filesList;
    }

    public void setFilesList(String[] filesList) {
        this.filesList = filesList;
    }

}
