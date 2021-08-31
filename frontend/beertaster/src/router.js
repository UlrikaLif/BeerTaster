import { createRouter, createWebHistory } from 'vue-router'

import Home from '/src/components/Home.vue'
import Login from '/src/components/Login.vue'
import Logout from '/src/components/Logout.vue'
import UserPage from '/src/components/UserPage.vue'
import CreateGrade from '/src/components/create-grade.vue'
import ViewGrade from '/src/components/view-grades.vue'


// Routes to components
const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
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

]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router