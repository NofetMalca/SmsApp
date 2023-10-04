import axiosInstance from "./axiosInstance";

export default {
  employee() {
    return {
        getUserLogin:(userN,userP)=>axiosInstance.post('/users/login', { userName:userN,userPassword:userP }),
        getAllContactsById: (userId) =>
          axiosInstance.get(`/employees/contact/${userId}`),
        getMyCallsContactsById: (userId) =>
          axiosInstance.get(`/messages/room/id/${userId}`),
        getMassage:(senderId,receiverId,massageInput,sendingTime)=>
          axiosInstance.post('/messages/add', { senderId:senderId,recieverId:receiverId, messageContent:massageInput, sendingTime:sendingTime }),
  
    };
  },
};
