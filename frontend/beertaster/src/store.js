import { createStore } from 'vuex'

const state = {
    allBeers: [],
    currentUser: {}, 
    currentBeer: {},
    myGrades: [],
    currentBeerGrades: [],
    loggedIn: false,
    chosenBeerToUpdate: {},
    chosenIndexToUpdate: ""
    
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
    },

    setCurrentBeerGrades(state, gradeList){
        state.currentBeerGrades = gradeList;
    },

    setChosenBeerToUpdate(state, beer){
        state.chosenBeerToUpdate = beer;
    },

    setChosenIndexToUpdate(state, index){
        state.chosenIndexToUpdate = index;
    },

    addBeerToAllBeers(state,beer){
        state.allBeers.push(beer);
    },

    removeBeerFromAllBeers(state,index){
        state.allBeers.splice(index, 1);
    }

    
        

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

        store.commit ('setMyGrades', gradeList);
    },

}


export default createStore({state, mutations, actions})