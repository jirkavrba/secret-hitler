import {createRouter, createWebHashHistory} from "vue-router";
import Home from "./views/Home.vue";
import Lobby from "./views/Lobby.vue";
import Game from "./views/Game.vue";

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
        },
        {
            path: "/game/:id",
            component: Game
        }
    ]
});