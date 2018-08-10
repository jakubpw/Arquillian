package domain;

import javax.ejb.Stateless;

@Stateless
public class OuterService {
    public String GetDataFrom3RdService(){
        return "test123";
    }
}
