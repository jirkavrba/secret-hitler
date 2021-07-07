<template>
  <div class="p-3 pb-0">
    <div class="rounded-3xl p-5 pt-3 bg-gray-100 shadow-lg">
      <h1 class="text-xs font-bold uppercase tracking-wide text-gray-500 text-center">Policies decks</h1>

      <div class="flex flex-row mt-2">
        <div class="flex flex-col mr-2 items-center w-24">
          <h2 class="text-2xl text-black font-bold">{{ $store.state.game.gameState.drawingDeckCards }}</h2>
          <h3 class="uppercase text-xs font-black tracking-wider text-gray-700">Drawing</h3>
        </div>

        <div class="flex flex-col items-center w-24">
          <h2 class="text-2xl text-black font-bold">{{ $store.state.game.gameState.discardingDeckCards }}</h2>
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