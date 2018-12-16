<template>
    <div id="home-wrapper">
        <Navbar class="uk-navbar-transparent" />

        <div class="uk-position-large uk-position-center-left">
            <h1>Reposilite</h1>
            <h2>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</h2>
            <br>
            <button href="#" class="signin-button">Sign in using Github</button>
        </div>
    </div>
</template>

<script>
    import Navbar from "./components/Navbar.vue";

    export default {
        name: 'HomeView',
        components: {
            Navbar
        }
    }
</script>

<style scoped>
    @import url('https://fonts.googleapis.com/css?family=Arimo|PT+Sans');
    @import url('https://fonts.googleapis.com/css?family=Montserrat:400,700,900|Raleway|Rubik:400,700,900');

    h1 {
        position: relative;
        color: #302930;
        text-transform: uppercase;
        font-family: 'Montserrat', sans-serif;
        font-weight: bold;
    }

    h2 {
        position: relative;
        color: #5e5e5e;
        font-size: 15px;
        font-family: 'Raleway', sans-serif;
        font-weight: 100;
        max-width: 400px;
    }

    .signin-button {
        position: relative;
        width: 320px;
        height: 45px;
        color: white;
        font-family: 'Rubik', sans-serif;
        text-transform: uppercase;
        letter-spacing: 2px;
        font-size: 12px;
        background: linear-gradient(135deg, #e91653 0%, #1c7586 100%);
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        border: none;
        border-radius: 25px;
    }
</style>
