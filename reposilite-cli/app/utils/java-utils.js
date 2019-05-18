function optionsToParameters(options) {
    let parameters = ''

    for (let key in options) {
        if (options.hasOwnProperty(key)) {
            parameters += ' -D' + key + '="' + options[key] + '"'
        }
    }

    return parameters
}

module.exports = { optionsToParameters }