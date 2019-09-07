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
        <b-navbar class="navbar is-fixed-top" role="navigation">
            <template slot="brand">
                <b-navbar-item>
                    <router-link class="navbar-item" to="/">Reposilite</router-link>
                </b-navbar-item>
            </template>
            <template slot="end">
                <b-navbar-item>
                    <router-link class="navbar-item" to="/about">About</router-link>
                </b-navbar-item>
                <b-navbar-item>
                    <router-link class="navbar-item" to="/repositories">Repositories</router-link>
                </b-navbar-item>
                <template v-if="authorized">
                    <b-navbar-item>
                        <a class="navbar-item" href="/" @click="handleLogout">Logout</a >
                    </b-navbar-item>
                </template>
                <template v-else>
                    <b-navbar-item>
                        <router-link class="navbar-item" to="/login">Login</router-link>
                    </b-navbar-item>
                    <b-navbar-item>
                        <router-link class="navbar-item" to="/register">Register</router-link>
                    </b-navbar-item>
                </template>
            </template>
        </b-navbar>
        <div class="container page-content-container">
            <div class="container page-content">
                <router-view/>
            </div>
        </div>
    </div>
</template>

<script>
import {USER_DETAILS} from "./constants";

export default {
    data: () => ({
        authorized: false
    }),
    methods: {
        fetchUser() {
            let that = this
            const accessToken = localStorage.getItem('access_token')

            this.$http.get(USER_DETAILS, {headers: {Authorization: `Bearer ${accessToken}`}})
                .then(response => {
                    that.authorized = true
                    return ({ avatar: this.avatar, id: this.identifier, name: this.name, provider: this.provider, providerId: this.providerId, username: this.username, email: this.email } = response.data)
                }).catch(function(error) {
                    that.status = false
                })
        },
        handleLogout() {
            this.$parent.id = ''
            localStorage.removeItem('access_token')
        }
    },
    created() {
        this.fetchUser()
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

.navbar-burger
    height auto !important

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
