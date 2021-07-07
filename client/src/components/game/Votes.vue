<template>
  <div v-if="$store.state.game.gameState.phase === 'VOTING_FOR_THE_GOVERNMENT'" class="m-3 relative self-start mt-0 shadow-lg">
    <Highlight/>
    <div class="p-3 bg-gray-100 rounded-3xl">
      <h1 class="text-sm font-bold uppercase tracking-wide text-gray-500 text-center">Vote for the government</h1>

      <div class="mt-3 flex flex-row p-5">
        <img :src="images.ja" alt="Ja!"
             :class="`w-32 rounded mr-2 cursor-pointer transform transition
             ${selected === 'ja' ? 'translate-x-4 scale-110 bg-green-400 z-20' : 'hover:scale-90 hover:-rotate-6'}
             ${selected === 'nein' ? 'opacity-30 translate-x-8 hover:translate-x-4 hover:opacity-60' : ''}
             `" @click="vote('ja')">

        <img :src="images.nein" alt="Nein!"
             :class="`w-32 rounded cursor-pointer transform transition
             ${selected === 'ja' ? 'opacity-30 -translate-x-8 hover:-translate-x-4 hover:opacity-60 z-10' : '' }
             ${selected === 'nein' ? '-translate-x-4 scale-110 bg-red-400' : 'hover:scale-90 hover:rotate-6' }
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
import Highlight from "./Highlight.vue";

export default defineComponent({
  name: "Votes",
  components: {Highlight},
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