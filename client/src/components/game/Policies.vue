<template>
  <div class="p-3 flex" v-if="$store.state.game.playerState.availablePolicies.length > 0">
    <div class="p-5 pt-3 bg-gray-100 rounded-3xl shadow-lg relative">
      <h1 class="text-sm font-bold uppercase tracking-wide text-gray-900 text-center">
        Select policy that will be <b class="text-red-700">discarded</b>
      </h1>

      <div class="flex justify-center">
        <div v-for="policy in $store.state.game.playerState.availablePolicies"
             @click="discard(policy)"
             class="m-3 w-24 transition transform filter shadow-lg cursor-pointer hover:scale-75 hover:rotate-12 hover:blur hover:saturate-50">
          <img :src="images[policy]" alt="">
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import {defineComponent} from "vue";

import liberal from "../../assets/policies/liberal.png";
import fascist from "../../assets/policies/fascist.png";

export default defineComponent({
  name: "Policies",
  methods: {
    discard(policy) {
      alert(policy)
    }
  },
  data: () => ({
    images: {
      liberal,
      fascist
    }
  })
})
</script>