package com.company;

import javax.swing.*;
import java.util.Arrays;

class List {  //implements Comparable{
/*
    String str;
    int number;

    List(String str, int number) {
        this.str = str;
        this.number = number;
    }

    @Override
    public int compareTo(Object obj) {
        List entry = (List) obj;

        int result = str.compareTo(entry.str);
        if(result != 0) {
            return result;
        }

        result = number - entry.number;
        if(result != 0) {
            return (int) result / Math.abs( result );
        }
        return 0;
    }
*/

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
                } else {
                    checkel = search(id - 1, null);
                    a.next = checkel.next;
                    checkel.next = a;
                    a.id = id;
                    tail.id++;
                    RepairID(a);
                    Sort();

                }
            }
        }

    }

    void RepairID(ListElement li){
        int i;

        for(i = li.id; i < GetTailId() + 1; i++) {
            li.id = i;
            li = li.next;
        }
    }
   private ListElement search(int id, String data){
        if (head == null){
            return null;
        } else {
            ListElement el = head;
            if ( id == -1 ){
                while(el != null){
                    if (el.data.equals(data)){
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

  /*  private ListElement search(int id, String data){
            if (head == null) {
                return null;
            } else {
                if(isSort && id == -1){
                    //написать для быстрого поиска по ключу
                }
                if(!isSort) {      //поиск по ключу для несортированного
                    ListElement el = head;
                    if (id == -1) {
                        while (el != null) {
                            if (el.data.equals(data)) {
                                return el;
                            }
                            el = el.next;
                        }
                        return null;
                    }
                }
                double division = (GetTailId() + 1) / (id + 1);
                if (!isSort || division > 2) {    //поиск по ID для несортированного или для ID, оказавшегося в первой половине отсортированного
                    ListElement el = head;
                    while (el != null) {
                        if (el.id == id) {
                            return el;
                        }
                        el = el.next;
                    }
                }
                else {          //ну и поиск по ID для второй половины отсортированного
                    ListElement el = head;
                    for(int i = GetTailId() / 2; i > 0; i--){
                       el = el.next;
                    }
                    while (el != null) {
                        if (el.id == id) {
                            return el;
                        }
                        el = el.next;
                    }
                }
            }
            return null;
    }*/

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
            System.out.println("");
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
                if(li.data.compareTo(ji.data) > 0){
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