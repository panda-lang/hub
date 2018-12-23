<template>
    <div id="navbar-wrapper">
        <nav class="uk-navbar uk-navbar-container uk-navbar-transparent uk-margin">
            <div class="uk-navbar-left">
                <router-link class="uk-navbar-item uk-logo" to="/">
                    <a class="uk-navbar-item uk-logo">Reposilite</a>
                </router-link>
            </div>
            <div class="uk-navbar-center uk-margin-right">
                <ul class="uk-navbar-nav uk-visible@m">
                    <router-link class="uk-navbar-item" to="/about" tag="li"><a>About</a></router-link>
                    <router-link class="uk-navbar-item" to="/contact" tag="li"><a>Contact</a></router-link>
                </ul>
            </div>
        </nav>

        <div id="modal-full" class="uk-modal-full uk-modal" uk-modal>
            <div class="uk-modal-dialog uk-flex uk-flex-center uk-flex-middle" uk-height-viewport>
                <button class="uk-modal-close-full" type="button" uk-close></button>
                <form class="uk-search uk-search-large">
                    <input class="uk-search-input uk-text-center" type="search" placeholder="Search..." autofocus>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'Navbar'
    }
</script>

<style lang="scss" scoped>
    @import url('https://fonts.googleapis.com/css?family=Titillium+Web');

    .uk-modal-dialog {
        opacity: 0.8;
    }

    .uk-navbar-item {
        font-family: 'Titillium Web', sans-serif;
    }
</style>
