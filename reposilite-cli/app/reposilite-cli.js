const figlet = require('figlet');
const moment = require('moment');
const uptime = moment();

async function launch() {
    console.log(figlet.textSync('Reposilite  CLI'));
    console.log()

    let configuration = require('./reposilite-config')
    let config = await configuration.initialize()

    console.log("Launching config: " + JSON.stringify(config));

    let launcher = require('./reposilite-launcher')
    await launcher.launch(config)
}

launch().then(() => console.log("~ Bye! Uptime: " + uptime.toNow(true) + " ฅ^•ﻌ•^ฅ "))
