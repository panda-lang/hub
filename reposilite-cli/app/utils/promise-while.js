/*
 * Copyright (c) 2018-2019 Reposilite Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

const Promise = require('bluebird')

function promiseWhile(condition, action) {
    const resolver = Promise.defer()

    const loop = () => {
        if (!condition()) {
            return resolver.resolve()
        }

        return Promise.cast(action())
            .then(loop)
            .catch(resolver.reject)
    }

    process.nextTick(loop)
    return resolver.promise
}

async function promiseWhileDelayed(condition, delay) {
    return promiseWhile(condition, () => createDelay(delay))
}

function createDelay(delay) {
    return new Promise((resolve) => setTimeout(() => resolve(), delay))
}

module.exports = { promiseWhile, promiseWhileDelayed }