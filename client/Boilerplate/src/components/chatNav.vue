<template>
    <div>
        <nav v-if="isNameExist" class="navbar panelheading  zeroP" role="navigation" aria-label="main navigation">
            <div class="navbar-brand">

            </div>


            <div id="navbarBasicExample" class="navbar-menu">
                <div class="navbar-start">

                </div>

                <div class="navbar-end">
                    <p id="pHead" class="chatNavText">
                        {{pFullName}}
                    </p>

                </div>
            </div>
        </nav>
    </div>
</template>

<script>
import "bulma/css/bulma.css";

export default {
    props: {
        pFullName: {
            default: "",
            type: String
        }
    },
    name: "navbar",
    data() {
        return {

        };
    },
    computed: {
        isNameExist() {
            if (this.pFullName === "") { return false }
            return true;
        },
        logInCheck() {
            if (this.logInID != "") {
                return true
            }
            return false

        },
    },
    methods: {
        logOut() {
            this.$emit("logOutID");
        }
    }

};
</script>

<style>
.myColor {
    background-color: #ffe1b3;
}

.chatNavText {
    font-size: 30px;
    direction: rtl;
}

.panelheading {
    background-color: rgb(243, 240, 240);
}

.zeroP {
    padding: 0;
}
</style>