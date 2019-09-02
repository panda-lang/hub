<template>
    <div class="login">
        <div class="container">
            <div class="columns is-centered">
                <section class="column is-centered">
                    <h1 class="subtitle">Sign in</h1>

                    <b-field>
                        <b-input name="name" placeholder="Username" maxlength="48"></b-input>
                    </b-field>

                    <b-field>
                        <b-input name="password" placeholder="Password" type="password" maxlength="30"></b-input>
                    </b-field>
                </section>
            </div>
        </div>
    </div>
</template>

<style lang="stylus">
.columns
    padding-top 27px

.column
    max-width 460px
    border-radius 10px
    background-color white
    text-align center
</style>