<template>
  <div>
    <div class="bg-gray-100 ml-5 h-full p-5 flex flex-col items-stretch justify-between">
      <h1 class="text-xs text-center font-bold uppercase tracking-wide text-gray-500">Chat</h1>

      <div class="my-5 bg-white flex-grow rounded-xl shadow-lg overflow-y-scroll overflow-x-hidden">
        <div v-for="(message, i) in $store.state.game.chat.messages.reverse()" :key="i">
          <PlayerMessage v-if="message.type === 'player'" :message="message"/>
          <EngineMessage v-else :message="message"/>
        </div>
      </div>

      <div class="flex flex-row" v-if="$store.state.game.chat.enabled">
        <input type="text" class="flex-grow rounded-lg p-3 focus:ring-4 focus:outline-none shadow-lg">
        <button
            class="transition bg-purple-500 hover:bg-purple-700 focus:outline-none hover:ring-4 focus:ring-4 ring-purple-300 focus:bg-purple-700 text-white text-sm p-3 uppercase shadow hover:shadow-lg ml-3 rounded-lg font-black">
          Send
        </button>
      </div>
      <div v-else class="text-center text-gray-400">
        Chat is disabled during legislative session
      </div>
    </div>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import PlayerMessage from "./PlayerMessage.vue";
import EngineMessage from "./EngineMessage.vue";

export default defineComponent({
  name: "Chat",
  components: {EngineMessage, PlayerMessage}
})
</script>

<style scoped>

</style>