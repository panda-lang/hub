<template lang="pug">
    #navbar-wrapper
        nav.uk-navbar.uk-navbar-container.uk-navbar-transparent.uk-margin
            .uk-navbar-left
                router-link.uk-navbar-item.uk-logo(to='/')
                    a.uk-navbar-item.uk-logo Reposilite
</template>

<script>
    export default {
        name: 'Navbar'
    }
</script>

<style lang="stylus" scoped>
    @import url('https://fonts.googleapis.com/css?family=Titillium+Web')

    .uk-navbar
        background-color white
        -webkit-box-shadow 0px 0px 71px -8px rgba(0,0,0,0.23)
        -moz-box-shadow 0px 0px 71px -8px rgba(0,0,0,0.23)
        box-shadow 0px 0px 71px -8px rgba(0,0,0,0.23)

    .uk-navbar-item
        font-family 'Titillium Web', sans-serif
</style>
