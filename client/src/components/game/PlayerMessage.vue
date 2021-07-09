<template>
  <div :class="`m-3 bg-gray-100 px-3 py-2 rounded flex flex-col items-start`">
    <div :class="`mr-1 text-tiny font-black ${colors[role]}`">{{ player.username }}:</div>
    <p class="text-sm text-gray-700">{{ message.content }}</p>
  </div>
</template>

<script>
import {defineComponent} from "vue";

export default defineComponent({
  name: "PlayerMessage",
  props: ["message"],
  data: () => ({
    colors: {
      LIBERAL: "text-blue-500",
      FASCIST: "text-red-500",
      HITLER: "text-red-700",
      HIDDEN: "text-gray-500",
    }
  }),
  computed: {
    role: function () {
      return this.$store.state.game.playerState.rolesKnowledge[this.message.sender]
    },
    player: function () {
      return this.$store.state.game.gameState.players[this.message.sender]
    }
  }
})
</script>