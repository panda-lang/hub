package net.dzikoysk.reposilite.service.auth;

import net.dzikoysk.reposilite.ReposiliteApplication;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserService() {
        ReposiliteApplication.getLogger().warn("Instance");
    }

}
