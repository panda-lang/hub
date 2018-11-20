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
        return (T) this;
    }

    public T withDisplayName(String displayName) {
        this.displayName = displayName;
        return (T) this;
    }

    public T withDescription(String description) {
        this.description = description;
        return (T) this;
    }

    public T withEmail(String email) {
        this.email = email;
        return (T) this;
    }

    public T withSite(String site) {
        this.site = site;
        return (T) this;
    }

}
