package net.dzikoysk.reposilite.service.auth;

import net.dzikoysk.reposilite.*;
import org.springframework.stereotype.*;

@Service
public class UserService {

    public UserService() {
        ReposiliteApplication.getLogger().warn("Instance");
    }

}
