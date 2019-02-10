<template lang="pug">
    #navbar-wrapper
        nav.uk-navbar.uk-navbar-container.uk-navbar-transparent.uk-margin-medium
            .uk-navbar-left
                router-link.uk-navbar-item.uk-logo(to='/')
                    a.uk-navbar-item.uk-logo.uk-margin-xlarge-left Reposilite
            .uk-navbar-right
                //User bar
                img.avatar(:src="userAvatar")
                a.username {{ username }}
                span.uk-margin-xlarge-right(uk-icon="icon: chevron-down")
                div(uk-dropdown='animation: uk-animation-slide-top-small; duration: 500; pos: bottom-justify')
                    ul.uk-nav.uk-dropdown-nav
                        li
                            a(href='#') Your profile
                        li
                            a(href='#') Your repositories
                        li
                            a(href='#') Item
                        li.uk-nav-divider
                        li
                            a(href='#') Settings
                        li
                            a(href='#') Logout
</template>

<script>
    export default {
        name: 'Navbar',
        data() {
            return {
                userAvatar: 'https://store.playstation.com/store/api/chihiro/00_09_000/container/US/en/99/UP2538-CUSA05620_00-AV00000000000118//image?_version=00_09_000&platform=chihiro&w=720&h=720&bg_color=000000&opacity=100',
                username: 'awesome user 🐢'
            }
        }
    }
</script>

<style lang="stylus" scoped>
    @import url('https://fonts.googleapis.com/css?family=Titillium+Web')

    .uk-navbar
        height 60px
        background-color white
        -webkit-box-shadow 0px 0px 71px -8px rgba(0,0,0,0.23)
        -moz-box-shadow 0px 0px 71px -8px rgba(0,0,0,0.23)
        box-shadow 0px 0px 71px -8px rgba(0,0,0,0.23)
        font-family 'Titillium Web', sans-serif

    .uk-logo
        font-size 17px

    .username
        font-weight bold
        color black
        margin 10px

    .avatar
        height 20px
        width 20px
        border-radius 3px
</style>
