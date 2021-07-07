<template>
  <div class="m-3 mb-0 py-2 rounded-lg text-2xl text-black font-black">
    {{ $store.state.game.gameState.phase }}
  </div>
</template>

<script lang="ts">
import {defineComponent} from "vue";

export default defineComponent({
  name: "GamePhase"
})
</script>