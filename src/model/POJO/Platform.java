package model.POJO;
// Generated 02.Oca.2015 16:58:18 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Platform generated by hbm2java
 */
public class Platform  implements java.io.Serializable {


     private Integer platformId;
     private String platformAdi;
     private Set uruns = new HashSet(0);

    public Platform() {
    }

	
    public Platform(String platformAdi) {
        this.platformAdi = platformAdi;
    }
    public Platform(String platformAdi, Set uruns) {
       this.platformAdi = platformAdi;
       this.uruns = uruns;
    }
   
    public Integer getPlatformId() {
        return this.platformId;
    }
    
    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }
    public String getPlatformAdi() {
        return this.platformAdi;
    }
    
    public void setPlatformAdi(String platformAdi) {
        this.platformAdi = platformAdi;
    }
    public Set getUruns() {
        return this.uruns;
    }
    
    public void setUruns(Set uruns) {
        this.uruns = uruns;
    }




}


