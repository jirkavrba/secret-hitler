<template>
  <div class="grid grid-cols-5 container">
    <Players/>
    <div class="col-span-3 flex flex-col">
      <EnactedPolicies/>
      <div class="flex flex-row items-start justify-between">
        <ElectionTracker/>
        <Decks/>
      </div>
    </div>
    <div class="bg-green-500">CHAT</div>
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

export default defineComponent({
  name: "Game",
  components: {
    Decks,
    ElectionTracker,
    EnactedPolicies,
    Players
  }
});
</script>