<template>
  <div class="p-3 pb-0">
    <div class="rounded-3xl p-5 bg-gray-100 shadow-lg relative">
      <div class="p-5 rounded-2xl flex justify-center bg-gradient-to-r from-blue-200 to-blue-300">
        <div v-for="i in liberal" :key="i" class="bg-blue-100 m-3 rounded-lg w-24 h-32 shadow-lg">
          <img src="../../assets/policies/liberal.png" alt="Fascist policy"
               :class="`transform filter -translate-y-2 scale-75 drop-shadow-lg ${rotation(i)}`">
        </div>
        <div v-for="i in (4 - liberal)" :key="i"
             class=" m-3 rounded-lg w-24 h-32 border-2 bg-blue-300 border-blue-100 shadow-inner"></div>
        <div
            class="m-3 rounded-lg w-24 h-32 border-2 border-blue-100 bg-blue-400 flex items-center justify-center shadow-inner">
          <img src="../../assets/liberals.png" class="w-20">
        </div>
      </div>

      <div class="p-5 rounded-2xl flex justify-center mt-5 bg-gradient-to-r from-red-200 to-red-300">
        <div v-for="i in fascist" :key="i" class="bg-red-100 m-3 rounded-lg w-24 h-32 shadow-lg">
          <img src="../../assets/policies/fascist.png" alt="Fascist policy"
               :class="`transform filter -translate-y-2 scale-75 drop-shadow-lg ${rotation(5 + i)}`">
        </div>
        <div v-for="i in (5 - fascist)" :key="i"
             class="m-3 rounded-lg w-24 h-32 border-2 bg-red-300 border-red-100 flex items-center justify-center shadow-inner">
          <div v-if="ability(fascist + i) !== null" class="w-12">
            <img :src="ability(fascist + i).image" :alt="ability(fascist + i).text"
                 :title="ability(fascist + i).text">
          </div>
        </div>
        <div class="m-3 rounded-lg w-24 h-32 border-2 border-red-100 bg-red-400 flex items-center justify-center">
          <img src="../../assets/fascists.png" class="w-20">
        </div>
      </div>
      <div :class="`absolute w-full h-full flex flex-col items-center justify-center left-0 top-0 rounded-3xl bg-opacity-80
          ${$store.state.game.gameState.winners === 'fascists' ? 'bg-red-900' : 'bg-blue-900'}`">
        <img :src="images[$store.state.game.gameState.winners]" class="m-5">
        <b :class="`uppercase text-4xl font-bold ${$store.state.game.gameState.winners === 'fascists' ? 'text-red-300' : 'text-blue-300'}`">{{ $store.state.game.gameState.winners }}</b>
        <span class="text-gray-200 font-black">won this game</span>

      </div>
    </div>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import peekPolicies from "../../assets/abilities/peek-policies.png";
import executePlayer from "../../assets/abilities/execute-player.png";
import investigateLoyalty from "../../assets/abilities/investigate-loyalty.png";
import callSpecialElection from "../../assets/abilities/call-special-election.png";

import fascists from "../../assets/fascists.png";
import liberals from "../../assets/liberals.png";

const multiplies = [-6, -3, -2, 2, 3, 6];

export default defineComponent({
  name: "EnactedPolicies",
  data: () => ({
    images: {
      fascists,
      liberals
    },
    rotations: (new Array(11).fill(0).map(() => multiplies[Math.floor(Math.random() * multiplies.length)])),
    abilities: {
      "PEEK_TOP_THREE_POLICIES": {
        image: peekPolicies,
        text: "The president examines top three cards."
      },
      "EXECUTE_PLAYER": {
        image: executePlayer,
        text: "The president must kill a player."
      },
      "CALL_SPECIAL_ELECTION": {
        image: callSpecialElection,
        text: "The president must select the next presidential candidate."
      },
      "INVESTIGATE_LOYALTY": {
        image: investigateLoyalty,
        text: "The president must investigate party membership of one of the players."
      }
    }
  }),
  methods: {
    rotation(i) {
      const rotation = this.rotations[i].toString();

      if (rotation < 0) {
        return `-rotate-${-rotation}`;
      }

      return `rotate-${rotation}`;
    },
    ability(i) {
      const target = this.$store.state.game.gameState.enactedPolicies.abilities[i];

      if (typeof target === "undefined") {
        return null;
      }

      console.log(this.abilities[target].text);

      return this.abilities[target];
    },
  },
  computed: {
    liberal() {
      return this.$store.state.game.gameState.enactedPolicies.liberal;
    },
    fascist() {
      return this.$store.state.game.gameState.enactedPolicies.fascist;
    }
  }
})
</script>

<style scoped>

</style>