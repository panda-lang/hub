<!--
  - Copyright (c) 2020 Hub Team of panda-lang organization
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
    <div>
        <Menu/>
        <div class="container welcome-content">
            <div class="columns">
                <div class="column is-centered">
                    <h1>Where the Universe begins</h1>
                </div>
            </div>
            <div class="columns">
                <div class="description column is-centered">
                    Instantly publish your crates and install them.
                    Use the API to interact and find out more information about available crates.
                    Become a contributor and enhance the site with your work.
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import Menu from './Menu'

export default {
	components: {
		Menu
	}
}
</script>

<style lang="stylus">
.welcome
    background-color #6B3E78
    background-image url('../assets/background.png')
    background-size 117%
/*
 * Menu component
 */
.welcome .logo
    color white
.welcome .navbar
    background-color rgba(0, 0, 0, 0)
.welcome .navbar-item
    color white
.welcome .navbar-item:hover
    background-color rgba(0, 0, 0, 0) !important
    color #efefef !important
    text-decoration underline
.welcome .login-item
    font-weight bold
</style>

<style lang="stylus">
.welcome-content
    color white
    font-family "Leelawadee UI"
    text-align center
h1
    font-size 70px
    font-weight bold
    width auto
.description
    font-size 16px
    width 217px
</style>
