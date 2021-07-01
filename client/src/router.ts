import {createRouter, createWebHashHistory} from "vue-router";
import Home from "./views/Home.vue";
import Lobby from "./views/Lobby.vue";

export default createRouter({
    history: createWebHashHistory(),
    routes: [
        {
            path: "/",
            component: Home
        },
        {
            path: "/lobby/:id",
            component: Lobby
        }
    ]
});