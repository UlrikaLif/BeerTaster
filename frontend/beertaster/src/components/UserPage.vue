<template>
    <div>
        <result-logged-in />
    </div>
  

</template>

<script>

import ResultLoggedIn from './ResultLoggedIn.vue';

export default {
    name: "UserPage",
    components:{
        ResultLoggedIn
    },
    
    created(){
        this.$store.dispatch("getAllBeersFromDB");
      
        this.$store.dispatch("getMyGradesFromDB");
    }
}



</script>

<style>
*{ 
    box-sizing: border-box;
    font-size: 30px;

}



</style>