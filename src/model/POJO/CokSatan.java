/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJO;

/**
 *
 * @author siyah-pc
 */
public class CokSatan {
    
    private  Object urun;
    private  Object sayi;
    private  Object fiyat;

    public CokSatan() {
    }

    public CokSatan(Object urun, Object sayi, Object fiyat) {
        this.urun = urun;
        this.sayi = sayi;
        this.fiyat = fiyat;
    }

    public Object getUrun() {
        return urun;
    }

    public void setUrun(Object urun) {
        this.urun = urun;
    }

    public Object getSayi() {
        return sayi;
    }

    public void setSayi(Object sayi) {
        this.sayi = sayi;
    }

    public Object getFiyat() {
        return fiyat;
    }

    public void setFiyat(Object fiyat) {
        this.fiyat = fiyat;
    }
    
    


    
}    
