<template>
  <div>
    {{ id }}
  </div>
</template>

<script lang="ts">
import {defineComponent} from "vue";

export default defineComponent({
  name: "Player",
  props: [
    "id"
  ]
})
</script>

<style scoped>

</style>