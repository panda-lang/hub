const figlet = require('figlet')
const moment = require('moment')
const uptime = moment()

async function launch() {
    console.log(figlet.textSync('Reposilite  CLI'))
    console.log()

    const configuration = require('./reposilite-config')
    const config = await configuration.initialize()

    let launcher = require('./reposilite-launcher')
    await launcher.launch(config)
}

launch().then(() => console.log("~ Bye! Uptime: " + uptime.toNow(true) + " ฅ^•ﻌ•^ฅ "))
