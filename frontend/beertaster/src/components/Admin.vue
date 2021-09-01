<template>
    <div>
        
        <h3> Välkommen, Admin</h3>

        <select id="action" v-model="choiceAction" name="choiceAction"> 
            <option value="" disabled selected>Vad vill du göra?</option>     
            <option value="1">Lägg till nytt öl</option>
            <option value="2">Lista alla öl - uppdatera, radera</option>
            <option value="3" disabled>Logga ut</option>
            
        </select>

        <add-beer v-if="choiceAction === '1' "></add-beer>
        <list-beer v-if="choiceAction === '2' "></list-beer>

        <!-- Admin is currently not logged in so this option is not available now -->

    </div>
  


</template>

<script>
import AddBeer from '/src/components/AddBeer.vue'
import ListBeer from '/src/components/ListBeer.vue'


export default {
    name: "Admin",

    components:{
        AddBeer,
        ListBeer,
    },

    data(){
        return{
            choiceAction:"",

        }
    },

    computed:{
        
    },

    methods:{
       
       
    },

    created(){
        this.$store.dispatch("getAllBeersFromDB");
    }

}
</script>

<style>

</style>