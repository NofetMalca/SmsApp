import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Chat from './views/chat.vue'
import Log from './views/logIn.vue'
// Solve the error reporting of repeated clicking links 
const routerPush = Router.prototype.push
Router.prototype.push = function push(location) {

return routerPush.call(this, location).catch(error=> error)
}
Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/log',
      name: 'log',
      component: Log
    },
    {
      path: '/chat',
      name: 'chat',
      component: Chat
    }
  ]
})
