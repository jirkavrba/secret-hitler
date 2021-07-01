<template>
  <div :class="'mt-3 px-5 py-3 rounded-lg flex flex-row items-center ' + colors[role]">
    <img :src="roles[role]" :alt="role" class="w-12 mr-3">
    <div class="flex-grow bg-gray-300">{{ role }}</div>
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
    "role"
  ],
  data: () => ({
    colors: {
      "liberal": "bg-blue-100",
      "fascist": "bg-red-100",
      "hitler": "bg-red-200",
      "hidden": "bg-gray-200"
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