<template>
  <div class="p-3">
    <div class="rounded bg-gray-50 p-5 z-10">
      <h1 class="text-md font-bold uppercase tracking-wide text-gray-500">Players</h1>

      <div class="mt-10 relative">
        <div v-if="$store.state.game.playerState.availablePlayerTargets.length > 0"
            class="absolute left-0 top-0 w-full h-full ring-highlight ring-offset-highlight duration-75 ring-yellow-200 rounded animate-pulse"></div>
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

export default defineComponent({
  name: "Players",
  components: {Player}
})
</script>

<style scoped>

</style>