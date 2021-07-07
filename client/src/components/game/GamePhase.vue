<template>
  <div class="bg-gray-900 m-3 mb-0 p-5 rounded text-xl text-white font-bold">
    {{ $store.state.game.gameState.phase }}
  </div>
</template>

<script lang="ts">
import {defineComponent} from "vue";

export default defineComponent({
  name: "GamePhase"
})
</script>