<template>
    <div id="home-wrapper">
        <!-- Description -->
        <div class="uk-position-large uk-position-center-left uk-padding-large">
            <h1>Reposilite</h1>
            <h2>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</h2>
            <br>
            <button href="#" class="signin-button">Sign in using Github</button>
        </div>

        <!-- Search panel -->
        <Search />
    </div>
</template>

<script>
    import Search from "./components/Search.vue";

    export default {
        name: 'HomeView',
        components: {
            Search
        }
    }
</script>

<style lang="scss" scoped>
    @import url('https://fonts.googleapis.com/css?family=Arimo|PT+Sans');
    @import url('https://fonts.googleapis.com/css?family=Montserrat:400,700,900|Raleway|Rubik:400,700,900');

    h1 {
        position: relative;
        color: #e6e6e6;
        font-size: 35px;
        font-family: 'Montserrat', sans-serif;
        font-weight: bold;
    }

    h2 {
        position: relative;
        color: #999999;
        font-size: 14px;
        font-family: 'Raleway', sans-serif;
        font-weight: 100;
        max-width: 500px;
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
        cursor: pointer;
    }

    .signin-button:hover {
        transform: scale(1.05);
    }
</style>
