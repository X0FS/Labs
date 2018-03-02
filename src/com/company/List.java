package com.company;

import javax.swing.*;

class List {

    class ListElement {
        ListElement next;
        int data;
        int id;
        //protected void finalize() throws Throwable{
        //    System.out.print("Я умер");
        //}
    }

    private ListElement head;
    private ListElement tail;

    void addWithID(int id, int data){
        ListElement a = new ListElement();
        a.data = data;
        if (tail == null){
            a.id = 0;
            head = a;
            tail = a;
            return;
        } else if (id == -1) {
            a.id = tail.id + 1;
            tail.next = a;
            tail = a;
        } else if (id > -1){
            ListElement checkel = search(id, -1);
            if (checkel != null){
                checkel.data = data;
            }
        }
    }
    void addWithID(int id, ListElement obj){
        ListElement a;
        a = obj;
        //a.id = id;
        if (id == 0){
            head = a;
        }
        a.next = search(id+1, -1);
    }

    private ListElement search(int id, int data){
        if (head == null){
            return null;
        } else {
            ListElement el = head;
            if ( id == -1 ){
                while(el != null){
                    if (el.data == data){
                        return el;
                    }
                    el = el.next;
                }
                return null;
            } else {
                while ( el != null ){
                    if (el.id == id){
                        return el;
                    }
                    el = el.next;
                }
            }
        }
        return null;
    }

    void printList(int id, int data){
        ListElement l;
        if (id == -2){
            ListElement le = head;
            while (le != null) {
                System.out.print(le.data + "(" + le.id + ")" + " ");
                le = le.next;
            }
            System.out.print("\n");
            return;
        }
        if (  id != -1 ){
            l = search(id, -1);
            JOptionPane.showMessageDialog(null, "id = " + l.id + ", data = " + l.data);
        } else {
            l = search(-1, data);
            if (l == null){
                JOptionPane.showMessageDialog(null, "В списке нет такого значения");
            }else{
                JOptionPane.showMessageDialog(null, "id = " + l.id + ", data = " + l.data);
            }
        }
    }

    void DeleteElem(int id){
        ListElement li;
        if (head == null){
            return;
        }
        if (head == tail){
            head = null;
            tail = null;
            return;
        }
        if( id == -1 ){
            head = null;
            tail = null;
            return;
        }else {
            if (id != 0) {
                li = search(id - 1, -1);
                if (id == tail.id) {
                    tail = search(GetTailId() - 1, -1);
                }
                li.next = li.next.next;
                li = search(id + 1, -1);
                while (li != null) {
                    li.id = li.id - 1;
                    li = li.next;
                }
            } else {
                head = head.next;
                li = search(id + 1, -1);
                while (li != null) {
                    li.id = li.id - 1;
                    li = li.next;
                }
            }
        }
        System.out.print(tail.data);
    }

    void Sort() {

        ListElement li, ji;
        //boolean z = true;

        for (int i = 100; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                li = search(j, -1);
                ji = search(j+1, -1);
                //if (li.data > ji.data) {
                    addWithID(j+1, li);
                    addWithID(j, ji);
                //}
            }
        }
    }


    int GetTailId( ){
        return tail.id;
    }

}