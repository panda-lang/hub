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
                    <router-link class="navbar-item" to="/login">Login</router-link>
                </b-navbar-item>
            </template>
        </b-navbar>
        <router-view/>
    </div>
</template>

<style lang="stylus">
html
    background-color #efefef !important

#app
    text-align right

.navbar-burger
    height auto !important

a
    text-decoration none
</style>
