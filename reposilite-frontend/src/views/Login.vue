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
    <div class="login columns is-centered">
        <form class="column is-centered" ref="form" @submit.prevent="handleSignin">
            <h1 class="subtitle">Sign in</h1>

            <b-field>
                <b-input v-model="username" placeholder="Username" minlength="3" maxlength="48" required></b-input>
            </b-field>

            <b-field>
                <b-input v-model="password" placeholder="Password" type="password" minlength="3" maxlength="30" required></b-input>
            </b-field>

            <b-field>
                <a :href="signInWithGithubUrl">Sign in with GitHub</a>
            </b-field>
            <b-field>
                <router-link to="/register">Register a new account</router-link>
            </b-field>

            <b-field>
                <b-button class="button is-link" type="submit">Login</b-button>
            </b-field>
        </form>
    </div>
</template>

<script>
import {GITHUB_OAUTH_URL, SIGNIN_ENDPOINT_URL} from "../constants";

export default {
    data: () => ({
        username: '',
        password: '',
        signInWithGithubUrl: GITHUB_OAUTH_URL
    }),
    methods: {
        handleSignin() {
            this.$http.post(`${SIGNIN_ENDPOINT_URL}`, { username: this.username, password: this.password }, {})
                .then(response => {
                    this.$store.dispatch('setToken', response.data['access_token'])
                })
                .catch(error => {
                    if (error.response.status === 401) {
                        this.$notify.error('Bad credentials')
                        return
                    }

                    this.$notify.error('An error occurred while trying to signin')
                })
        }
    }
}
</script>

<style lang="stylus">
.login
    text-align center
.login .column
    max-width 460px
    border-radius 7px
    background-color white
    text-align center
.login .input
    max-width 420px !important
.login .control
    text-align center !important
</style>