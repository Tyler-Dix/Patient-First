<template>
  <body>
    <div class="header">
        <global-header />
        <h1>Welcome! We're Glad You're Here.</h1>
    
    <p class="subheader" >
      Our Physicians:
    </p>
    
  </div>
  <div class="doctor-list">
    
        <doctors-list v-bind:doctors="doctors" />
</div>
<div class="footer">

</div>
</body> 
    <global-footer/>
</template>

<script>
import DoctorsList from '../components/DoctorsList.vue';
import doctorsService from '../services/DoctorsService.js';
import GlobalHeader from '../components/GlobalHeader.vue';
import GlobalFooter from '../components/GlobalFooter.vue';


export default {
    components: {
        DoctorsList,
        GlobalHeader,
        GlobalFooter
    },
    data() {
        return {
            doctors: [],
        };
    },
    methods: {
        getDoctors() {
      
      doctorsService.list()
        .then(response => {
          this.doctors = response.data;

        })
        .catch(error => {
          this.handleErrorResponse();
        })
    },
    handleErrorResponse() {

    }
  },
  created() {
    this.getDoctors();
  }
  
  }


</script>

<style scoped>
@import '../css/styles.css';
.header {
  text-align: center;
}

.subheader {
  text-align: left;
  margin-top: 5%;
  padding-left: 8%;
  font-weight: bold;
}





</style>