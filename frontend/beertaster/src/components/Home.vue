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
        console.log("Begin created")
        this.$store.dispatch("getAllBeersFromDB")
        console.log("End created")
    }
}



</script>

<style>
*{ 
    box-sizing: border-box;
    font-size: 30px;

}



</style>