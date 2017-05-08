package es.ulpgc.eite.clean.mvp.sample.data;

import io.realm.RealmObject;

/**
 * Created by Luis on 19/11/16.
 */

public class ModelDbItem extends RealmObject{

    private Integer id;
    private String name;
    private String month;
    private Integer day;
    private Integer year;

    public ModelDbItem() {
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ModelDbItem){
            ModelDbItem item = (ModelDbItem) obj;
            if(item.getId() == getId()){
                return true;
            }
        }
        return false;
    }
}
