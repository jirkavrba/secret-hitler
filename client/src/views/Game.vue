<template>
  <div class="grid grid-cols-4 container">
    <div class="flex flex-col">
      <Players/>
      <div class="text-center text-gray-400 text-tiny">
        Btw this shit is <a href="https://github.com/jirkavrba/secret-hitler" target="_blank" class="transition text-gray-500 hover:text-purple-500">open source</a>
      </div>
      <div class="text-center text-gray-400 text-tiny">
        Originally designed by <a href="https://secrethitler.com" target="_blank" class="transition text-gray-500 hover:text-purple-500">the Goat, Wolf, & Cabbage</a>
      </div>
    </div>
    <div class="col-span-2 flex flex-col">
      <GamePhase/>
      <EnactedPolicies/>
      <div class="flex flex-row item-center justify-between">
        <ElectionTracker/>
        <Decks/>
      </div>
      <PartyMembershipClaims/>
      <PoliciesClaims/>
      <Policies/>
      <Votes/>
    </div>
    <Chat/>
  </div>
</template>

<style>
.container {
  min-width: 100vw;
  min-height: 100vh;
}
</style>

<script lang="ts">
import {defineComponent} from 'vue';
import Players from "../components/game/Players.vue";
import EnactedPolicies from "../components/game/EnactedPolicies.vue";
import ElectionTracker from "../components/game/ElectionTracker.vue";
import Decks from "../components/game/Decks.vue";
import Votes from "../components/game/Votes.vue";
import GamePhase from "../components/game/GamePhase.vue";
import PartyMembershipClaims from "../components/game/PartyMembershipClaims.vue";
import PoliciesClaims from "../components/game/PoliciesClaims.vue";
import Chat from "../components/game/Chat.vue";
import Policies from "../components/game/Policies.vue";

export default defineComponent({
  name: "Game",
  components: {
    Policies,
    Chat,
    PoliciesClaims,
    PartyMembershipClaims,
    GamePhase,
    Votes,
    Decks,
    ElectionTracker,
    EnactedPolicies,
    Players,
  }
});
</script>