<template>
  <div class="p-3">
    <div class="rounded p-5">
      <div class="bg-blue-100 p-5 rounded flex">
        <div v-for="i in liberal" :key="i" class="bg-blue-500 m-3 rounded w-24 h-32"></div>
        <div v-for="i in (5 - liberal)" :key="i" class="bg-blue-50 m-3 rounded w-24 h-32"></div>
      </div>

      <div class="bg-red-100 p-5 rounded flex mt-5">
        <div v-for="i in fascist" :key="i" class="bg-red-500 m-3 rounded w-24 h-32"></div>
        <div v-for="i in (6 - fascist)" :key="i"
             class="bg-red-50 m-3 rounded w-24 h-32"></div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import {defineComponent} from "vue";

export default defineComponent({
  name: "EnactedPolicies",
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