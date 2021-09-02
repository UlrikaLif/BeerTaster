<template>
  <div>
        
       
        <div v-if="beerHasBeenDeleted">

            <p>Ölet har raderats.</p>

        </div>

        <div v-else>

            <h3>Lista över alla öl i databasen</h3>
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Namn</th>
                        <th>Kategori</th>
                        <th>Bryggeri</th>
                        <th>Ursprungsland</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(beer, index) in allBeers" :key="beer.id">
                        <td>{{beer.id}}</td>
                        <td>{{beer.name}}</td>
                        <td>{{beer.category}}</td>
                        <td>{{beer.brewery}}</td>
                        <td>{{beer.country}}</td>
                        <td><button class="edit-beer-btn" @click="editBeer(beer,index)">Redigera</button></td>
                        <td><button class="delete-beer-btn" @click="deleteBeer(beer,index)">Radera</button></td>
                    </tr>
                </tbody>
            </table>
            
        </div>  
   

  </div>

</template>

<script>
    
    export default {
        name: "ListBeer",

        data(){
            return{
                beerHasBeenDeleted: false,
                chosenBeer: "",
                chosenIndex: "",
            }
        },

         computed:{
            allBeers(){
                return this.$store.state.allBeers;
            },
            
        },

        methods:{

            editBeer(beer,index){
                this.chosenBeer = beer;
                this.$store.commit('setChosenBeerToUpdate', beer);
                this.chosenIndex = index;
                this.$store.commit('setChosenIndexToUpdate', index);
                this.$router.push('/admin/update-beer')
            },

            deleteBeer(beer,index){
           
                this.deleteBeerFromDB(beer.id);  // Remove from Database
                                  
                this.$store.commit('removeBeerFromAllBeers', index);  // Remove from allBeers in store

                this.beerHasBeenDeleted = true;       // Show user message
            
                setTimeout(() => {this.beerHasBeenDeleted = false;}, 1000); 

            },

            async deleteBeerFromDB(id){
                
                try{
                    let result = await fetch ('/api/beersorts/' + id, {
                        method: 'DELETE',
                        headers: {
                            'Content-Type' : 'application/json'
                        },
                        body: null
                    })

                    let dataFromDB =  result.status;
                    console.log("Status ", dataFromDB);

                }catch(error){
                    console.log("Gick inte att ta bort")
                    console.log(error);

                }
                
            }

        },

    }
</script>

<style scoped>
table {
    text-align: left;
}

button{
    margin-left: 25px;
}
</style>