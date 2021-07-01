<template>
  <div class="p-3 pb-0">
    <div class="rounded p-5 bg-gray-900">
      <div class="bg-blue-900 filter saturate-50 p-5 rounded flex">
        <div v-for="i in liberal" :key="i" class="bg-blue-600 m-3 rounded w-24 h-32">
          <img src="../../assets/policies/liberal.png" alt="Fascist policy"
               :class="`transform filter -translate-y-2 scale-75 drop-shadow-lg ${rotation(i)}`">
        </div>
        <div v-for="i in (4 - liberal)" :key="i" class=" m-3 rounded w-24 h-32 border-2 border-blue-500 border-dashed"></div>
        <div class="m-3 rounded w-24 h-32 border-2 border-blue-500 bg-blue-800 flex items-center justify-center">
          <img src="../../assets/liberals.png" class="w-20">
        </div>
      </div>

      <div class="bg-red-900 filter saturate-50 p-5 rounded flex mt-5">
        <div v-for="i in fascist" :key="i" class="bg-red-600 m-3 rounded w-24 h-32">
          <img src="../../assets/policies/fascist.png" alt="Fascist policy"
               :class="`transform filter -translate-y-2 scale-75 drop-shadow-lg ${rotation(5 + i)}`">
        </div>
        <div v-for="i in (5 - fascist)" :key="i" class="m-3 rounded w-24 h-32 border-2 border-red-500 border-dashed flex items-center justify-center">
          <div v-if="ability(fascist + i) !== null" class="w-12">
            <img :src="ability(fascist + i).image" :alt="ability(fascist + i).text" :title="ability(fascist + i).text">
          </div>
        </div>
        <div class="m-3 rounded w-24 h-32 border-2 border-red-500 bg-red-800 flex items-center justify-center">
          <img src="../../assets/fascists.png" class="w-20">
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import {defineComponent} from "vue";
import peekPolicies from "../../assets/abilities/peek-policies.png";
import executePlayer from "../../assets/abilities/execute-player.png";
import investigateLoyalty from "../../assets/abilities/investigate-loyalty.png";
import callSpecialElection from "../../assets/abilities/call-special-election.png";

const multiplies = [-6, -3, -2, 2, 3, 6];

export default defineComponent({
  name: "EnactedPolicies",
  data: () => ({
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