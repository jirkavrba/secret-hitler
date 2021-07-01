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
        "tiny": ".75rem"
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
    extend: {},
  },
  plugins: [],
}
