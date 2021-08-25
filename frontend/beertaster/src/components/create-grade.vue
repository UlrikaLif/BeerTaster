<template>
    <div>
        <h1>Skapa ett nytt omdöme</h1>


        <form id="grade-form" @submit="createGrade">

            <p v-if="errors.length">
                <b>Var vänlig och korrigera följande fel innan du skickar in: </b>
                <ul>
                    <li v-for="(error,index) in errors" :key="index"> {{error}}</li>
                </ul>
            </p>

            <p>
                <label for="givenGrade"><Strong>Mitt totala betyg: </Strong></label>
                <input id="givenGrade" v-model="givenGrade" type="number" name="givenGrade" min="1" max="5">
            </p>

            <div>
                <strong>Mitt omdöme: </strong><br>
                <textarea id="opinion" v-model="opinion" name="opinion" rows="5" cols="50"></textarea>
            </div>

            <div>
                <strong>Utseende: </strong><br>
                <textarea id="appearance" v-model="appearance" name="appearance" rows="3" cols="50"></textarea>
            </div>

            <div class="fragrance">
                <strong> Doft: </strong> <br>
                <textarea id="fragrance" v-model="fragrance" name="fragrance" rows="3" cols="50"></textarea>
            </div>

            <div class="taste">
                <p><strong>Smak: </strong></p>
                <p>
                    <label for="bitterness">Beskhet: </label>
                    <input id="bitterness" v-model="bitterness" type="number" name="bitterness" min="1" max="5">
                </p>

                <p>
                    <label for="fullness">Fyllighet: </label>
                    <input id="fullness" v-model="fullness" type="number" name="fullness" min="1" max="5">
                </p>

                <p>
                    <label for="freshness">Friskhet: </label>
                    <input id="freshness" v-model="freshness" type="number" name="freshness" min="1" max="5">
                </p>

                <p>
                    <label for="sweetness">Sötma: </label>
                    <input id="sweetness" v-model="sweetness" type="number" name="sweetness" min="1" max="5">
                </p>
            </div>     
            
            <p class="form-button">
                <input type="submit" value="Skicka in">
                <input type="reset" value="Rensa formulär">
            </p>

            
        </form>



    </div>
  
</template>

<script>
export default {
    name: "CreateGrade",

    data(){
        return{
            errors:[],
            givenGrade: null,
            opinion: null,
            appearance: null,
            fragrance: null,
            bitterness: null,
            fullness: null,
            freshness: null,
            sweetness: null,

        }
    },

    computed:{
        currentUser(){
            return this.$store.state.currentUser;
        },
        currentBeer(){
            return this.$store.state.currentBeer;
        },
        lastGrade(){
            return this.$store.state.lastGrade;
        }

    },


    methods:{
        checkForm (e) {
            
            if (this.givenGrade && this.opinion){
                return true;
            }

            this.errors = [];

            if (!this.givenGrade){
                this.errors.push('Betyg är obligatoriskt');
            }

             if (!this.opinion){
                this.errors.push('Omdöme är obligatoriskt');
            }

            e.preventDefault();
        },

        createGrade(e){
            
            if (this.checkForm(e)){
                console.log("Vi kan skapa ett betyg!")

                let newGrade = {
                    givenGrade: this.givenGrade,
                    opinion: this.opinion,
                    appearance: this.appearance,
                    fragrance: this.fragrance,
                    bitterness: this.bitterness,
                    fullness: this.fullness,
                    freshness: this.freshness,
                    sweetness: this.sweetness,
                }

                this.addGradeToDB(newGrade);


            }

            e.preventDefault();
        },

        async addGradeToDB(grade){

            let userId = "2";   //currentUser.id;
            let beerId = "4" //currentBeer.id;
            let suppl = userId + '/' + beerId;
            
            try{
                let result = await fetch ('/api/'+ suppl + '/grades', {
                    method: 'POST',
                    headers: {
                        'Content-Type' : 'application/json'
                    },
                    body: JSON.stringify(grade)
                })

                let dataFromDB = await result.json();
                console.log("Response ", dataFromDB);


            }
            catch(err){
                console.log("FEL - kunde inte lägga till i databasen")
            }

        }

        



    }

}
</script>

<style scoped>

    input, select{
        margin-left: 10px;
    }

    form {
        text-align: left;
    }
  

</style>