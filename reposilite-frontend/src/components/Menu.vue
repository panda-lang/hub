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
                <router-link class="navbar-item" to="/news">News</router-link>
            </b-navbar-item>
            <b-navbar-item>
                <router-link class="navbar-item" to="/repositories">Repositories</router-link>
            </b-navbar-item>
            <template v-if="user">
                <b-navbar-item v-if="roles">
                    <router-link class="navbar-item" to="/admin">Admin</router-link>
                </b-navbar-item>
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
</template>

<script>
export default {
    name: 'Menu',
    computed: {
        user: function () {
            return this.$store.state.user
        },
        roles: function () {
            return this.user.roles && this.user.roles
                .map(value => value.name)
                .includes('ADMIN')
        },
    },
    methods: {
        handleLogout() {
            this.$store.dispatch('removeUser')
            this.$parent.$parent.id = ''
        }
    }
}
</script>

<style lang="stylus" scoped>
.navbar-burger
    height auto !important
</style>