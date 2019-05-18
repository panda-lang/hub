const init = [
    require('./questions/init-variant-question'),
    require('./questions/init-reinitialize-config-question')
];

const config = [
    require('./questions/config-port-questions')
]

module.exports = { init, config }