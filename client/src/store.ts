import {createStore} from "vuex";

export default createStore({
    state: {
        token: window.localStorage.getItem("player-token"),
        username: window.localStorage.getItem("player-username")
    }
})