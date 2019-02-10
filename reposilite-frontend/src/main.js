import Vue from 'vue'
import App from './App'
import router from './router'
import Vuelidate from 'vuelidate'

Vue.use(Vuelidate)

new Vue({
    router: router,
    render: h => h(App)
}).$mount('#app')
