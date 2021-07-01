import {createStore} from "vuex";

export default createStore({
    state: {
        id: window.localStorage.getItem("player-id"),
        token: window.localStorage.getItem("player-token"),
        username: window.localStorage.getItem("player-username"),
        lobby: {
            id: "22fbd52e-384f-4f79-9102-ea278afa896c",
            invite: "W9JLSYDV",
            players: [
                {
                    id: "33c3cac2-8009-4470-aa0b-1d0ab5ee0270",
                    username: "First guy",
                    ready: true
                },
                {
                    id: "5e06a048-866c-4edf-9bdd-8e6ee3b98c10",
                    username: "Second guy",
                    ready: false
                }
            ]
        },
        game: {
            id: "3cba6f3c-487f-40d0-a9fb-cdc43c88adfd",
            gameState: {
                playing: true,
                phase: "PRESIDENT_IS_SELECTING_CHANCELLOR",
                players: {
                    "3cba6f3c-487f-40d0-a9fb-cdc43c88adfd": {
                        id: "3cba6f3c-487f-40d0-a9fb-cdc43c88adfd",
                        alive: true,
                        role: "HIDDEN"
                    },
                    "8ddd8049-155b-4980-b7e6-a79de1e0a20c": {
                        id: "8ddd8049-155b-4980-b7e6-a79de1e0a20c",
                        alive: true,
                        role: "HITLER"
                    },
                    "33c3cac2-8009-4470-aa0b-1d0ab5ee0270": {
                        id: "33c3cac2-8009-4470-aa0b-1d0ab5ee0270",
                        alive: true,
                        role: "FASCIST"
                    },
                    "5e06a048-866c-4edf-9bdd-8e6ee3b98c10": {
                        id: "5e06a048-866c-4edf-9bdd-8e6ee3b98c10",
                        alive: true,
                        role: "LIBERAL"
                    },
                    "27f1f378-3b4e-428d-8639-766bac14f619": {
                        id: "27f1f378-3b4e-428d-8639-766bac14f619",
                        alive: true,
                        role: "HIDDEN"
                    }
                },
                enactedPolicies: {
                    fascist: 2,
                    liberal: 3
                },
                drawingDeckCards: 3,
                discardingDeckCards: 4,
                government: {
                    president: "5e06a048-866c-4edf-9bdd-8e6ee3b98c10",
                    chancellor: null
                },
                lastElectedGovernment: {
                    president: "8ddd8049-155b-4980-b7e6-a79de1e0a20c",
                    chancellor: "8ddd8049-155b-4980-b7e6-a79de1e0a20c"
                },
                election: {
                    votes: {
                        "3cba6f3c-487f-40d0-a9fb-cdc43c88adfd": "NONE",
                        "8ddd8049-155b-4980-b7e6-a79de1e0a20c": "NONE",
                        "33c3cac2-8009-4470-aa0b-1d0ab5ee0270": "HIDDEN",
                        "5e06a048-866c-4edf-9bdd-8e6ee3b98c10": "HIDDEN",
                        "27f1f378-3b4e-428d-8639-766bac14f619": "NONE"
                    }
                },
                winners: null
            },
            playerState: {
                // TODO
            }
        }
    }
})