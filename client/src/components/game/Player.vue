<template>
  <div :class="'mt-3 px-5 py-3 rounded-lg flex flex-row items-center ' + colors[role].background + (alive ? '' : ' filter grayscale opacity-50')">
    <img :src="roles[role]" :alt="role" class="w-12 mr-3">
    <div class="flex-grow flex flex-col">
      <span :class="'w-full font-black whitespace-nowrap ' + (alive ? '' : ' line-through')">{{ username.substr(0, 20) }}</span>
      <span :class="'uppercase text-xs tracking-wide ' + colors[role].foreground">{{ role }}</span>
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
    "role"
  ],
  data: () => ({
    colors: {
      "liberal": {
        background: "bg-blue-100",
        foreground: "text-blue-700",
      },
      "fascist": {
        background: "bg-red-100",
        foreground: "text-red-700"
      },
      "hitler": {
        background: "bg-red-200",
        foreground: "text-red-900",
      },
      "hidden": {
        background: "bg-gray-200",
        foreground: "text-gray-700"
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