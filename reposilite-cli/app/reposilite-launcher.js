const ReposiliteBackend = require('./reposilite-backend')
const ReposiliteFrontend = require('./reposilite-frontend')
const { _, promiseWhileDelayed } = require('./utils/promise-while')

const color = require('cli-color')
const stdin = process.openStdin()

let backend
let frontend

async function launch (config) {
    if (config['variant'].includes('backend')) {
        backend = new ReposiliteBackend()
        backend.launch(config)
    }

    if (config['variant'].includes('frontend')) {
        frontend = new ReposiliteFrontend()
        frontend.launch(config)
    }

    stdin.addListener('data', (value) => {
        setTimeout(() => executeCommand(value.toString().trim()), 50)
    })

    await promiseWhileDelayed(() => backend && backend.isActive() || frontend && frontend.isActive(), 250)
}

function executeCommand(command) {
    switch (true) {
        case 'stop' === command:
            console.log("Shutting down...")
            frontend.shutdown()
            backend.shutdown()
            stdin.pause()
            return
        case 'status' === command:
            console.log(" • Reposilite Frontend: " + (frontend ? color.green("Active") : color.red("Inactive")))
            console.log(" • Reposilite Backend: " + (backend ? color.green("Active") : color.red("Inactive")))
            break
        case command.startsWith('f '):
            frontend.execute(command.replace("f ", "").trim())
            break
        case command.startsWith('b '):
            backend.execute(command.replace("b ", "").trim())
            break
        case 'help' === command:
            console.log(' Reposilite CLI Commands:')
            console.log('    stop - stop the services and cli')
            console.log('    status - check status of services')
            console.log('    f <frontend-command> - execute command in the frontend service')
            console.log('    b <backend-command> - execute command in the backend service')
            break
        case '' === command:
            break
        default:
            console.warn("Unknown command: " + command)
            break
    }

    process.stdout.write(":> ")
}

module.exports = { launch }