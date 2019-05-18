const fs = require('fs')
const prompts = require('prompts')
const questions = require('./reposilite-questions')

const configPath = '../reposilite-workspace/config.yml'
const configExists = fs.existsSync(configPath)

async function initialize() {
    const init = await initializeQuestions()
    const file = await loadConfigurationFile(init)

    return Object.assign({}, init, file)
}

async function initializeQuestions() {
    return await prompts(questions.init)
}

async function loadConfigurationFile(init) {
    if (configExists && !init['reinitialize-configuration']) {
        return JSON.parse(fs.readFileSync(configPath).toString())
    }

    let config = await prompts(questions.config)

    fs.writeFileSync(configPath, JSON.stringify(config), function (err) {
        if (err) {
            console.log('Cannot save file! Caused by: ' + err)
            process.exit()
        }
    })

    return config
}

module.exports = { initialize }