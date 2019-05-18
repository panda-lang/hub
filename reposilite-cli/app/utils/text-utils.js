const NL = /\r\n|\r|\n/

class TextUtils {

     static appendSuffix(text, prefix, suffix, contentFunction) {
         const lines = text.toString().split(NL)

         for (let i = 0; i < lines.length; i++) {
             lines[i] = prefix + contentFunction(lines[i]) + suffix
         }

         return lines.join("\n")
     }

 }

module.exports = TextUtils