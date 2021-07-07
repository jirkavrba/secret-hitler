<template>
  <div :class="`m-3 ${colors[role].background} px-3 py-2 rounded flex flex-col items-start`">
    <div :class="`mr-1 text-tiny font-black ${colors[role].foreground}`">{{ player.username }}:</div>
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
      LIBERAL: {
        foreground: "text-blue-500",
        background: "bg-blue-50"
      },
      FASCIST: {
        foreground: "text-red-500",
        background: "bg-red-50"
      },
      HITLER: {
        foreground: "text-red-700",
        background: "bg-red-100"
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