const ReposiliteFrontend = require('./reposilite-frontend')
const { _, promiseWhileDelayed } = require('./utils/promise-while')

const color = require('cli-color')
const stdin = process.openStdin()

let backend
let frontend

async function launch (config) {
    //launchBackend()

    if (config['variant'] === 'full') {
        frontend = new ReposiliteFrontend()
        frontend.launch()
    }

    stdin.addListener('data', (value) => {
        executeCommand(value.toString().trim())
    })

    await promiseWhileDelayed(() => backend && backend.isActive() || frontend && frontend.isActive(), 250)
}

function executeCommand(command) {
    switch (command) {
        case 'stop':
            frontend.shutdown()
            stdin.pause()
            break
        case 'status':
            console.log("• Reposilite Frontend: " + (frontend ? color.green("Active") : color.red("Inactive")))
            console.log("• Reposilite Backend: " + (backend ? color.green("Active") : color.red("Inactive")))
            break
        default:
            console.warn("Unknown command: " + command)
            break
    }
}

module.exports = { launch }