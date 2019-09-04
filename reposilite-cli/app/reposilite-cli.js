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
