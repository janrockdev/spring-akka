package org.defihq.controller.actor;

import akka.actor.AbstractActor;

public class MyActorA extends AbstractActor {
    private String text;

    public Receive createReceive() {
        return receiveBuilder().matchEquals("printit", p -> {
            System.out.println("The address of this actor is: " + getSelf());
        }).build();
    }
}