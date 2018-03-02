package com.company;

import javax.swing.*;
import java.util.Arrays;

class List {

    class ListElement {
        ListElement next;
        String data;
        int id;
    }
    private boolean isSort = false;
    private ListElement head;
    private ListElement tail;

    void addWithID(int id, String data){
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
            ListElement checkel = search(id, null);
            if (checkel != null) {
                if (!isSort) {
                    checkel.data = data;
                    isSort = false;
                } else {
                    checkel = search(id - 1, null);
                    a.next = checkel.next;
                    checkel.next = a;
                    RepairID(id - 1);
                    Sort();
                }
            }
        }

    }


    private ListElement search(int id, String data){
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

    void printList(int id, String data){
        ListElement l;
        if (id == -2){
            ListElement le = head;
            String[] out = new String[GetTailId() + 1];
            int i = 0;
            while (le != null) {
                out[i] = le.data + "(" + le.id + ")";
                le = le.next;
                i += 1;
            }
            JOptionPane.showMessageDialog(null, Arrays.toString(out));
            return;
        }
        if (  id != -1 ){
            l = search(id, null);
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

    void RepairID(int id){
        ListElement li = search(id, null);
        for(int i = id; i <= GetTailId() + 1; i++) {
            li.id = i;
            li = li.next;
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
                li = search(id - 1, null);
                if (id == tail.id) {
                    tail = search(GetTailId() - 1, null);
                }
                li.next = li.next.next;
                li = search(id + 1, null);
                while (li != null) {
                    li.id = li.id - 1;
                    li = li.next;
                }
            } else {
                head = head.next;
                li = search(id + 1, null);
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
                li = search(j, null);
                ji = search(j+1, null);
                if (li.data.length() > ji.data.length()) {
                    String k = li.data;
                    li.data = ji.data;
                    ji.data = k;
                }
            }
        }
        isSort = true;
    }


    int GetTailId( ){
        return tail.id;
    }

}