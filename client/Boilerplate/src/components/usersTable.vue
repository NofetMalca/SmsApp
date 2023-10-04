<template>
  <div>
    <article class="panel">
      <p id="pHead" class="panel-heading">
        אנשי קשר
      </p>
        <div class="panel-tabs is-centered is-toggle">
        <ul>
          <li class="is-active" >
            <a @click="updateCallClicked(true)">
            <span class="icon is-small"><i class="fas fa-book" aria-hidden="true"></i></span>
              <span>All</span>
            </a>
            <a @click="updateCallClicked(false)">
              <span class="icon is-small"><i class="fas fa-book" aria-hidden="true"></i></span>
              <span>myCalls</span>
            </a>
          </li>
        </ul>
      </div>
              
      <div class="panel-block">
        <p class="control has-icons-left">
          <input class=input id=assignmentInput v-model="serchInput" placeholder="חיפוש איש קשר" autofocus />
          <span class="icon is-left">
            <i class="fas fa-search" aria-hidden="true"></i>
          </span>
        </p>
      </div>

      
      <div class="scroll-container">
        <table class="table is-hoverable">
          <tbody>
            <tr class="text"
            id="trContact" 
            v-for="contact in filterContactsBySearch" 
            :key="contact.id"  
            @click="updateClickedId(contact)">
              <td>
                  {{ contact.firstName + " " + contact.lastName }}
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </article>
  </div>
</template>

<script>
    import 'bulma/css/bulma.css';
    import '@fortawesome/fontawesome-free/css/all.min.css';
    import api from '../api/api.js';
  
    export default {
    name: "initializeDate",
    props: {myID:String},
    data() {
        return {
          contacts: [],
          contactsCall: [],
          callsRec:[],
          serchInput: "",
          selectRow: "",
          isShowRow: false,
          isAll: true,
          senderId: "",
          receiverId: "",
          // colorClick: false,
        
        };
    },
    created() {
        this.getAllContactsBy();
        this.getMyCallsContactsBy();
    },
    methods: {

      async getAllContactsBy(){
        try {
              this.contacts = (await api.employee().getAllContactsById(this.myID)).data;
            } catch (err) {
                alert(`${err} couldn't get the contacts.`);
            }

      },

      async getMyCallsContactsBy(){
        try {
              this.contactsCall = (await api.employee().getMyCallsContactsById(this.myID)).data;
            } catch (err) {
                alert(`${err} couldn't get the contacts call.`);
            }
      },
    
      updateClickedId(contact){
        this.selectRow = contact;
        this.isShowRow = true;
        this.senderId = this.myID;
        this.receiverId = contact.id;
        this.$emit("fullNameClicked",contact.firstName + " " + contact.lastName);
        this.$emit("senderId",this.senderId);
        this.$emit("receiverId",this.receiverId);
        this.$emit("clicked",true);

        

        // this.colorClick = true;

      },
      updateCallClicked(isAllCalls){
        this.isAll = isAllCalls; 
      },

      getAllIDRec(){
      let sortedContacts = this.contactsCall;
          sortedContacts.forEach((item)=>
          {
            this.callsRec.push({'id':item.recieverId});
            
          });
          return this.callsRec;
        },

      isTrueCallContact(value){
        // alert(this.callsRec[0].id);
        for(let currIndex= 0; currIndex < this.callsRec.length ; currIndex++){
          if(value.id === this.callsRec[currIndex].id){
            return true;
          }
        }
        return false;
      },

    },

    computed: {
      sortComputed() {
         

          let sortedContacts;

         if(this.isAll){
          sortedContacts = this.contacts;
          sortedContacts.sort((contact1, contact2) => ((contact1.firstName.toString()) > (contact2.firstName.toString())) ? 1 : -1);
         }
         else{
          this.getAllIDRec();
          sortedContacts = [...this.contacts].filter(this.isTrueCallContact);
             
          sortedContacts.sort((contact1, contact2) => ((contact1.firstName.toString()) > (contact2.firstName.toString())) ? 1 : -1);
         }

        return sortedContacts;
      },

      filterContactsBySearch() {
        if (this.serchInput) {
          return this.sortComputed.filter((contact) => contact.firstName.toString().toUpperCase().includes((this.serchInput).toUpperCase()));
        }
        else {
            return this.sortComputed;
        }
      },

    },
    
    components: {  }
}

</script>
<style>
   .input{
        direction: rtl;
    }



    .panel{
      margin: 0;
      background-color: rgb(243, 240, 240);

    }

    .table{
      width: 100%;
    }
 

    .container{
      margin: 0;
      padding: 0;
    }

    .panel-heading{
      background-color: rgb(243, 240, 240);
    }

    .scroll-container {
      height: 69vh;
      overflow-y: scroll;
      scroll-behavior: smooth;
    }
</style>
