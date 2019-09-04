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

module.exports = {
    type: 'select',
    name: 'variant',
    message: 'Select the services to launch',
    choices: [
        { title: 'Reposilite Backend (server)', value: 'backend' },
        { title: 'Reposilite Frontend (website)', value: 'frontend' },
        { title: 'Reposilite Backend (server) + Frontend (website)', value: 'backend + frontend' }
    ],
    initial: 2
}