package dataAndBase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MyDataStore {

    @Id
    @GeneratedValue
    private Integer id;

    private String StringData;

    public MyDataStore() {
        this.StringData="";
    }

    public  MyDataStore(String stringData)
    {
        this.StringData=stringData;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStringData() {
        return StringData;
    }

    public void setStringData(String stringData) {
        StringData = stringData;
    }
}
