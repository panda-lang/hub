let childProcess = require('child_process');

let launch = function (config) {
    console.log("Launching config: " + JSON.stringify(config));

    console.log("Launching backend...")
    launchBackend()

    if (config['variant'] === 'full') {
        console.log("Launching frontend...")
        launchFrontend()
    }
}

function launchFrontend() {

}

function launchBackend() {

}

module.exports = { launch }