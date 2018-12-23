<template>
    <form @submit.prevent="performRegister" class="uk-form-horizontal">
        <div class="uk-grid">
            <div class="uk-width-1-6">
                <input class="uk-input" type="text" id="username" name="username" placeholder="Username" v-model="username"/>
                <div style="color: red" v-if="!$v.username.required">Username is required</div>
                <div style="color: red" v-if="!$v.username.minLength">Username must have at least {{$v.username.$params.minLength.min}} letters.</div>
            </div>

            <div class="uk-width-1-6">
                <input class="uk-input" type="text" id="displayName" name="displayName" placeholder="Display name" v-model="displayName"/>
                <div style="color: red" v-if="!$v.displayName.required">Display name is required</div>
                <div style="color: red" v-if="!$v.displayName.minLength">Display name must have at least {{$v.displayName.$params.minLength.min}} letters.</div>
            </div>
        </div>

        <div class="uk-grid">
            <div class="uk-width-1-6">
                <input class="uk-input" type="password" id="password" name="password" placeholder="Password" v-model="password"/>
                <div style="color: red" v-if="!$v.password.required">Password is required</div>
                <div style="color: red" v-if="!$v.password.minLength">Password must have at least {{$v.password.$params.minLength.min}} letters.</div>
            </div>

            <div class="uk-width-1-6">
                <input class="uk-input" type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm password" v-model="confirmPassword"/>
                <div style="color: red" v-if="!$v.confirmPassword.sameAsPassword">Confirmation password must match password</div>
            </div>
        </div>

        <div class="uk-grid">
            <div class="uk-width-1-6">
                <input class="uk-input" type="email" id="email" name="email" placeholder="Email" v-model="email"/>
                <div style="color: red" v-if="!$v.email.required">Email is required</div>
                <div style="color: red" v-if="!$v.email.email">Enter a valid address email</div>
            </div>

            <div class="uk-width-1-6">
                <input class="uk-input" type="email" id="confirmEmail" name="confirmEmail" placeholder="Confirm email" v-model="confirmEmail"/>
                <div style="color: red" v-if="!$v.confirmEmail.sameAsEmail">Confirmation email must match email</div>
            </div>
        </div>

        <div class="uk-grid">
            <div class="uk-width-1-6">
                <button class="uk-button uk-button-secondary" type="submit" :disabled="isInvalid">Register</button>
            </div>
        </div>
    </form>
</template>

<script>
    import { userService } from "../../services/user.service";
    import { notification } from "../../utils/toastr.utils";
    import { required, minLength, sameAs, email } from "vuelidate/lib/validators/index";

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
        validations: {
            username: { required, minLength: minLength(3) },
            displayName: { required, minLength: minLength(3) },
            password: { required, minLength: minLength(6) },
            confirmPassword: { sameAsPassword: sameAs("password") },
            email: { required, email},
            confirmEmail: { sameAsEmail: sameAs("email") }
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
        },
        computed: {
            isInvalid() {
                return this.$v.$invalid;
            }
        }
    }
</script>