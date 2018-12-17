<template>
    <form @submit.prevent="performLogin">
        <label for="username">Username</label>
        <input type="text" name="username" id="username" v-model="username" required/>

        <label for="password">Password</label>
        <input type="password" name="password" id="password" v-model="password" required/>

        <button type="submit">Login</button>
    </form>
</template>

<script>
    import {userService} from "../../services/user.service.js";
    import {notification} from "../../utils/toastr.utils";

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
        methods: {
            performLogin() {
                if (!(this.username && this.password)) {
                    return;
                }

                userService.login(this.username, this.password)
                    .then(() => {
                        notification.success("Successfully logged in!");
                        this.$router.push("/")
                    })
                    .catch(reason => notification.error(reason));
            }
        }
    }
</script>