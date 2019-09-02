<template>
    <div id="app">
        <nav class="navbar is-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-start">
                    <router-link class="navbar-item" to="/">Reposilite</router-link>
                </div>
                <div class="navbar-end">
                    <router-link class="navbar-item" to="/about">About</router-link>
                    <router-link class="navbar-item" to="/login">Login</router-link>
                </div>
            </div>
        </nav>
        <router-view/>
    </div>
</template>

<style lang="stylus">
html
    background-color #efefef !important

#app
    text-align right

#nav
    padding 30px

a
    text-decoration none
</style>
