<template>
    <form @submit.prevent="performLogin">
        <div class="uk-grid">
            <div class="uk-width-1-3">
                <input class="uk-input" type="text" id="username" name="username" placeholder="Username" v-model="username"/>
                <div style="color: red" v-if="!$v.username.required">Username is required</div>
            </div>

            <div class="uk-width-1-3">
                <input class="uk-input" type="password" name="password" id="password" placeholder="Password" v-model="password"/>
                <div style="color: red" v-if="!$v.password.required">Password is required</div>
            </div>

            <div class="uk-width-1-3">
                <button class="uk-button uk-button-secondary" type="submit" :disabled="isInvalid">Login</button>
            </div>
        </div>

    </form>
</template>

<script>
    import { userService } from "../../services/user.service.js";
    import { notification } from "../../utils/toastr.utils";
    import { required } from "vuelidate/lib/validators/index";

    export default {
        name: "LoginView",
        data: () => {
            return {
                username: "",
                password: ""
            }
        },
        created: () => {
            userService.logout();
        },
        validations: {
            username: { required },
            password: { required }
        },
        methods: {
            performLogin() {
                userService.login(this.username, this.password)
                    .then(() => {
                        notification.success("Successfully logged in!");
                        this.$router.push("/")
                    })
                    .catch(reason => notification.error(reason));
            }
        },
        computed: {
            isInvalid() {
                return this.$v.$invalid;
            }
        }
    }
</script>