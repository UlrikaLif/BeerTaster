<template>
    <div>
        <Result></Result>
    </div>
  

</template>

<script>
import Result from '../components/Result.vue';

export default {
    name: "Home",
    components:{
        Result
    },

    
    created(){
        this.$store.dispatch("getAllBeersFromDB");
      
    }
}



</script>

<style>
*{ 
    box-sizing: border-box;
    font-size: 30px;

}



</style>