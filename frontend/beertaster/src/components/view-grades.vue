<template>
    <div>
        <h1>Mina omdömen</h1>

       
    </div>
    

</template>

<script>
export default {
    name: "ViewGrade",

    
    data(){
        return{

        }
    },

    
    computed:{
        
        myGrades(){
            return this.$store.state.myGrades;
            
        }
    

    },


    methods:{


    }
}
</script>

<style>

</style>