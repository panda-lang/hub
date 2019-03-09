const fs = require('fs')
const prompts = require('prompts')
const questions = require('./reposilite-questions')

const configPath = 'config.yml'

async function initialize() {
    const init = await prompts(questions.init)
    let config;

    if (fs.existsSync(configPath)) {
        config = JSON.parse(fs.readFileSync(configPath))
    }
    
    if (config == null) {
        config = await prompts(questions.config)

        fs.writeFileSync(configPath, JSON.stringify(config), function (err) {
            if (err) {
                console.log('Cannot save file! Caused by: ' + err)
                process.exit()
            }
        })
    }

    console.log("Results:")
    console.log(init)
    console.log(config)
}

module.exports = { initialize }