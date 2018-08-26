# jtcui

Just the core UI (**jtcui**): A pure-java UI framework that leaves rendering and input to the user, allowing it to be used in any environment

### What does it do?
Jtcui aims to implement the difficult core hiding in every UI: layouts, components, containers, event handling and more.
This allows the user to only have to provide rendering, tell jtcui when an input event happens (mouse and keyboard) and what components there are. *That's all.*

Because of its nature, jtcui can be implemented anywhere: be it LWJGL, java2d or something else, it all works.

## Documentation

No documentation written yet. See [my debugging implementation](https://github.com/zeroeightysix/jtcui/tree/master/desktop/src/me/zeroeightsix/jtcui/desktop) for an example. (using libGDX)

## Trying out jtcui

This repository contains two modules: the jtcui [core](https://github.com/zeroeightysix/jtcui/tree/master/core) (the library itself) and the testing module [desktop](https://github.com/zeroeightysix/jtcui/tree/master/desktop). To test out jtcui, simply clone it:

```
git clone https://github.com/zeroeightysix/jtcui/
````
Import it into your favourite IDE, create a run configuration for `me.zeroeightsix.jtcui.desktop.DesktopLauncher.main()` and set the working directory to `desktop/assets/`.

That's it - you can find all important user-faced code in `Launcher`.
