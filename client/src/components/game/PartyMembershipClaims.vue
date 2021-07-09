<template>
  <div class="p-3 flex" v-if="$store.state.game.playerState.availablePartyMembershipClaims.length > 0">
    <div class="p-5 pt-3 bg-gray-100 rounded-3xl shadow-lg relative">
      <h1 class="text-sm font-bold uppercase tracking-wide text-gray-900 text-center">Claim investigated party
        membership</h1>

      <div class="flex justify-center mt-3">
        <div v-for="claim in $store.state.game.playerState.availablePartyMembershipClaims" class="flex flex-col items-center mx-2
          transition transform filter scale-90 hover:scale-100 cursor-pointer hover:opacity-100 hover:shadow-lg p-3 rounded-3xl hover:bg-white"
             @click="sendClaim(claim)">
          <img :src="images[claim]" alt="" class="border-4 rounded-full">
          <div :class="`uppercase font-black text-sm mt-1 ${colors[claim]}`">{{ claim }}</div>
        </div>
      </div>
      <div class="z-10">
        <div class="mt-3 text-center uppercase text-sm font-black cursor-pointer transition text-gray-400 hover:text-black"
             @click="sendClaim(null)">
          Skip claim
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Highlight from "./Highlight.vue";

import fascist from "../../assets/roles/fascist.png";
import liberal from "../../assets/roles/liberal.png";

export default {
  name: "PartyMembershipClaims",
  components: {Highlight},
  data: () => ({
    colors: {
      "liberal": "text-blue-500",
      "fascist": "text-red-500",
    },
    images: {
      fascist,
      liberal
    }
  }),
  methods: {
    sendClaim(which) {
      alert(which);
    }
  }
}
</script>

<style scoped>

</style>