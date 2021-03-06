package com.raju.actor;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class SakibActor extends AbstractActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    private String text;

    public SakibActor(String text) {
        this.text = text;
    }

    @Override
    public void preStart() throws Exception {
        super.preStart();
        log.info("Sakib Actor started");
    }

    @Override
    public void postStop() throws Exception {
        super.postStop();
        log.info("Sakib Actor stopped");
    }

    public static Props props(String text) {
        return Props.create(SakibActor.class, text);
    }

    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("sakib", p -> {
                    System.out.println("The address of this actor is: " + getSelf());
                    getSender().tell("Got msg ", getSelf());
                })
                .build();
    }
}
