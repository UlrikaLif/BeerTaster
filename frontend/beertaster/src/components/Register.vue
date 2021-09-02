<template>
    <div>

        <h3>Registrera nytt konto</h3>
        <form @submit="sendForm">
            <div class="error" v-if="errors.length">
                <b>Åtgärda detta innan du skickar in: </b>
                <ul>
                    <li v-for="(error,index) in errors" :key="index"> {{error}}</li>
                </ul>
            </div>
            <div>
                <label for="username"><Strong>Ange Användarnamn:  </Strong></label>
                <input id="username" v-model="username" type="text" name="username">
            </div>
            <div>
                <label for="password"><Strong>Ange Lösenord:  </Strong></label>
                <input id="password" v-model="password" type="password" name="password">  
            </div>
            <div>
                <label for="password2"><Strong>Upprepa Lösenord:  </Strong></label>
                <input id="password2" v-model="password2" type="password" name="password2">  
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
    name: "Register",

    data(){
        return{
            username:"",
            password:"",
            password2:"",
            errors:[],
        }
    },

    computed:{
       
    },

    methods:{
        checkForm (e) {
        
            if (this.username && this.password && this.password2 && (this.password == this.password2)){
                return true;
            }

            this.errors = [];

            if (!this.username){
                this.errors.push('Fyll i Användarenamn');
            }

            if (!this.password){
                this.errors.push('Fyll i Lösenord'); 
            }

            if (!this.password2){
                this.errors.push('Fyll i Upprepa Lösenord'); 
            }

            if (this.password2 != this.password){
                this.errors.push('De två fälten för lösenord har inte samma värde'); 
            }

            e.preventDefault();
        },

        sendForm(e){
            
            if (this.checkForm(e)){
                this.registerUser();
                console.log(this.username, this.password);

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
        },

        async registerUser(){
            const newUser = {
                username: this.username,
                password: this.password
            }

            let response = await fetch ("/auth/register", {
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(newUser)
            });

            try{
                response = await response.json()

                console.log("New User : ", response)

                this.customLogin();
                
            } catch {
                console.log("Fel användarnamn/lösenord")
            }
        },
    }
}
</script>

<style scoped>
div{
    margin: 20px;
}

.register{
    margin-top: 50px;
}

.error{
    color: rgb(214, 18, 18);
}

input, select{
        margin-left: 10px;
    }

</style>