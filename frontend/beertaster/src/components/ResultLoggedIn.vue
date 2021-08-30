<template>
    <div>
        
        <div class="filter-field">
            <form class="filter country">
                <h3>Filtrera efter ursprungsland: </h3>
                <v-select :options=beerCountries></v-select>

                <select v-model="selectedCountry">
                    <option value="" selected>Alla</option>
                    <option v-for="(option,index) in beerCountries" :key="index" :value="option">{{option}}</option>
                </select>
            </form>
            
            <form class="filter category">
                <h3>Filtrera efter kategori: </h3>
                <select v-model="selectedCategory">
                    <option value="" selected>Alla</option>
                    <option v-for="(option,index) in beerCategories" :key="index" :value="option">{{option}}</option>
                </select>
            </form>
            
        </div>

        <h1> Ölsorter </h1>
     
        <div v-if=publishedBeers.length>
            <div class="beerCard" v-for="(beer, index) in publishedBeers" v-bind:key="index">
                Namn : {{ beer.name }}<br>
                Kategori: {{ beer.category }}<br>
                Bryggeri: {{ beer.brewery }}<br>
                Ursprungsland: {{ beer.country }}
            
                <div class="grade">

                    <button class="viewGrade">Se omdöme</button>

                    
                    <button class="addGrade" @click="chooseBeer(beer)"><router-link to='/create-grade' >Skapa omdöme</router-link></button> 
                </div>
                
            </div>
        </div>
        <div v-else>
            <p>Det finns inga öl som motsvarar din filtrering. Försök igen!</p>
        </div>
        
        
    </div>
  

</template>

<script>

export default {
    name: "Result",

   
    data(){
        return {
            selectedCountry: "",
            selectedCategory: "",
            
        }
    },

    computed:{
        allBeers(){
            return this.$store.state.allBeers;
        },
        beerCountries(){
            let beerCountries = []
            for (let beer of this.allBeers){
                if (!beerCountries.includes(beer.country)){
                    beerCountries.push(beer.country)
                }
            }
            return beerCountries.sort();
        },
        beerCategories(){
            let beerCategories = []
            for (let beer of this.allBeers){
                if (!beerCategories.includes(beer.category)){
                    beerCategories.push(beer.category)
                }
            }
            return beerCategories.sort();
        },
        publishedBeers(){

            // If no filter is chosen
            if (this.selectedCountry == "" && this.selectedCategory == ""){
                return this.allBeers;
            } 
            // If user has chosen to filter by only country
            else if (this.selectedCategory == ""){
                return this.allBeers.filter(beer => {
                    return beer.country.toLowerCase().includes(this.selectedCountry.toLowerCase())
                });
            }
            // if user has chosen to filter by only category
            else if (this.selectedCountry == ""){
                return this.allBeers.filter(beer => {
                    return beer.category.toLowerCase().includes(this.selectedCategory.toLowerCase())
                });
            }
            else {
                // If user has chosen to use both filters
                return this.allBeers
                    .filter(beer => { return beer.category.toLowerCase().includes(this.selectedCategory.toLowerCase())
                }).filter(beer => { return beer.country.toLowerCase().includes(this.selectedCountry.toLowerCase())
                });
            }

        },
        currentBeer(){
            return this.$store.state.currentBeer;
        },
        myGrades(){
            return this.$store.state.myGrades;
        },
       



        
    },

    methods:{
        chooseBeer(beer){ 
            this.$store.commit("setCurrentBeer", beer);
        },

 
        
       
       


    }

    
}


</script>

<style scoped>

.beerCard {
    display: grid;
    width: 30vw;
    margin-top: 20px;
    padding: 10px 25px;
    background-color: rgb(250, 193, 7);
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

button{
    margin: 5px 15px;
}

</style>