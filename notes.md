#### Technologies
Backend:
* Java 8
* Spring
* MongoDB / Local json

Frontend:
* TypeScript
* React
* MobX
* Ant Design

#### Concept
* Plain maven repository without indexing
* Repository interface
* Dynamic routing, support mulitple domains
* Monolith

#### Modules
Artifact repository:
* Maven support
* Panda/Light (json response with git url)
* Maven metadata files support
* Simple auth

Reposilite Interface:
* Admin panel
  * Config
  * Stats
  * User administration
  * Plugins (Optional)
  * Themes (Optional)
* Artifact browser
* Project profiles
* Users/Organizations
* Artifact uploader
* Registration
* Stats
* Permissions

Common:
* Accounts

#### Routing
```
{root}:
+-/                        # home
+-/search                  # browsing results

+-/login                   # login
+-/register                # register
+-/settings                # settings

+-/{user/organization}
  +---/                     # user/organization profile, project list
  +---/{project}
      +---/                 # project profile, github, markdown description
      +---/versions         # list of all artifact versions

+-/repository
  +---/                     # list of repositories
  +---/{repository}
      +---/                 # hidden
      +---/{artifact-path}  # artifact

+-/create                   # Create project
+-/upload                   # Upload artifact
```

#### Code style
Consistent with the Java Coding Convention
* K&R
* 4 spaces
* Always with braces
