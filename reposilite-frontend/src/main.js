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

import Vue from 'vue'
import Vuex from 'vuex'
import Axios from 'axios'
import Buefy from 'buefy'
import 'buefy/dist/buefy.css'

import App from './App.vue'
import { router } from './router'
import { store } from './store/store'
import { notifications } from './services'

Vue.use(Vuex)
Vue.use(Buefy)
Vue.prototype.$http = Axios
Vue.prototype.$notify = notifications
Vue.config.productionTip = false

new Vue({
    el: '#app',
    router: router,
    store,
    render: h => h(App)
}).$mount('#app')
