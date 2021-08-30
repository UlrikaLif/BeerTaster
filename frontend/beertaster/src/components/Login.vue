<template>
    <div>

        <h3>Logga in</h3>
        <form @submit="sendForm">
            <div v-if="errors.length">
                <b>Var vänlig och korrigera följande fel innan du skickar in: </b>
                <ul>
                    <li v-for="(error,index) in errors" :key="index"> {{error}}</li>
                </ul>
            </div>
            <div>
                <label for="username"><Strong>Användarnamn:  </Strong></label>
                <input id="username" v-model="username" type="text" name="username">
            </div>
            <div>
                <label for="password"><Strong>Lösenord:  </Strong></label>
                <input id="password" v-model="password" type="password" name="password">  
            </div>
            <div class="form-button">
                <input type="submit" value="Skicka in">
                <input type="reset" value="Rensa formulär">
            </div>
            
        </form>

    </div>
</template>

<script>
export default {
    name: "Login",

    data(){
        return{
            username:"",
            password:"",
            errors:[],
        }
    },

    computed:{
        loggedIn(){
            return this.$store.state.loggedIn;
        }
    },

    methods:{
        checkForm (e) {
            
            if (this.username && this.password){
                return true;
            }

            this.errors = [];

            if (!this.username){
                this.errors.push('Användarenamn är obligatoriskt');
            }

             if (!this.password){
                this.errors.push('Lösenord är obligatoriskt');
            }

            e.preventDefault();
        },

        sendForm(e){
            
            if (this.checkForm(e)){
                this.customLogin();
                       

            }

            e.preventDefault();
        },

        async customLogin(){

            const credentials = {
                username: this.username,
                password: this.password
            }

            let response = await fetch ("/auth/login", {
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(credentials)
            });

            try{
                response = await response.json()

                console.log("User : ", response)

                // Save current user in store and change inlogged status
                this.$store.commit('setCurrentUser', response);
                this.$store.commit('setLoggedIn', true);


                // Go to userPage
                this.$router.push('/user-page');
                
            } catch {
                console.log("Fel användarnamn/lösenord")
            }
        }
        
    }
}
</script>

<style scoped>
div{
    margin: 20px;
}

input, select{
        margin-left: 10px;
    }

</style>