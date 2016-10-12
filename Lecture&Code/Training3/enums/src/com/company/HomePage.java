package com.company;

/**
 * Created by student on 11.10.2016.
 */
public class HomePage {

    public enum Tabs {
        EVENTS("Events"),
        HELP("Help"),
        STRUCTURE("Structure");
        
        String realText;

        Tabs(String realText) {
            this.realText = realText;
        }

        @Override
        public String toString() {
            return this.realText;
        }
    }

    //methods

    public void goToEvents() {
        //code of method
    }

    public void goToHelp() {

    }

    public void goToStructure() {

    }

//    public void goTo(String tabName) {
//
//    }

    public void goTo(Tabs tabName) {
        String tabText = tabName.toString();
//        if (tabName.equals(Tabs.EVENTS)) {
//            //click events tab
//        }
//        if (tabName.equals(Tabs.HELP)) {
//            //click help tab
//        }
//        if (tabName.equals(Tabs.STRUCTURE)) {
//            //click structure tab
//        }
    }
}
