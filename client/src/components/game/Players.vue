<template>
  <div class="p-3">
    <div class="rounded bg-gray-50 p-5">
      <h1 class="text-md font-bold uppercase tracking-wide text-gray-500">Players</h1>

      <div class="mt-5">
        <Player v-for="player in $store.state.game.gameState.players"
            :key="player.id"
            :id="player.id"
            :alive="player.alive"
            :username="player.username"
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