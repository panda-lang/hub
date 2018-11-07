package org.panda_lang.reposilite.depository;

public class DepositoryNode {

    private final String nodeName;
    private final DepositoryEntity entity;

    public DepositoryNode(String nodeName, DepositoryEntity entity) {
        this.nodeName = nodeName;
        this.entity = entity;
    }

    public DepositoryEntity getEntity() {
        return entity;
    }

    public String getNodeName() {
        return nodeName;
    }

}
