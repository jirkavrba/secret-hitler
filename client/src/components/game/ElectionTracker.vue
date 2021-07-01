<template>
  <div class="p-3">
    <div class="p-5 bg-gray-900 rounded">
      <h1 class="text-md font-bold uppercase tracking-wide text-gray-500">Election tracker</h1>

      <div class="flex flex-row items-center mt-3">
        <div v-for="i in 4" :key="i" class="flex flex-row items-center uppercase text-tiny font-bold tracking-wide">
          <div :class="` rounded-full ${$store.state.game.gameState.electionTracker === (i - 1) ?
           'ring-2 ring-offset-4 ring-red-500 ring-offset-gray-900 bg-gray-500 w-4 h-4 ' : 'w-6 h-6'} ${i === 4 ? 'bg-gray-500' : 'bg-gray-600'}`"></div>
          <div class="mx-3 text-gray-500" v-if="i !== 4"> &raquo; fail &raquo;</div>
          <div class="ml-3 text-center text-gray-200" v-else>Reveal & pass<br>top policy</div>
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