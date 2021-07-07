<template>
  <div class="p-3 flex">
    <div class="p-5 pt-3 bg-gray-100 rounded-3xl shadow-lg relative">
      <h1 class="text-sm font-bold uppercase tracking-wide text-gray-900 text-center">
        Claim policies
      </h1>

      <div class="flex justify-center mt-3">
        <div v-for="claim in $store.state.game.playerState.availablePolicies"
             :class="`hover:${color(claim)} flex flex-col items-center mx-2 transition transform filter scale-90 hover:scale-100 cursor-pointer p-3 m-3 rounded-full group`"
             @click="sendClaim(claim)">
          <div class="relative w-36 h-36 transition transform" v-if="claim[0].length === 3">
            <div class="ml-1 relative">
              <div v-for="(policy, i) in claim" :class="`absolute w-16 left-${i * 7 + 2} top-${i * 5 + 1} shadow transition transform group-hover:${rotateThree[i]}`">
                <img :src="images[policy]" alt="">
              </div>
            </div>
          </div>
          <div class="relative w-36 h-36 transition transform" v-else>
            <div class="ml-5 relative">
              <div v-for="(policy, i) in claim" :class="`absolute w-16 left-${i * 7 + 2} top-${i * 5 + 3} shadow transition transform group-hover:${rotateTwo[i]}`">
                <img :src="images[policy]" alt="">
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="z-10">
        <div
            class="mt-3 text-center uppercase text-sm font-black cursor-pointer transition text-gray-400 hover:text-black"
            @click="sendClaim(null)">
          Skip claim
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Highlight from "./Highlight.vue";

import fascist from "../../assets/policies/fascist.png";
import liberal from "../../assets/policies/liberal.png";

export default {
  name: "PoliciesClaims",
  components: {Highlight},
  data: () => ({
    images: {
      fascist,
      liberal
    },
    rotateTwo: ["-rotate-12", "rotate-12 scale-110"],
    rotateThree: ["-rotate-12", "scale-110", "rotate-12"]
  }),
  methods: {
    color(policies) {
      const liberal = policies.filter(it => it === "liberal").length;
      const fascist = policies.filter(it => it === "fascist").length;

      const diff = liberal - fascist;


      if (diff > 0) {
        return `bg-blue-${Math.min(diff, 2) * 100}`;
      }

      if (diff < 0) {
        return `bg-red-${Math.min(-diff, 2) * 100}`;
      }

      return 'bg-gray-200';
    },
    sendClaim(which) {
      alert(which);
    }
  }
}
</script>

<style scoped>

</style>