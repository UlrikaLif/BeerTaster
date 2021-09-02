import { createRouter, createWebHistory } from 'vue-router'

import Home from '/src/components/Home.vue'
import About from '/src/components/About.vue'
import Login from '/src/components/Login.vue'
import Register from '/src/components/Register.vue'
import Logout from '/src/components/Logout.vue'
import UserPage from '/src/components/UserPage.vue'
import CreateGrade from '/src/components/create-grade.vue'
import ViewGrade from '/src/components/view-grades.vue'
import Admin from '/src/components/Admin.vue'
import UpdateBeer from '/src/components/UpdateBeer.vue'


// Routes to components
const routes = [

    // Views for all

    {
        path: '/',
        name: 'Home',
        component: Home
    },

    {
        path: '/about',
        name: 'About',
        component: About
    },

    // Views for login and registration

    {
        path: '/login',
        name: 'Login',
        component: Login
    },

    {
        path: '/logout',
        name: 'Logout',
        component: Logout
    },
    
    {
        path: '/register',
        name: 'Register',
        component: Register
    },

    // Views for logged in users

    {
        path: '/user-page',
        name: 'UserPage',
        component: UserPage
    },

    {
        path: '/create-grade',
        name: 'CreateGrade',
        component: CreateGrade
    },

    {
        path: '/view-grade',
        name: 'ViewGrade',
        component: ViewGrade
    },

    // Views for admin

    {
        path: '/admin',
        name: 'Admin',
        component: Admin
    },

    {
        path: '/admin/update-beer',
        name: 'UpdateBeer',
        component: UpdateBeer
    },


]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router