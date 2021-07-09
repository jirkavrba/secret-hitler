<template>
  <div :class="`mx-3 p-3 border-l-4 mt-3 ${colors[message.party || 'default']}`">
    <p v-html="parseMessage(message.content)" class="text-gray-800 text-tiny"></p>
  </div>
</template>

<script>
import {defineComponent} from "vue";

export default defineComponent({
  name: "EngineMessage",
  props: ["message"],
  data: () => ({
    colors: {
      fascist: 'text-red-500 border-red-500',
      liberal: 'text-blue-500 border-blue-500',
      default: 'text-gray-700 border-gray-500'
    }
  }),
  methods: {
    parseMessage(message) {
      for (let player of Object.values(this.$store.state.game.gameState.players)) {
        message = message.replaceAll(`@player[${player.id}]`, `<b class="bg-gray-800 text-white px-2 py-0.5 rounded-full text-tiny">${player.username}</b>`);
      }

      const claims = {
        fascist: "bg-red-500",
        liberal: "bg-blue-500"
      }

      for (let claim in claims) {
        const common = "inline-block rounded-full text-white text-tiny py-0.5 px-2 my-1"
        const css = claims[claim];
        message = message.replaceAll(`@claim[${claim}]`, `<b class="${common} ${css}">${claim}</b>`)
      }

      return message;
    }
  }
})
</script>

<style scoped>

</style>