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

const config = require('../config')

const backend = config['backend']
const port = config['port']

export const USER_DETAILS = `${backend}/api/users/me`
export const SIGNIN_ENDPOINT_URL = `${backend}/api/users/signin`
export const SIGNUP_ENDPOINT_URL = `${backend}/api/users/signup`
export const GITHUB_OAUTH_URL = `${backend}/oauth2/authorize/github?redirect_uri=http://localhost:${port}/oauth2/redirect`