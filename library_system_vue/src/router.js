import Vue from 'vue'
import Router from 'vue-router'

// 导入编写的组件
import AppIndex from '@/components/home/AppIndex'
import Login from '@/components/Login'
import Home from '@/components/Home'
import LibraryIndex from "@/components/library/LibraryIndex"
import UserIndex from "@/components/library/user/UserIndex"
import Register from "@/components/Register";
import Log from "@/components/library/user/Log";
Vue.use(Router)

export default new Router({
    mode: 'history', //从默认的hash模式切换为history模式
    routes: [
        {path: '/', redirect: '/login'},
        {path: '/login', name: 'Login', component: Login},
        {path: '/register', name: 'Register', component: Register},
        {path: '/home', name: 'Home', component: Home, redirect: '/index', // home页面并不需要被访问
            children: [ //之后的新页面可以直接在children中加入
                {
                    path: '/index',name: 'AppIndex', component: AppIndex,
                    meta: {requireAuth: true}
                },
                {
                    path: '/library',name: 'Library',component: LibraryIndex,
                    meta: {requireAuth: true}
                },
                {
                    path: '/user',name: 'User',component: UserIndex,
                    meta: {requireAuth: true}
                },
                {
                    path: '/log',name: 'Log',component: Log,
                    meta: {requireAuth: true}
                }
            ]
        },
    ]
})