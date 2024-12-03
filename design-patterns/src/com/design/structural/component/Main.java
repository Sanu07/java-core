package com.design.structural.component;

public class Main {

    public static void main(String[] args) {

        Leaf ram = new Leaf(3000, "RAM");
        Leaf hdd = new Leaf(6000, "HDD");

        Leaf mouse = new Leaf(400, "MOUSE");
        Leaf keyboard = new Leaf(500, "KEYBOARD");

        Composite peripheral = new Composite("Peripheral");
        Composite motherBoard = new Composite("MotherBoard");
        Composite computer = new Composite("Computer");

        // Composite -> Leaf
        peripheral.add(mouse);
        peripheral.add(keyboard);

        // Composite -> Leaf
        motherBoard.add(ram);
        motherBoard.add(hdd);

        // Composite -> Composite -> Leaf
        computer.add(motherBoard);
        computer.add(peripheral);

        // show price of Leaf Node
        ram.showPrice();

        // show price of computer (top node)
        // this will traverse deep down and print the price of every node
        computer.showPrice();
    }
}
