package com.raju.actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Main {
    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("sakib-actor");
        ActorRef actorRef = actorSystem.actorOf(Props.create(SakibActor.class, "sakibActor"));
        actorRef.tell("sakib",ActorRef.noSender());
    }
}
