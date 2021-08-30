<template>
    <div>
        <h1> Ölsorter </h1>
    
        Alla ölsorter bör listas här
        {{allBeers}}
        
    </div>
  

</template>

<script>


export default {
    name: "Result",

    computed:{
        allBeers(){
            return this.$store.state.allBeers;
        }
    },
}



</script>

<style>

</style>