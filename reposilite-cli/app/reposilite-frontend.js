/*
 * Copyright (c) 2018-2019 Reposilite Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

const spawn = require('cross-spawn-with-kill')
const TextUtils = require('./utils/text-utils')

class ReposiliteFrontend {

    launch() {
        this.frontend = spawn('npm', [ 'start' ], { cwd: '../reposilite-frontend'})
        console.log("Launching frontend...")

        this.frontend.stdout.on('data', (data) => {
            console.log(TextUtils.appendSuffix(TextUtils.trimNL(data.toString()), false, '[reposilite-frontend] ', '', (content) => TextUtils.trimNL(content)))
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