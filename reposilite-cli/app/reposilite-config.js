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

const fs = require('fs')
const prompts = require('prompts')
const questions = require('./reposilite-questions')

const configPath = '../reposilite-workspace/config.yml'
const configExists = fs.existsSync(configPath)

async function initialize () {
	const init = await initializeQuestions()
	const file = await loadConfigurationFile(init)

	return Object.assign({}, init, file)
}

async function initializeQuestions () {
	return await prompts(questions.init)
}

async function loadConfigurationFile (init) {
	if (configExists && !init['reinitialize-configuration']) {
		return JSON.parse(fs.readFileSync(configPath).toString())
	}

	const config = await prompts(questions.config)

	fs.writeFileSync(configPath, JSON.stringify(config), (err) => {
		if (err) {
			console.log('Cannot save file! Caused by: ' + err)
			process.exit()
		}
	})

	return config
}

module.exports = { initialize }
