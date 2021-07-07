<template>
  <div class="p-3">
    <div class="p-5 pt-3 bg-gray-100 rounded-3xl shadow-lg">
      <h1 class="text-xs font-bold uppercase tracking-wide text-gray-500 text-center">Election tracker</h1>

      <div class="flex flex-row items-center mt-3 relative">
        <div class="absolute w-3/5 ml-2 h-full z-0 -left-1 flex items-center">
          <div class="border-b-2 border-dotted border-gray-400 w-full"></div>
        </div>
        <div v-for="i in 4" :key="i" class="flex flex-row items-center uppercase text-tiny font-bold tracking-wide z-10">
          <div :class="`border-4 border-gray-100 rounded-full ${$store.state.game.gameState.electionTracker === (i - 1) ?
           'w-8 h-8 bg-red-500' : 'w-6 h-6'} ${i === 4 ? 'bg-gray-900' : 'bg-gray-600'}`"></div>
          <div class="mx-3 text-gray-500" v-if="i !== 4">  </div>
          <div class="ml-3 text-center text-gray-900 bg-gray-100" v-else>Reveal & pass<br>top policy</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import {defineComponent} from "vue";

export default defineComponent({
  name: "ElectionTracker",
})
</script>

<style scoped>

</style>