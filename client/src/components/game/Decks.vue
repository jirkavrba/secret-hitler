<template>
  <div class="p-3 pb-0">
    <div class="rounded p-5 bg-gray-900">
      <h1 class="text-sm font-bold uppercase tracking-wide text-gray-500 text-center">Policies decks</h1>

      <div class="flex flex-row mt-3">
        <div class="flex flex-col mr-2 items-center w-24">
          <h2 class="text-2xl text-white font-bold">{{ $store.state.game.gameState.drawingDeckCards }}</h2>
          <h3 class="uppercase text-xs font-black tracking-wider text-gray-700">Drawing</h3>
        </div>

        <div class="flex flex-col items-center w-24">
          <h2 class="text-2xl text-white font-bold">{{ $store.state.game.gameState.discardingDeckCards }}</h2>
          <h3 class="uppercase text-xs font-black tracking-wider text-gray-700">Discarding</h3>
        </div>
      </div>

    </div>
  </div>
</template>

<script lang="ts">

import {defineComponent} from "vue";

export default defineComponent({
  name: "Decks"
})
</script>

<style scoped>

</style>