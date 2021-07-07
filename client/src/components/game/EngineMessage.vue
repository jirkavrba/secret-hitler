<template>
  <div :class="`mx-3 p-3 font-black border-2 rounded mt-3 ${colors[message.party || 'default']}`">
    {{ message.content }}
  </div>
</template>

<script>
import {defineComponent} from "vue";

export default defineComponent({
  name: "EngineMessage",
  props: ["message"],
  data: () => ({
    colors: {
      fascist: 'text-red-500 border-red-200',
      liberal: 'text-blue-500 border-blue-200',
      default: 'text-gray-700 border-gray-200'
    }
  })
})
</script>

<style scoped>

</style>