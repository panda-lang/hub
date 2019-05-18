const spawn = require('cross-spawn-with-kill')

class ReposiliteBackend {

    launch() {
        this.backend = spawn('../reposilite-backend/mvnw', [ 'spring-boot:run', '-f', '../reposilite-backend/pom.xml' ], { cwd: '../reposilite-workspace/'})
        console.log("Launching backend...")

        this.backend.stdout.on('data', (data) => {
            process.stdout.write(data.toString().replace(/\n/g, "\n[reposilite-backend]"))
        });

        const that = this

        this.backend.on('exit', (code, signal) => {
            console.warn(`[reposilite-backend] process exited with code ${code} and signal ${signal}`)
            that.backend = null
        })
    }

    shutdown() {
        if (this.isActive()) {
            this.backend.stdin.pause()
            this.backend.kill()
        }
    }

    isActive() {
        return this.backend != null
    }

}

module.exports = ReposiliteBackend