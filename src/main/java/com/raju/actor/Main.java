package com.raju.actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Main {

    private static String TEXT = "Lorem Ipsum is simply dummy text\n" +
            "of the printing and typesetting industry.\n" +
            "Lorem Ipsum has been the industry's standard dummy text\n" +
            "ever since the 1500s, when an unknown printer took a galley\n" +
            "of type and scrambled it to make a type specimen book.\n" +
            " It has survived not only five centuries, but also the leap\n" +
            "into electronic typesetting, remaining essentially unchanged.\n" +
            " It was popularised in the 1960s with the release of Letraset\n" +
            " sheets containing Lorem Ipsum passages, and more recently with\n" +
            " desktop publishing software like Aldus PageMaker including\n" +
            "versions of Lorem Ipsum.";
    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("RootActorSystem");
//        ActorRef sakibActorRef = actorSystem.actorOf(Props.create(SakibActor.class, "sakibActor"));
//        sakibActorRef.tell("sakib",ActorRef.noSender());
//
//        ActorRef printerActorRef = actorSystem.actorOf(PrinterActor.props("printer-actor"));
//        printerActorRef.tell(new PrinterActor.PrintFinalResult(10),sakibActorRef);
//


        ActorRef readingActorRef = actorSystem.actorOf(ReadingActor.props(TEXT), "readingActor");
        readingActorRef.tell(new ReadingActor.ReadLines(), ActorRef.noSender());
        //ActorRef.noSender() means the sender ref is akka://test-system/deadLetters


    }
}
