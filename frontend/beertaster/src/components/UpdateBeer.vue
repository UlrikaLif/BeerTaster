<template>
    <div>
        <h3>Redigera öl</h3>

        <form id="beer-form" v-on:submit.prevent="updateBeer">

        <div v-if="errors.length">
          <b>Kvar att fylla i: </b>
          <ul>
              <li v-for="(error,index) in errors" :key="index"> {{error}}</li>
          </ul>
        </div>

        <div>
        
          <p>
              <label for="name"><strong>Namn: </strong></label>
              <input id="name" v-model="this.chosenBeerToUpdate.name" type="text" name="name">
          </p>

          <p>
              <label for="category"><strong>Kategori: </strong></label>
              <select id="category" v-model="this.chosenBeerToUpdate.category" name="category">      
                  <option>Lager - ljus</option>
                  <option>Lager - mörk</option>
                  <option>Porter</option>
                  <option>Stout</option>
                  <option>Ale</option>
                  <option>Ale - Belgisk stil</option>
                  <option>Indian Pale Ale (IPA)</option>
                  <option>Veteöl</option>
                  <option>Syrligt öl</option>
                  <option>Annat öl</option>
              </select>
          </p>
          <p>
              <label for="brewery"><strong>Bryggeri: </strong></label>
              <input id="brewery" v-model="this.chosenBeerToUpdate.brewery" type="text" name="brewery">
          </p>
          <p>
              <label for="country"><strong>Ursprungsland: </strong></label>
              <input id="country" v-model="this.chosenBeerToUpdate.country" type="text" name="country">
          </p>

          
          <p class="form-button">
              <input class="form-button" type="submit" @click="checkForm" value="Skicka in">
              <!--<input class="form-button" type="reset" @rclick="restoreForm" value="Återställ formulär"> -->
          </p>

      </div>
    
    {{this.msg}}
           
    </form>
    </div>
</template>

<script>
export default {
    name: "UpdateBeer",

    data(){
        return{
            errors:[],
            msg:"",
        }
    },

    computed:{
        chosenBeerToUpdate(){
            return this.$store.state.chosenBeerToUpdate;
        },
        chosenIndexToUpdate(){
            return this.$store.state.chosenIndexToUpdate;
        }

    },

    methods:{

        checkForm(e){
              
            if (this.chosenBeerToUpdate.name && this.chosenBeerToUpdate.category && this.chosenBeerToUpdate.brewery && this.chosenBeerToUpdate.country){

                return true;
            }

            this.errors = [];

            if (!this.chosenBeerToUpdate.name){
                this.errors.push('Namn');
            }

            if (!this.chosenBeerToUpdate.category){
                this.errors.push('Kategori');
            }

            if (!this.chosenBeerToUpdate.brewery){
                this.errors.push('Bryggeri');
            }

            if (!this.chosenBeerToUpdate.country){
                this.errors.push('Ursprungsland');
            }

            e.preventDefault();
        },

        updateBeer(e){

            if (this.checkForm(e)){

                let editedBeer ={
                    id: this.chosenBeerToUpdate.id,
                    name: this.chosenBeerToUpdate.name,
                    category: this.chosenBeerToUpdate.category,
                    brewery: this.chosenBeerToUpdate.brewery,
                    country: this.chosenBeerToUpdate.country
                };

                this.updateBeerInDB(editedBeer);

            }

        },

        async updateBeerInDB(uppdatedBeer){

            let id = uppdatedBeer.id;

            try{
                let result = await fetch ('/api/beersorts/' + id, {
                    method: 'PUT',
                    headers: {
                        'Content-Type' : 'application/json'
                    },
                    body: JSON.stringify(uppdatedBeer)
                })

                let dataFromDB = await result.json();

                console.log("Response from update ", dataFromDB);

                this.$router.push('/admin');
                

            }
            catch(error){
                console.log("Gick inte att uppdatera")
                console.log(error);

                this.msg = "Gick inte att uppdatera";
                setTimeout(() => {this.msg = "";}, 1500);

            }

        },
    }

}
</script>

<style scoped>

    input.form-button{
        margin-left: 25px;
    } 


</style>