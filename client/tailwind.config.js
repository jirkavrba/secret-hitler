const colors = require("tailwindcss/colors")

module.exports = {
  purge: [],
  darkMode: false, // or 'media' or 'class'
  theme: {
    extend: {
      colors: {
        gray: colors.trueGray,
      },
      fontSize: {
        "tiny": ".75rem",
        "ultra-tiny": ".6rem",
      },
      ringWidth: {
        "highlight": "16px"
      },
      ringOffsetWidth: {
        "highlight": "16px"
      }
    },
  },
  variants: {
    extend: {
      scale: ["group-hover"],
      rotate: ["group-hover"]
    },
  },
  plugins: [],
}
