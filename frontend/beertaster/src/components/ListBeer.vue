<template>
  <div>
        <h3>Lista över alla öl i databasen</h3>

        <div v-if="beerHasBeenUpdated">

        </div>

        <div v-else-if="beerHasBeenDeleted">

            <p>Ölet har raderats.</p>

        </div>

        <div v-else>
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
                        <td><button class="edit-beer-btn">Redigera</button></td>
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
                beerHasBeenUpdated: false,
                beerHasBeenDeleted: false,
                
            }
        },

         computed:{
            allBeers(){
                return this.$store.state.allBeers;
            },
            
        },

        methods:{

            deleteBeer(beer,index){
           
                this.deleteBeerFromDB(beer.id);
                
                  
                this.$store.commit('removeBeerFromAllBeers', index);

                this.beerHasBeenDeleted = true;
            
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