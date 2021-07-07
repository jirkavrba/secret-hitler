<template>
  <div class="p-3">
    <div class="rounded-3xl bg-gray-100 pt-3 p-5 z-10 relative shadow-lg">
      <h1 class="text-xs text-center font-bold uppercase tracking-wide text-gray-500">Players</h1>

      <Highlight v-if="$store.state.game.playerState.availablePlayerTargets.length > 0"/>

      <div class="mt-2">
        <Player v-for="player in $store.state.game.gameState.players"
            :key="player.id"
            :id="player.id"
            :alive="player.alive"
            :username="player.username"
            :selectable="$store.state.game.playerState.availablePlayerTargets.length !== 0"
            :enabled="$store.state.game.playerState.availablePlayerTargets.includes(player.id)"
            :role="$store.state.game.playerState.rolesKnowledge[player.id].toLowerCase()"
        />
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import {defineComponent} from "vue";
import Player from "./Player.vue";
import Highlight from "./Highlight.vue";

export default defineComponent({
  name: "Players",
  components: {Highlight, Player}
})
</script>

<style scoped>

</style>