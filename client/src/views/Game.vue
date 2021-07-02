<template>
  <div class="grid grid-cols-4 container">
    <Players/>
    <div class="col-span-2 flex flex-col">
      <EnactedPolicies/>
      <div class="flex flex-row item-center justify-between">
        <ElectionTracker/>
        <Decks/>
      </div>
      <Votes/>
    </div>
    <div class="">CHAT</div>
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

export default defineComponent({
  name: "Game",
  components: {
    Votes,
    Decks,
    ElectionTracker,
    EnactedPolicies,
    Players,
  }
});
</script>