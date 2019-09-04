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
    <div class="login">
        <div class="container">
            <div class="columns is-centered">
                <form class="column is-centered" ref="form">
                    <h1 class="subtitle">Sign in</h1>

                    <b-field>
                        <b-input name="name" placeholder="Username" minlength="3" maxlength="48" required></b-input>
                    </b-field>

                    <b-field>
                        <b-input name="password" placeholder="Password" type="password" minlength="3" maxlength="30" required></b-input>
                    </b-field>

                    <b-button class="button is-link" v-on:click="submit">Login</b-button>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    methods: {
        submit() {
            this.$refs.form.submit()
        }
    }
}
</script>

<style lang="stylus">
.columns
    padding-top 27px

.column
    max-width 460px
    border-radius 7px
    background-color white
    text-align center
    margin 7px

.input
    max-width 420px !important

.control
    text-align center !important
</style>