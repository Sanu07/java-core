package com.design.behavioral.observer;

public class Main {

    public static void main(String[] args) {
        EventListenerManager listenerManager = new EventListenerManager("SUCCESS", "FAILED");
        EmailNotification emailNotification = new EmailNotification();
        SMSNotification smsNotification = new SMSNotification();
        listenerManager.subscribe("SUCCESS", emailNotification);
        listenerManager.subscribe("FAILED", emailNotification);
        listenerManager.subscribe("SUCCESS", smsNotification);

        EventGeneratorService service = new EventGeneratorService(listenerManager);
        service.success();
        service.failure();
        /**
         * SMS :: EventType :: SUCCESS Data :: successfully processed
         * EMAIL :: EventType :: SUCCESS Data :: successfully processed
         * EMAIL :: EventType :: FAILED Data :: processing failed
         */

        System.out.println("******************************************");
        listenerManager.unsubscribe("FAILED", emailNotification);
        listenerManager.subscribe("FAILED", smsNotification);
        service.setManager(listenerManager);
        service.success();
        service.failure();
        /**
         * SMS :: EventType :: SUCCESS Data :: successfully processed
         * EMAIL :: EventType :: SUCCESS Data :: successfully processed
         * SMS :: EventType :: FAILED Data :: processing failed
         */
    }
}
