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
const trim = require('trim-newlines')
const java = require('./utils/java-utils')

class ReposiliteBackend {
	launch (config) {
		console.log('Launching backend...')

		const env = Object.create(process.env)
		env.MAVEN_OPTS = java.optionsToParameters(config)

		this.backend = spawn('../reposilite-backend/mvnw', ['spring-boot:run', '-f', '../reposilite-backend/pom.xml'], {
			cwd: '../reposilite-workspace/',
			env: env
		})

		this.backend.on('error', (error) => {
			console.error(error)
		})

		let requiresNL

		this.backend.stdout.on('data', (data) => {
			let message = data.toString()

			if (requiresNL) {
				message = '\n' + message
				requiresNL = false
			}

			if (message.endsWith('\n')) {
				requiresNL = true
				message = trim.end(message)
			}

			process.stdout.write(message.replace(/\n/g, '\n[reposilite-backend] '))
		})

		const that = this

		this.backend.on('exit', (code, signal) => {
			console.warn(`[reposilite-backend] process exited with code ${code} and signal ${signal}`)
			that.backend = null
		})
	}

	execute (command) {
		this.backend.stdin.write(command + '\n')
	}

	shutdown () {
		if (this.isActive()) {
			this.backend.stdin.pause()
			this.backend.kill()
		}
	}

	isActive () {
		return this.backend != null
	}
}

module.exports = ReposiliteBackend
