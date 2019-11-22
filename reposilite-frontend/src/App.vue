<!--
  - Copyright (c) 2018-2019 Reposilite Team
  -
  - Licensed under the Apache License, Version 2.0 (the "License");
  - you may not use this file except in compliance with the License.
  - You may obtain a copy of the License at
  -
  -     http://www.apache.org/licenses/LICENSE-2.0
  -
  - Unless required by applicable law or agreed to in writing, software
  - distributed under the License is distributed on an "AS IS" BASIS,
  - WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  - See the License for the specific language governing permissions and
  - limitations under the License.
  -->

<template>
    <div id="app">
        <Welcome v-if="isWelcome()"/>
        <Dashboard v-else/>
    </div>
</template>

<script>
import Menu from './components/Menu.vue'
import Welcome from './components/Welcome'
import Dashboard from './components/Dashboard'

export default {
    components: {
        Dashboard,
        Welcome,
        Menu
    },
    methods: {
        getUser() {
            return this.$store.state.user
        },
        isWelcome() {
            return !this.getUser() && this.$route.name === 'Home'
        }
    },
    created() {
        this.$store.dispatch('fetchUser')
    }
}
</script>

<style lang="scss">
//noinspection CssUnknownTarget
@import url(~toastr/toastr.scss);
</style>

<style lang="stylus">
html
    background-color #efefef !important

#app
    text-align right

.page-content-container
    padding-top 27px

.page-content
    padding 17px
    background-color white
    min-height 107px
    text-align left

a
    text-decoration none
</style>
