<template>
  <div class="absolute left-0 top-0 ring-offset-black w-full h-full rounded highlight">
  </div>
</template>

<style scoped>
.highlight {
  outline: 12px solid white;
  animation: 1s highlight infinite alternate ease-in-out;
}

@keyframes highlight{
  from {
    outline-color: rgba(255, 255, 255, 1);
  }
  to {
    outline-color: rgba(255, 255, 255, 0.15);
  }
}

</style>

<script>
import {defineComponent} from "vue";

export default defineComponent({
  name: "Highlight"
})
</script>