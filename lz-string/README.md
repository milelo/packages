# cljsjs/lz-string

Fast LZ-based compression algorithm for JavaScript

[](dependency)
```clojure
[cljsjs/lz-string "1.4.4-0"] ;; latest release
```
[](/dependency)

Add above dependency to your project build dependencies then require the packaged library:

```clojure
(ns application.core
  (:require cljsjs.lz-string))
```

## Examples

#### compress and decompress from your repl:

```clojure
(let [source "The quick brown fox jumps over the lazy dog"
      compressed (LZString.compress source)
      decompressed (LZString.decompress compressed)
      ]
  (print source (count source))
  (print compressed (count compressed))
  (print decompressed)
  )
```

Repository: https://github.com/pieroxy/lz-string
Home page documentation and a live demo: http://pieroxy.net/blog/pages/lz-string/index.html
