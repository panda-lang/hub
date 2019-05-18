const spawn = require('cross-spawn-with-kill')
const trim = require('trim-newlines')

class ReposiliteBackend {

    launch() {
        this.backend = spawn('../reposilite-backend/mvnw', [ 'spring-boot:run', '-f', '../reposilite-backend/pom.xml' ], { cwd: '../reposilite-workspace/'})
        console.log("Launching backend...")

        let requiresNL

        this.backend.stdout.on('data', (data) => {
            let message = data.toString()

            if (requiresNL) {
                message = "\n" + message
                requiresNL = false
            }

            if (message.endsWith("\n")) {
                requiresNL = true
                message = trim.end(message)
            }

            process.stdout.write(message.replace(/\n/g, "\n[reposilite-backend] "))
        });

        const that = this

        this.backend.on('exit', (code, signal) => {
            console.warn(`[reposilite-backend] process exited with code ${code} and signal ${signal}`)
            that.backend = null
        })
    }

    execute(command) {
        this.backend.stdin.write(command + "\n")
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