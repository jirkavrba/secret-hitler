<template>
  <div class="p-3">
    <div class="rounded bg-gray-50 p-5">
      <h1 class="text-md font-bold uppercase tracking-wide text-gray-500">Players</h1>

      <div>
        <Player v-for="player in Object.keys($store.state.game.gameState.players)"
                :key="player"
                :id="player"
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