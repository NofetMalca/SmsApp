<template>
    <div>
        <div class="wrapper fadeInDown">
            <div id="formContent">
                <!-- Tabs Titles -->
                <h2 class="active"> Log In </h2>


                <!-- Icon -->
                <div class="fadeIn first">
                    <span class="icon">
                        <i class="fas fa-user"></i>
                    </span>
                </div>

                <!-- Login Form -->
                <div>
                    <input type="text" id="login" class="fadeIn second" name="login" placeholder="login name"
                        v-model="userNameInput"><i class="fa fa-asterisk fa-1 mySize" aria-hidden="true"></i>
                    <input type="password" id="password" class="fadeIn third" name="login" placeholder="password"
                        v-model="passwordInput"><i class="fa fa-asterisk fa-1 mySize" aria-hidden="true"></i>
                    <br /><br />
                    <input type="submit" class="fadeIn fourth" value="Log In" @click="submitUser()">
                </div>
                <!-- Remind Passowrd -->
                <div id="formFooter">
                    <h2 class="underlineHover">Thank you</h2>
                </div>

            </div>
        </div>
    </div>
</template>
<script>
import "bulma/css/bulma.css";
import '@fortawesome/fontawesome-free/css/all.min.css';
//import Users from '../Data/users.json'
import api from '../api/api.js'
import { eventBus } from '../EventBus.js'
export default {
    name: "logIn",
    data() {
        return {
            // users:Users,
            //users: [],
            userNameInput: "",
            passwordInput: "",
            isLog: true,
            loginID: "",
        }
    },

    methods: {
        submitUser() {
            if (this.userNameInput === "" || this.passwordInput === "") {
                alert("נא למלא שדות חובה")
            }
            else {
                 api
                    .employee()
                    .getUserLogin(this.userNameInput, this.passwordInput)
                    .then(response => {
                        this.loginID = response.data;
                        eventBus.$emit("inLoged", this.loginID);
                        this.$router.push("/chat");
                    })
                    .catch((err) => {
                        if (err.status != 200) {
                            this.isLog = false;
                            alert("נתונים לא מתאימים למערכת, נסה שוב")

                        }

                    });
               
            }
        }
    }
}
</script>
<style>
@import url('https://fonts.googleapis.com/css?family=Poppins');
/* BASIC */



body {
    font-family: "Poppins", sans-serif;
    height: 100vh;
}

a {
    color: #ffcb78;
    display: inline-block;
    text-decoration: none;
    font-weight: 400;
}

h2 {
    text-align: center;
    font-size: 16px;
    font-weight: 600;
    text-transform: uppercase;
    display: inline-block;
    margin: 40px 8px 10px 8px;
    color: #cccccc;
}



/* STRUCTURE */

.wrapper {
    display: flex;
    align-items: center;
    flex-direction: column;
    justify-content: center;
    width: 100%;
    min-height: 100%;
    padding: 20px;
}

#formContent {
    -webkit-border-radius: 10px 10px 10px 10px;
    border-radius: 10px 10px 10px 10px;
    background: #fff;
    padding: 30px;
    width: 90%;
    max-width: 450px;
    position: relative;
    padding: 0px;
    -webkit-box-shadow: 0 30px 60px 0 rgba(0, 0, 0, 0.3);
    box-shadow: 0 30px 60px 0 rgba(0, 0, 0, 0.3);
    text-align: center;
}

#formFooter {
    background-color: #f6f6f6;
    border-top: 1px solid #f8ebd6;
    text-align: center;
    -webkit-border-radius: 0 0 10px 10px;
    border-radius: 0 0 10px 10px;
}



/* TABS */

h2.inactive {
    color: #cccccc;
}

h2.active {
    color: #0d0d0d;
    border-bottom: 2px solid #ffe1b3;
}



/* FORM TYPOGRAPHY*/

input[type=button],
input[type=submit],
input[type=reset] {
    background-color: #c5c5c5;
    border: none;
    color: white;
    padding: 15px 80px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    text-transform: uppercase;
    font-size: 13px;
    box-shadow: 0 1px 5px 0 #ffe1b3;
    -webkit-box-shadow: 0 10px 30px 0;
    box-shadow: 0 1px 30px 0 #ffe1b3;
    -webkit-border-radius: 5px 5px 5px 5px;
    border-radius: 5px 5px 5px 5px;
    margin: 5px 20px 40px 20px;
    -webkit-transition: all 0.3s ease-in-out;
    -moz-transition: all 0.3s ease-in-out;
    -ms-transition: all 0.3s ease-in-out;
    -o-transition: all 0.3s ease-in-out;
    transition: all 0.3s ease-in-out;
}

