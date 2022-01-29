package me.wyvernx.javaUtils.classes;

public class Module {

    public Module() {
        onEnable();



        //
        Runtime.getRuntime().addShutdownHook(new Thread(this :: onDisable));
        //

        //event handlers




        //
        onInitialize();
        //


        //
        while(true) {
            onUpdate();
        }
        //
    }

    public void onEnable() { }
    public void onDisable() { }
    public void onUpdate() { }
    public void onInitialize() { }
}
