<template>
    <div>
        <h1>Mina omdömen för {{currentBeer.name}} </h1>

        <div>
            <div class="gradeCard" v-for="(grade, index) in currentBeerGrades" :key="index">

                Betyg: {{ grade.givenGrade }} <br>
                Omdöme: {{ grade.opinion }} <br>
                Utseende: {{ grade.appearance }} <br>
                Doft: {{ grade.fragrance }} <br>

                Smak: <br>
                Bitterhet: {{ grade.bitterness }} <br>
                Fyllighet: {{ grade.fullness }} <br>
                Friskhet: {{ grade.freshness }} <br>
                Sötma: {{ grade.sweetness }} <br> 
               
               
                <!-- For later
                <div class="crud">
                    <button class="button updateGrade" @click="updateCurrentGrade(grade)">Redigera omdöme</button>
                    <button class="button deleteGrade" @click="deleteCurrentGrade(grade)">Radera omdöme</button>                 
                </div>
                -->
            </div>
        </div>
        

       
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
        currentUser(){
            return this.$store.state.currentUser;
        },

        currentBeer(){
            return this.$store.state.currentBeer;
        },

        currentBeerGrades(){
            return this.$store.state.currentBeerGrades;
            
        },
    },

    methods:{  
        updateCurrentGrade(grade){
            console.log('Vi uppdaterar omdömet', grade.id);
        },

        deleteCurrentGrade(grade){
            console.log('Vi raderar omdömet', grade.id);
        },
    

    },


}


</script>

<style scoped>

.gradeCard {
    display: grid;
    width: 30vw;
    margin-top: 20px;
    padding: 25px 25px;
    background-color: rgb(255, 201, 14);
    color:black;
    text-align: left;
}
.filter-field{
    text-align: right;
    margin-right: 5vw;
}

.filter {
    display: inline-block;
    margin:20px;
    align-content: flex-end;
}

.grade {
    text-align: right;
}

div.button{
    display: inline;
}

button{
    margin: 5px 15px;
}

</style>