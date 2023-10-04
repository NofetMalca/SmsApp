<template>
    <nav class="navbar bg" role="navigation" aria-label="main navigation">
        <div class="navbar-brand">
            <a>
                <router-link to="/" exact class=" navbar-item text">  <img src="../assets/transperLogo.png" width="45"> </router-link>

            </a>


        </div>

        <div id="navbarBasicExample" class="navbar-menu">
            <div class="navbar-start">
                <a v-if="logInCheck">
                    <router-link to="/chat" exact class="navbar-item text">Chat</router-link>
                </a>
                

            </div>

            <div class="navbar-end">
                <div class="navbar-item">
                    <router-link v-if="!logInCheck" to="/log" exact class="navbar-item text">
                        <div  class="buttons">
                            <a class="button myColor">
                                <strong> Log in</strong>
                            </a>

                        </div>
                       
                    </router-link>
                    <div v-else class="buttons">
                            <a class="button myColor" @click="logOut()">
                                <strong> Log out</strong>
                                
                            </a>

                        </div>
                </div>
            </div>
        </div>
    </nav>

</template>

<script>
import "bulma/css/bulma.css";

export default {
    props: ["logInID"],
    name: "navbar",
    data() {
        return {

        };
    },
    computed: {
        logInCheck() {
            if (this.logInID != "") {
                return true
            }
            return false

        },
    },
    methods:{
        logOut(){
            this.$emit("logOutID");
        }
    }

};
</script>

<style>
    .bg{
        background-color: rgba(250, 232, 210, 0.221);
    }
.myColor {
    background-color: #ffe1b3;
}

.text {
    font-size: 16px;
    direction: rtl;
}
</style>