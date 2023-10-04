<template>
    <div  class="container"> 
        <input class="input is-rounded" id="assignmentInput" v-model="massageInput" placeholder="הכנס הודעה כאן" autofocus /> 

        <button class="button is-primary is-rounded" @click="updateMassageClicked()">
            <span class="icon">
                <i class="fa fa-paper-plane" aria-hidden="true"></i>
            </span>
        </button>
        <!-- <p class="control has-icons-left" > 
            <button @click="updateMassageClicked()">
            <span class="icon is-left">
                <i class="fa fa-paper-plane" aria-hidden="true"></i>
            </span>
           </button>
        </p> -->
    </div>  
</template>
  
  <script>
      import 'bulma/css/bulma.css';
      import '@fortawesome/fontawesome-free/css/all.min.css';
      import api from '../api/api.js';
    
      export default {
      name: "initializeDate",
      props: {senderIdClick:String,receiverIdClick:String},
      data() {
          return {
            // contacts: contacts,
            massageInput: "",
            sendingTime: "",


            
           
          
          };
      },
    //   "sender_id": "22",
    //  "reciever_id": "11",
    //  "message_content": "שלום",
    // "sending_time": "146107711300"
  
      methods: {
        updateMassageClicked(){
          
            if(this.massageInput){
                // this.sendingTime = to_timestamp(`${Date.now()}` / 1000.0);
                this.sendingTime = new Date().getTime();
                alert(this.sendingTime);

                api
                    .employee()
                    .getMassage(this.senderIdClick, this.receiverIdClick, this.massageInput, this.sendingTime)
                    
                    .catch((err) => {
                        if (err.status != 200) {
                            alert("שגיאה בהכנסת הנתונים!")

                        }
                    });

            } else if(this.massageInput === "") {
                    alert("נא להקליד הודעה, לא הוקלדה הודעה...")
              }            
        },
      
      },
  
      computed: {
     
        },
  
      
  
      
      components: {  }
  }
  
  </script>
  <style>
   
  </style>
  