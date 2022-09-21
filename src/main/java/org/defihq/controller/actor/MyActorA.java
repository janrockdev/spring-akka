package org.defihq.controller.actor;

import akka.actor.AbstractActor;
import akka.actor.Actor;
import akka.actor.Props;

public class MyActor extends AbstractActor {
    private String text;

    public Receive createReceive() {
        return receiveBuilder().matchEquals("printit", p -> {
            System.out.println("The address of this actor is: " + getSelf());
        }).build();
    }
}