const trimNewlines = require('trim-newlines');
const NL = /\r\n|\r|\n/

class TextUtils {

     static appendSuffix(text, skipLast, prefix, suffix, contentFunction, lastElementCallback) {
         const lines = text.toString().split("\n")

         for (let i = 0; i < lines.length - (skipLast ? 1 : 0); i++) {
             lines[i] = prefix + contentFunction(lines[i]) + suffix
         }

         if (skipLast && lastElementCallback) {
             lastElementCallback(lines[lines.length - 1])
         }

         return lines.join("\n")
     }

     static trimNL(text) {
         return trimNewlines(text)
     }

 }

module.exports = TextUtils