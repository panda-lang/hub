const Promise = require('bluebird')

function promiseWhile(condition, action) {
    const resolver = Promise.defer();

    const loop = function () {
        if (!condition()) {
            return resolver.resolve();
        }

        return Promise.cast(action())
            .then(loop)
            .catch(resolver.reject);
    };

    process.nextTick(loop);
    return resolver.promise;
}

async function promiseWhileDelayed(condition, delay) {
    return promiseWhile(condition, () => createDelay(delay))
}

function createDelay(delay) {
    return new Promise((resolve) => setTimeout(() => resolve(), delay))
}

module.exports = { promiseWhile, promiseWhileDelayed }