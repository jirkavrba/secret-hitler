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
                        username: "My name's Jeff",
                        alive: true,
                    },
                    "8ddd8049-155b-4980-b7e6-a79de1e0a20c": {
                        id: "8ddd8049-155b-4980-b7e6-a79de1e0a20c",
                        username: "0x4a69726b61",
                        alive: true,
                    },
                    "33c3cac2-8009-4470-aa0b-1d0ab5ee0270": {
                        id: "33c3cac2-8009-4470-aa0b-1d0ab5ee0270",
                        username: "Another Jeff",
                        alive: true,
                    },
                    "5e06a048-866c-4edf-9bdd-8e6ee3b98c10": {
                        id: "5e06a048-866c-4edf-9bdd-8e6ee3b98c10",
                        username: "Not Jeff at all",
                        alive: true,
                    },
                    "27f1f378-3b4e-428d-8639-766bac14f619": {
                        id: "27f1f378-3b4e-428d-8639-766bac14f619",
                        username: "Mike, but he's dead",
                        alive: false,
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
                    chancellor: "3cba6f3c-487f-40d0-a9fb-cdc43c88adfd",
                },
                lastElectedGovernment: {
                    president: "8ddd8049-155b-4980-b7e6-a79de1e0a20c",
                    chancellor: "27f1f378-3b4e-428d-8639-766bac14f619",
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
                id: "33c3cac2-8009-4470-aa0b-1d0ab5ee0270",
                alive: true,
                rolesKnowledge: {
                    "3cba6f3c-487f-40d0-a9fb-cdc43c88adfd": "HIDDEN",
                    "8ddd8049-155b-4980-b7e6-a79de1e0a20c": "LIBERAL",
                    "33c3cac2-8009-4470-aa0b-1d0ab5ee0270": "HITLER",
                    "5e06a048-866c-4edf-9bdd-8e6ee3b98c10": "FASCIST",
                    "27f1f378-3b4e-428d-8639-766bac14f619": "LIBERAL"
                },
                availablePlayerTargets: [],
                availablePolicies: [],
                availableClaims: [],
                peekedPolicies: [],
                investigatedPartyMembership: null
            }
        }
    }
})