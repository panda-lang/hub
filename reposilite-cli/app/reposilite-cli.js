const figlet = require('figlet');

console.log(figlet.textSync('Reposilite  CLI'));
console.log("")

let configuration = require('./reposilite-config')
configuration.initialize()

let launcher = require('./reposilite-launcher')
launcher.launch()
