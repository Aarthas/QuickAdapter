package com.arthas.fineevent;


import org.greenrobot.eventbus.EventBus;

public class FineEvent {

    public static void register(Object thisobj) {
        EventBus.getDefault().register(thisobj);
    }

    public static void post(Object event) {
        EventBus.getDefault().post(event);
    }

    public static void unregister(Object thisobj) {
        EventBus.getDefault().unregister(thisobj);
    }

}
