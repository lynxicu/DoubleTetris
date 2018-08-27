package lx.doubletetris;

class EventHandler {
    private Renderer re = new Renderer();
    private LogicController lc = new LogicController();
    private GameController gc = new GameController(re, lc);
    private KeyResponder kr = new KeyResponder(gc);

    Renderer renderer() {
        return re;
    }

    KeyResponder responder() {
        return kr;
    }
}
