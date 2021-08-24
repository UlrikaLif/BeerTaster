<template>
    <div>
        <h1> Ölsorter </h1>
    
        <p>Alla ölsorter bör listas här</p>
    
        <div class="beerCard" v-for="(beer, index) in allBeers" v-bind:key="index">
            Namn : {{ beer.name }}<br>
            Kategori: {{ beer.category }}<br>
            Bryggeri: {{ beer.brewery }}<br>
            Ursprungsland: {{ beer.country }}
        </div>
        
    </div>
  

</template>

<script>

export default {
    name: "Result",

   
    data(){
        return {

        }
    },

    computed:{
        allBeers(){
            return this.$store.state.allBeers;
        }
    },
}



</script>

<style scoped>

.beerCard {
    width: 30vw;
    margin-top: 20px;
    padding: 10px 25px;
    background-color: rgb(250, 193, 7);
    text-align: left;
}

</style>