<template>
  <div :class="`m-3 ${colors[role].background} p-3 rounded-lg`">
    <div :class="`font-black text-tiny ${colors[role].foreground}`">{{ player.username }}</div>
    <p>{{ message.content }}</p>
  </div>
</template>

<script>
import {defineComponent} from "vue";

export default defineComponent({
  name: "PlayerMessage",
  props: ["message"],
  data: () => ({
    colors: {
      LIBERAL: {
        foreground: "text-blue-500",
        background: "bg-gradient-to-r from-gray-100 to-blue-100"
      },
      FASCIST: {
        foreground: "text-red-500",
        background: "bg-gradient-to-r from-gray-100 to-red-100"
      },
      HITLER: {
        foreground: "text-red-700",
        background: "bg-gradient-to-r from-gray-100 to-red-200"
      },
      HIDDEN: {
        foreground: "text-gray-500",
        background: "bg-gray-100"
      }
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