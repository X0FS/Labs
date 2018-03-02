package com.company;

import javax.swing.*;
import java.util.Arrays;

class List {

    class ListElement {
        ListElement next;
        int data;
        int id;
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
            int[] out = new int[GetTailId()+1];
            int i = 0;
            while (le != null) {
                out[i] = le.data;
                le = le.next;
                i += 1;
            }
            JOptionPane.showMessageDialog(null, Arrays.toString(out));
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

    boolean IdIsValid(String rawId){
        if (rawId.trim().length() > 0){
            int id = Integer.parseInt(rawId.trim());
            if ((id > -1) && (id <= GetTailId())){
                return true;
            }
        }
        return false;
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
    }

    void Sort() {

        ListElement li, ji;

        for (int i = GetTailId(); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                li = search(j, -1);
                ji = search(j+1, -1);
                if (li.data > ji.data) {
                    int k = li.data;
                    li.data = ji.data;
                    ji.data = k;
                }
            }
        }
    }


    int GetTailId( ){
        return tail.id;
    }

}