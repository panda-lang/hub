const prompts = require('prompts')

const questions = [
    require('./questions/variant-question')
]

async function initialize() {
    const response = await prompts(questions)
    console.log(response)
}

module.exports = { initialize }