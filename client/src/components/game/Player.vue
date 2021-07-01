<template>
  <div :class="'h-24 mt-3 px-5 py-3 rounded-lg flex flex-row items-center transition ' +
    colors[role].background +
    (alive ? '' : ' filter grayscale opacity-50') +
    ((selectable && !enabled) ? ' opacity-25' : ' ') +
    ((selectable && enabled) ? ' cursor-pointer transform hover:translate-x-3 hover:shadow-xl shadow-red-500 hover:opacity-90 ': '') +
    (isPresident() ? ' ring-4 ring-yellow-500' : '') +
    (isChancellor() ? ' ring-4 ring-green-700' : '')
   ">
    <img :src="roles[role]" :alt="role" class="w-12 mr-3">
    <div class="flex-grow flex flex-col">
      <span :class="`uppercase text-tiny font-bold tracking-wide ${colors[role].foreground}`">{{ role }}</span>
      <span :class="`w-full font-black whitespace-nowrap text-white mb-1 ${alive ? '' : ' line-through'}`">{{ username.substr(0, 20) }}</span>

      <div class="flex">
        <div v-if="isPresident()" class="text-white text-xs font-black bg-yellow-500 px-2 py-1 rounded mr-2">President</div>
        <div v-if="isChancellor()" class="text-white text-xs font-black bg-green-700 px-2 py-1 rounded mr-2">Chancellor</div>
        <div v-if="isLastElectedPresident()" class="text-white text-xs font-black bg-gray-500 px-2 py-1 rounded mr-2 opacity-25">President</div>
        <div v-if="isLastElectedChancellor()" class="text-white text-xs font-black bg-gray-500 px-2 py-1 rounded mr-2 opacity-25">Chancellor</div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import {defineComponent} from "vue";

import liberal from "../../assets/roles/liberal.png"
import fascist from "../../assets/roles/fascist.png"
import hitler from "../../assets/roles/hitler.png"
import hidden from "../../assets/roles/hidden.png"


export default defineComponent({
  name: "Player",
  props: [
    "id",
    "alive",
    "username",
    "selectable",
    "enabled",
    "role"
  ],
  methods: {
    isPresident() {
      return this.$store.state.game.gameState.government.president == this.id;
    },
    isChancellor() {
      return this.$store.state.game.gameState.government.chancellor == this.id;
    },
    isLastElectedPresident() {
      return this.$store.state.game.gameState.lastElectedGovernment !== null &&
             this.$store.state.game.gameState.lastElectedGovernment.president == this.id;
    },
    isLastElectedChancellor() {
      return this.$store.state.game.gameState.lastElectedGovernment != null &&
             this.$store.state.game.gameState.lastElectedGovernment.chancellor == this.id;
    }
  },
  data: () => ({
    colors: {
      "liberal": {
        background: "bg-blue-900 filter saturate-50",
        foreground: "text-blue-500",
      },
      "fascist": {
        background: "bg-red-800 filter saturate-50",
        foreground: "text-red-400"
      },
      "hitler": {
        background: "bg-red-900 filter saturate-50",
        foreground: "text-red-200",
      },
      "hidden": {
        background: "bg-gray-800",
        foreground: "text-gray-600"
      }
    },
    roles: {
      liberal,
      fascist,
      hitler,
      hidden
    }
  })
})
</script>

<style scoped>

</style>