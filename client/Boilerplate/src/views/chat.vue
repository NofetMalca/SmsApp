<template>
  <div class="chat">
    <div class="columns is-widescreen">
      <div class="column  is-9 ">
        <div class="column zeroP" >
          <ChatNav :pFullName="fullName"></ChatNav>
        </div>
        <div class="column ">
          Elina
        </div>
        <div class="column ">
          <AddMessage v-if="openChat" :senderIdClick="senderIdClick" :receiverIdClick="receiverIdClick"></AddMessage> 
      </div>
      </div>
      <div class="column is-3" >
        <!-- <UsersTable :myID="myID" @fullNameClicked="fullNameClicked($event)"></UsersTable> -->
        <UsersTable :myID="myID" 
        @fullNameClicked="fullNameClicked($event)"
        @senderId="senderId($event)"
        @receiverId="receiverId($event)"
        @clicked="clicked($event)">
        </UsersTable>
      </div>
    </div>
  </div>
</template>

<script>
import ChatNav from '../components/chatNav.vue';
import UsersTable from '../components/usersTable.vue';
import AddMessage from '../components/addMessage.vue';
// import { eventBus2 } from '../EventBusChat.js'
//import { eventBus } from '../EventBus.js'

export default {
  name: 'chat',

  props: { myID: String },
  data() {
    return {
      fullName: "",
      senderIdClick: "",
      receiverIdClick: "",
      openChat:false,
    }
  },

  components: { ChatNav, UsersTable, AddMessage },
  methods: {
    fullNameClicked(e) {
      this.fullName = e;
    },

    senderId(ev) {
      this.senderIdClick = ev;
    },

    receiverId(eve){
      this.receiverIdClick = eve;

    },
    clicked(e){
      this.openChat=e;
    }
  }

}

</script>
<style>
  .chat{
    background-color: rgba(250, 232, 210, 0.221);

  }
  .zeroP{
    padding: 0;
  }
</style>