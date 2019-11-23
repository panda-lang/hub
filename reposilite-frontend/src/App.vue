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
    <div id="app" :class='{ welcome }'>
        <Welcome v-if="welcome"/>
        <Dashboard v-else/>
    </div>
</template>

<script>
import { mapState } from 'vuex'

import Welcome from './components/Welcome'
import Dashboard from './components/Dashboard'

export default {
    components: {
        Dashboard,
        Welcome
    },
    computed: {
        ...mapState({
            user: state => state.user
        }),
        welcome: function () {
            return !this.user && this.$route.name === 'Home'
        }
    }
}
</script>

<style lang="scss">
//noinspection CssUnknownTarget
@import url(~toastr/toastr.scss);
</style>

<style lang="stylus">
html, body
    height: 100%
    margin: 0
    padding: 0
    overflow hidden

#app
    height: 100%

.page-content-container
    margin-top 27px

.page-content
    margin 17px
    background-color white
    min-height 107px
    text-align left

a
    text-decoration none
</style>
