package com.example.jcasselm.listtracker;

import android.arch.persistence.room.*;

@Entity
public class ListObject
{
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String name;

    @ColumnInfo(name = "item1")
    private String item1;

    @ColumnInfo(name = "item2")
    private String item2;

    @ColumnInfo(name = "item3")
    private String item3;

    @ColumnInfo(name = "item4")
    private String item4;

    @ColumnInfo(name = "item5")
    private String item5;

    public ListObject(int id, String name, String item1, String item2, String item3, String item4, String item5) {
        this.id = id;
        this.name = name;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
        this.item5 = item5;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public void setItem2(String item2) {
        this.item1 = item2;
    }

    public void setItem3(String item3) {
        this.item1 = item3;
    }

    public void setItem4(String item4) {
        this.item4 = item4;
    }

    public void setItem5(String item5) {
        this.item5 = item5;
    }


    public String getName(){
        return this.name;
    }

    public int getId() {
        return id;
    }

    public String getItem1() {
        return item1;
    }

    public String getItem2() {
        return item2;
    }

    public String getItem3() {
        return item3;
    }

    public String getItem4() {
        return item4;
    }

    public String getItem5() {
        return item5;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof ListObject))
            return false;

        ListObject listObj = (ListObject) obj;

        int objId = listObj.getId();
        String objName = listObj.getName();
        String objItem1 = listObj.getItem1();

        if (objId == getId()){
            return true;
        }

        if (objName == getName()){
            return true;
        }

        if (objItem1 == getItem1()){
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return (id + ", " + name + ", " + item1 + item2 + item3 + item4 + item5);
    }

}