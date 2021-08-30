import { createStore } from 'vuex'

const state = {
    allBeers: [],
    currentUser: {}, 
    currentBeer: {},
    myGrades: [],
    currentBeerGrades: [],
    loggedIn: false,
    
}


const mutations = {
    setAllBeers(state,beerList){
        state.allBeers = beerList;
    },

    setCurrentUser(state, user){
        state.currentUser = user;
    },

    setCurrentBeer(state, beer){
        state.currentBeer = beer;
    },

    setLoggedIn(state, boolean){
        state.loggedIn = boolean;
    },

    setMyGrades(state, gradeList){
        state.myGrades = gradeList;
        console.log("setMyGrades: ", state.myGrades)
    },

    setCurrentBeerGrades(state, gradeList){
        state.currentBeerGrades = gradeList;
    },

        

}

const actions = {
    async getAllBeersFromDB(store) {
        let beerList = await fetch("/api/beersorts")
        try {
            beerList = await beerList.json()
            console.log('response ', beerList)
        } catch(error) {
            console.log('Error happened here!')
            console.error(error)
        }
        store.commit ('setAllBeers', beerList)
    },

    async getMyGradesFromDB(store) {
        
        let userId = this.state.currentUser.id;
        
        let gradeList = await fetch("/api/"+userId+"/grades")
        try {
            gradeList = await gradeList.json()
            console.log('response ', gradeList)
        } catch(error) {
            console.log('Error happened here!')
            console.error(error)
        }

        /*
        for (let grade of gradeList){
            console.log("My grade: ", grade)
            grade['beerSort'] = grade['beerSort'].id;
            console.log("My new grade: ", grade)
        }*/
        console.log("My new gradelist: ",gradeList)
        store.commit ('setMyGrades', gradeList);
    },

}


export default createStore({state, mutations, actions})