input[type=button]:hover,
input[type=submit]:hover,
input[type=reset]:hover {
    background-color: #ffe1b3;
}

input[type=button]:active,
input[type=submit]:active,
input[type=reset]:active {
    -moz-transform: scale(0.95);
    -webkit-transform: scale(0.95);
    -o-transform: scale(0.95);
    -ms-transform: scale(0.95);
    transform: scale(0.95);
}

input[type=text] {
    background-color: #f6f6f6;
    border: none;
    color: #0d0d0d;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 5px;
    width: 85%;
    border: 2px solid #f6f6f6;
    -webkit-transition: all 0.5s ease-in-out;
    -moz-transition: all 0.5s ease-in-out;
    -ms-transition: all 0.5s ease-in-out;
    -o-transition: all 0.5s ease-in-out;
    transition: all 0.5s ease-in-out;
    -webkit-border-radius: 5px 5px 5px 5px;
    border-radius: 5px 5px 5px 5px;
}

input[type=password] {
    background-color: #f6f6f6;
    border: none;
    color: #0d0d0d;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 5px;
    width: 85%;
    border: 2px solid #f6f6f6;
    -webkit-transition: all 0.5s ease-in-out;
    -moz-transition: all 0.5s ease-in-out;
    -ms-transition: all 0.5s ease-in-out;
    -o-transition: all 0.5s ease-in-out;
    transition: all 0.5s ease-in-out;
    -webkit-border-radius: 5px 5px 5px 5px;
    border-radius: 5px 5px 5px 5px;
}

input[type=text]:focus {
    background-color: #fff;
    border-bottom: 2px solid #ffe1b3;
}

input[type=text]:placeholder {
    color: #cccccc;
}



/* ANIMATIONS */

/* Simple CSS3 Fade-in-down Animation */
.fadeInDown {
    -webkit-animation-name: fadeInDown;
    animation-name: fadeInDown;
    -webkit-animation-duration: 1s;
    animation-duration: 1s;
    -webkit-animation-fill-mode: both;
    animation-fill-mode: both;
}

@-webkit-keyframes fadeInDown {
    0% {
        opacity: 0;
        -webkit-transform: translate3d(0, -100%, 0);
        transform: translate3d(0, -100%, 0);
    }

    100% {
        opacity: 1;
        -webkit-transform: none;
        transform: none;
    }
}

@keyframes fadeInDown {
    0% {
        opacity: 0;
        -webkit-transform: translate3d(0, -100%, 0);
        transform: translate3d(0, -100%, 0);
    }

    100% {
        opacity: 1;
        -webkit-transform: none;
        transform: none;
    }
}

/* Simple CSS3 Fade-in Animation */
@-webkit-keyframes fadeIn {
    from {
        opacity: 0;
    }

    to {
        opacity: 1;
    }
}

@-moz-keyframes fadeIn {
    from {
        opacity: 0;
    }

    to {
        opacity: 1;
    }
}

@keyframes fadeIn {
    from {
        opacity: 0;
    }

    to {
        opacity: 1;
    }
}

.fadeIn {
    opacity: 0;
    -webkit-animation: fadeIn ease-in 1;
    -moz-animation: fadeIn ease-in 1;
    animation: fadeIn ease-in 1;

    -webkit-animation-fill-mode: forwards;
    -moz-animation-fill-mode: forwards;
    animation-fill-mode: forwards;

    -webkit-animation-duration: 1s;
    -moz-animation-duration: 1s;
    animation-duration: 1s;
}

.fadeIn.first {
    -webkit-animation-delay: 0.4s;
    -moz-animation-delay: 0.4s;
    animation-delay: 0.4s;
}

.fadeIn.second {
    -webkit-animation-delay: 0.6s;
    -moz-animation-delay: 0.6s;
    animation-delay: 0.6s;
}

.fadeIn.third {
    -webkit-animation-delay: 0.8s;
    -moz-animation-delay: 0.8s;
    animation-delay: 0.8s;
}

.fadeIn.fourth {
    -webkit-animation-delay: 1s;
    -moz-animation-delay: 1s;
    animation-delay: 1s;
}

/* Simple CSS3 Fade-in Animation */
.underlineHover:after {
    display: block;
    left: 0;
    bottom: -10px;
    width: 0;
    height: 2px;
    background-color: #ffe1b3;
    content: "";
    transition: width 0.2s;
}

.underlineHover:hover {
    color: #0d0d0d;
}

.underlineHover:hover:after {
    width: 100%;
}



/* OTHERS */

*:focus {
    outline: none;
}

#icon {
    width: 60%;
}

* {
    box-sizing: border-box;
}
</style>