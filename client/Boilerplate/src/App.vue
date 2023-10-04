<template>
  <div id="app" class="bg">
    <Nav @logOutID="logOutID($event)" :logInID="logInID"></Nav>
    <router-view :myID="logInID"/>
  </div>
</template>

<script>
import Nav from './components/nav.vue';
import { eventBus } from './EventBus.js'

export default {

  components: { Nav },
  data() {
    return {
      logInID: ""

    };
  },
  mounted() {
   
    eventBus.$on("inLoged", id => {
      this.logInID = id;
    });
  },
  destroyed() {
    eventBus.$off("inLoged");
},
methods:{
  logOutID(){
      this.logInID="";
      this.$router.push("/");

    },
}
  

};
</script>

<style >
  .bg{
    background-color: rgba(250, 232, 210, 0.221);

  }
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  font-size: 5vh;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
