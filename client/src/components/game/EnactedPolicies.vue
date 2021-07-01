<template>
  <div class="p-3">
    <div class="rounded p-5">
      <div class="bg-blue-100 p-5 rounded flex">
        <div v-for="i in liberal" :key="i" class="bg-blue-200 m-3 rounded w-24 h-32">
          <img src="../../assets/policies/liberal.png" alt="Fascist policy"
               :class="`transform filter -translate-y-2 scale-75 drop-shadow-lg ${rotation(i)}`">
        </div>
        <div v-for="i in (5 - liberal)" :key="i"
             class="bg-blue-50 m-3 rounded w-24 h-32 border-2 border-blue-200 border-dashed"></div>
      </div>

      <div class="bg-red-100 p-5 rounded flex mt-5">
        <div v-for="i in fascist" :key="i" class="bg-red-200 m-3 rounded w-24 h-32">
          <img src="../../assets/policies/fascist.png" alt="Fascist policy"
               :class="`transform filter -translate-y-2 scale-75 drop-shadow-lg ${rotation(5 + i)}`">
        </div>
        <div v-for="i in (6 - fascist)" :key="i"
             class="bg-red-50 m-3 rounded w-24 h-32 border-2 border-red-200 border-dashed"></div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import {defineComponent} from "vue";

const multiplies = [-6, -3, -2, 2, 3, 6];

export default defineComponent({
  name: "EnactedPolicies",
  data: () => ({
    rotations: (new Array(11).fill(0).map(() => multiplies[Math.floor(Math.random() * multiplies.length)]))
  }),
  methods: {
    rotation(i) {
      const rotation = this.rotations[i].toString();

      if (rotation < 0) {
        return `-rotate-${-rotation}`;
      }

      return `rotate-${rotation}`;
    }
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