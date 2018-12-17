<template>
    <form @submit.prevent="performRegister">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" placeholder="Username" v-model="username" required/>
        <br/>
        <label for="displayName">Display name</label>
        <input type="text" id="displayName" name="displayName" placeholder="Display name" v-model="displayName" required/>
        <br/>
        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Password" v-model="password" required/>
        <br/>
        <label for="confirmPassword">Confirm password</label>
        <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm password" v-model="confirmPassword" required/>
        <br/>
        <label for="email">Email</label>
        <input type="email" id="email" name="email" placeholder="Email" v-model="email" required/>
        <br/>
        <label for="confirmEmail">Confirm email</label>
        <input type="email" id="confirmEmail" name="confirmEmail" placeholder="Confirm email" v-model="confirmEmail" required>

        <button type="submit">Register</button>
    </form>
</template>

<script>
    import {userService} from "../../services/user.service";
    import {notification} from "../../utils/toastr.utils";

    export default {
        name: "RegisterView",
        data: () => {
            return {
                username: "",
                displayName: "",
                password: "",
                confirmPassword: "",
                email: "",
                confirmEmail: ""
            }
        },
        methods: {
            performRegister() {
                userService.register(this.username, this.displayName, this.password, this.confirmPassword, this.email, this.confirmEmail)
                    .then(() => {
                        notification.success("Successfully registered!");
                        this.$router.push("/")
                    })
                    .catch(reason => notification.error(reason));
            }
        }
    }
</script>