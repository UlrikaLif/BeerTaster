<template>

  <div>

    <h3>Lägg till ett nytt öl i databasen</h3>
    
    <form id="beer-form" v-on:submit.prevent="sendBeer">

        <div v-if="errors.length">
          <b>Kvar att fylla i: </b>
          <ul>
              <li v-for="(error,index) in errors" :key="index"> {{error}}</li>
          </ul>
        </div>

        <div>
        
          <p>
              <label for="name"><strong>Namn: </strong></label>
              <input id="name" v-model="name" type="text" name="name">
          </p>

          <p>
              <label for="category"><strong>Kategori: </strong></label>
              <select id="category" v-model="category" name="category">      
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
              <input id="brewery" v-model="brewery" type="text" name="brewery">
          </p>
          <p>
              <label for="country"><strong>Ursprungsland: </strong></label>
              <input id="country" v-model="country" type="text" name="country">
          </p>

          
          <p class="form-button">
              <input class="form-button" type="submit" @click="checkForm" value="Skicka in">
              <input class="form-button" type="reset" value="Rensa formulär">
          </p>

      </div>
    
    {{this.msg}}
           
    </form>

  </div>
</template>


<script>

export default {
  
  name: "AddBeer",

  data(){
    return {
      name: "",
      category: "",
      brewery: "",
      country: "",
      errors: [],
      msg: ""
      
    }
  },

  computed:{
    allBeers(){
      return this.$store.state.allBeers;
    }

  },

  methods:{
    checkForm(e){
              
      if (this.name && this.category && this.brewery && this.country){

        return true;
      }

      this.errors = [];

      if (!this.name){
          this.errors.push('Namn');
      }

      if (!this.category){
          this.errors.push('Kategori');
      }

      if (!this.brewery){
          this.errors.push('Bryggeri');
      }

      if (!this.country){
          this.errors.push('Ursprungsland');
      }

      e.preventDefault();
    },

    emptydata(){

      this.name = "";
      this.category = "";
      this.brewery = "";
      this.country = "";

    },

    existsInDB(newBeer){

      for (let beer of this.allBeers){
        if ((beer.name == newBeer.name) && (beer.category == newBeer.category) 
        && (beer.brewery == newBeer.brewery) && (beer.country == newBeer.country) ){
        
          return true;
        }
      }

      return false;
    },

    sendBeer(e){

      if (this.checkForm(e)){
        
        let newBeer = {
            name: this.name,
            category : this.category,
            brewery: this.brewery,
            country: this.country
        }

        // Check to make sure the beer is not already in the database

        if (!this.existsInDB(newBeer)){
          this.addBeerToDB(newBeer);
        }
        else{
          this.msg = "Ölet finns redan i databasen!";
          setTimeout(() => {this.msg = "";}, 2000);
          
        }
      
        
        e.preventDefault();
      }
    },

    async addBeerToDB(newBeer){

      try{
          let result = await fetch ('/api/beersorts', {
              method: 'POST',
              headers: {
                  'Content-Type' : 'application/json'
              },
              body: JSON.stringify(newBeer)
          })

          let dataFromDB = await result.json();

          // Add the beer to allBeers in store 

          newBeer['id'] = dataFromDB.id;

          this.$store.commit('addBeerToAllBeers', newBeer);
          

          this.msg = "Ölet har lagts till i databasen"
          this.emptydata();
          setTimeout(() => {this.msg = "";}, 1500); 
  
          
      }
      catch(err){
          this.msg ="Gick inte att lägga till ölet i databasen";
          console.log(err)
      }

  }


  }



}
</script>

<style scoped>

  input.form-button{
    margin-left: 25px;
  }

</style>