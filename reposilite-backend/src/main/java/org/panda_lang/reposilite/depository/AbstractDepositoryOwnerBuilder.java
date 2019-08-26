package org.panda_lang.reposilite.depository;

import org.panda_lang.reposilite.utils.Buildable;

public abstract class AbstractDepositoryOwnerBuilder<T extends Buildable<? extends DepositoryOwner>> {

    protected String name;
    protected String displayName;
    protected String description;
    protected String email;
    protected String site;

    public T withName(String name) {
        this.name = name;
        return returnThis();
    }

    public T withDisplayName(String displayName) {
        this.displayName = displayName;
        return returnThis();
    }

    public T withDescription(String description) {
        this.description = description;
        return returnThis();
    }

    public T withEmail(String email) {
        this.email = email;
        return returnThis();
    }

    public T withSite(String site) {
        this.site = site;
        return returnThis();
    }

    @SuppressWarnings("unchecked")
    private T returnThis() {
        return (T) this;
    }

}
