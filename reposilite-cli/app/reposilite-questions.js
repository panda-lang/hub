const init = [
    require('./questions/init-variant-question'),
    require('./questions/init-reinitialize-config-question')
]

const config = [
    require('./questions/config-port-questions'),
    require('./questions/config-mongodb-uri-question')
]

module.exports = { init, config }