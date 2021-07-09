<template>
  <div :class="`${Object.keys($store.state.game.gameState.players).length === 10 ? 'mt-2' : 'mt-3'} h-20 px-5 rounded-xl flex flex-row items-center transition relative
    ${alive ? colors[role].background : 'bg-gray-700'}
    ${(selectable && !enabled) ? ' opacity-50' : ' '}
    ${(selectable && enabled) ? ' cursor-pointer transform hover:translate-x-3 hover:shadow-xl shadow-red-500 hover:opacity-90 ': ''}
    ${isPresident() ? ' ring-4 ring-indigo-500' : ''}
    ${isChancellor() ? ' ring-4 ring-purple-500' : ''}
   `">
    <img :src="roles[role]" :alt="role" :class="`w-12 mr-3 ${alive ? '' : 'filter grayscale opacity-30'}`">
    <div :class="`flex-grow flex flex-col ${(alive ? ' ' : 'opacity-30')}`">
      <span :class="`uppercase text-tiny font-bold tracking-wide ${colors[role].foreground}`" v-if="role !== 'hidden'">{{ role }}</span>
      <span :class="`w-full font-black whitespace-nowrap text-white mb-1 ${alive ? '' : ' line-through'}`">{{ username.substr(0, 20) }}</span>

      <div :class="`absolute ${showVotes() ? 'right-20' : 'right-2'} top-0`">
        <div v-if="isPresident()" class="text-white text-ultra-tiny font-black bg-indigo-500 px-2 py-1 rounded-b-lg text-center">President</div>
        <div v-if="isChancellor()" class="text-white text-ultra-tiny font-black bg-purple-500 px-2 py-1 rounded-b-lg text-center">Chancellor</div>
      </div>

      <div :class="`absolute ${showVotes() ? 'right-40' : 'right-20'} top-0`">
        <div v-if="isLastElectedPresident()" class="opacity-75 text-white text-ultra-tiny font-black bg-gray-500 px-2 py-1 rounded-b-lg text-center">Last president</div>
        <div v-if="isLastElectedChancellor()" class="opacity-75 text-white text-ultra-tiny font-black bg-gray-500 px-2 py-1 rounded-b-lg text-center">Last chancellor</div>
      </div>
    </div>
    <div v-if="showVotes() && alive">
      <div v-if="vote() === 'none'" class="opacity-25">
        <img :src="votes.none" alt="Player has not voted yet" title="Player has not voted yet"
             class="w-12 rounded filter grayscale animate-pulse">
      </div>
      <div v-else>
        <img :src="votes[vote()]" :alt="vote()" class="w-12 rounded filter shadow-lg">
      </div>
    </div>
  </div>
</template>

<script>
import {defineComponent} from "vue";

import liberal from "../../assets/roles/liberal.png";
import fascist from "../../assets/roles/fascist.png";
import hitler from "../../assets/roles/hitler.png";
import hidden from "../../assets/roles/hidden.png";

import ballot from "../../assets/votes/ballot.png";
import ja from "../../assets/votes/ja.png";
import nein from "../../assets/votes/nein.png";


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
      return this.$store.state.game.gameState.government.president === this.id;
    },
    isChancellor() {
      return this.$store.state.game.gameState.government.chancellor === this.id;
    },
    isLastElectedPresident() {
      return this.$store.state.game.gameState.lastElectedGovernment !== null &&
          this.$store.state.game.gameState.lastElectedGovernment.president === this.id;
    },
    isLastElectedChancellor() {
      return this.$store.state.game.gameState.lastElectedGovernment != null &&
          this.$store.state.game.gameState.lastElectedGovernment.chancellor === this.id;
    },
    showVotes() {
      return this.$store.state.game.gameState.phase === "VOTING_FOR_THE_GOVERNMENT";
    },
    vote() {
      return this.$store.state.game.gameState.election.votes[this.id].toLowerCase();
    }
  },
  data: () => ({
    colors: {
      "liberal": {
        background: "bg-gradient-to-r from-blue-400 to-gray-400",
        foreground: "text-blue-100",
      },
      "fascist": {
        background: "bg-gradient-to-r from-red-400 to-gray-400",
        foreground: "text-red-100"
      },
      "hitler": {
        background: "bg-gradient-to-r from-red-500 to-gray-400",
        foreground: "text-red-900",
      },
      "hidden": {
        background: "bg-gray-400",
        foreground: "text-gray-300"
      }
    },
    roles: {
      liberal,
      fascist,
      hitler,
      hidden
    },
    votes: {
      "none": ballot,
      "hidden": ballot,
      "ja": ja,
      "nein": nein
    }
  })
})
</script>