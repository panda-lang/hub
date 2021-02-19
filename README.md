<h1>Hub
    <a href="https://github.com/panda-lang/hub/actions/workflows/gradle.yml"><img src="https://github.com/panda-lang/hub/actions/workflows/gradle.yml/badge.svg" /></a>
    <a href="https://travis-ci.com/panda-lang/hub"><img src="https://travis-ci.com/panda-lang/hub.svg?branch=master" alt="Build Status"></a>
    <a href="https://www.codefactor.io/repository/github/panda-lang/hub"><img src="https://www.codefactor.io/repository/github/panda-lang/hub/badge" alt="CodeFactor"></a>
</h1>

Panda Hub is the module manager registry for amazing Panda (+JVM) based projects 📜 <br>
~ <a href="https://panda-lang.org/">panda-lang.org</a> :wq


#### 🧬 Stack
- Hub Backend: Kotlin + Ktor *(Netty)* + OAuth2 + MongoDB + JUnit
- Hub Frontend: React + Next.js + Chakra UI

#### 📋 Installation
Requirements:

- Java 8+
- Node.js
- MongoDB

Environment variables for server:

```conf
GITHUB_CLIENT_ID = $id
GITHUB_CLIENT_SECRET = $secret
```

Building from the source:

```bash
$ git clone https://github.com/panda-lang/hub.git
$ cd hub

# hub-backend (lohalhost:8080)
$ cd hub-backend && ./gradlew run

# hub-frontend (localhost:3000)
$ cd hub-frontend && npm install && npm run dev
```

#### 💞 See also
- [Issues](https://github.com/panda-lang/hub/issues)
- [Panda](https://github.com/panda-lang/panda)
