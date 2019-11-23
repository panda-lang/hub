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
    <div class="register columns is-centered">
        <form class="column is-centered" ref="form" @submit.prevent="handleSignup">
            <b-field>
                <h1 class="subtitle">Sign up</h1>
            </b-field>

            <b-field>
                <b-input name="username" placeholder="Username" minlength="3" maxlength="32" required></b-input>
            </b-field>

            <b-field>
                <b-input name="name" placeholder="Display name" minlength="3" maxlength="64"></b-input>
            </b-field>

            <b-field>
                <b-input name="email" placeholder="Email" type="email" minlength="3" maxlength="128" required></b-input>
            </b-field>

            <b-field>
                <b-input name="password" placeholder="Password" type="password" minlength="3" maxlength="30" required></b-input>
            </b-field>

            <b-field>
                <a :href="signInWithGithubUrl">Sign up with GitHub</a>
            </b-field>

            <b-field>
                <b-button class="button is-link" type="submit">Register</b-button>
            </b-field>
        </form>
    </div>
</template>

<script>
import { GITHUB_OAUTH_URL, SIGNUP_ENDPOINT_URL } from '../constants'

export default {
  data: () => ({
    username: '',
    name: '',
    email: '',
    password: '',
    signInWithGithubUrl: GITHUB_OAUTH_URL
  }),
  methods: {
    handleSignup () {
      this.$http.post(SIGNUP_ENDPOINT_URL, { username: this.username, name: this.name, email: this.email, password: this.password }, {})
        .then(() => this.$notify.success('Successfully singed up'))
        .catch(error => {
          if (error.response.status === 409) {
            this.$notify.error('User already exists')
            return
          }

          this.$notify.error('An error occurred while trying to signup')
        })
    }
  }
}
</script>

<style lang="stylus">
.register
    text-align center

.register .column
    max-width 460px
    border-radius 7px
    background-color white
    text-align center

.register .input
    max-width 420px !important

.register .control
    text-align center !important
</style>
