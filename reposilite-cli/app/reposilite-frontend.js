const spawn = require('cross-spawn-with-kill')
const TextUtils = require('./utils/text-utils')

class ReposiliteFrontend {

    launch() {
        this.frontend = spawn('npm', [ 'start' ], { cwd: '../reposilite-frontend'})
        console.log("Launching frontend...")

        this.frontend.stdout.on('data', (data) => {
            console.log(TextUtils.appendSuffix(TextUtils.trimNL(data.toString()), false, '[reposilite-frontend] ', '', content => TextUtils.trimNL(content)))
        })

        const that = this

        this.frontend.on('exit', (code, signal) => {
            console.warn(`[reposilite-frontend] process exited with code ${code} and signal ${signal}`)
            that.frontend = null
        })
    }

    execute(command) {
        this.frontend.stdin.write(command + "\n")
    }

    shutdown() {
        if (this.isActive()) {
            this.frontend.stdin.pause()
            this.frontend.kill()
        }
    }

    isActive() {
        return this.frontend != null
    }

}

module.exports = ReposiliteFrontend