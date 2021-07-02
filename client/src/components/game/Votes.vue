<template>
  <div v-if="$store.state.game.gameState.phase === 'VOTING_FOR_THE_GOVERNMENT'" class="p-3 relative self-start">
    <div
        class="absolute left-0 top-0 ring-offset-black w-full h-full ring-highlight ring-offset-highlight duration-75 ring-yellow-200 rounded animate-pulse"></div>
    <div class="p-5 bg-gray-900 rounded">
      <h1 class="text-sm font-bold uppercase tracking-wide text-gray-500 text-left">Vote for the government</h1>

      <div class="mt-3 flex flex-row p-5">
        <img :src="images.ja" alt="Ja!"
             :class="`w-32 rounded mr-6 cursor-pointer transform transition
             ${selected === 'ja' ? 'scale-110 ring-8 ring-green-600 z-20' : 'hover:scale-90 hover:rotate-6'}
             ${selected === 'nein' ? 'opacity-30 translate-x-16 hover:translate-x-8 hover:opacity-60' : ''}
             `" @click="vote('ja')">

        <img :src="images.nein" alt="Nein!"
             :class="`w-32 rounded cursor-pointer transform transition
             ${selected === 'ja' ? 'opacity-30 -translate-x-16 hover:-translate-x-8 hover:opacity-60 z-10' : '' }
             ${selected === 'nein' ? 'scale-110 ring-8 ring-red-500' : 'hover:scale-90 hover:rotate-6' }
             `"
             @click="vote('nein')">
      </div>
    </div>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import ja from "../../assets/votes/ja.png";
import nein from "../../assets/votes/nein.png";

export default defineComponent({
  name: "Votes",
  data: () => ({
    selected: null,
    images: {
      ja,
      nein
    }
  }),
  methods: {
    vote(which) {
      console.log(which);
      if (this.selected === which) {
        this.selected = "none";
      }
      else {
        this.selected = which;
      }
    }
  }
})
</script>