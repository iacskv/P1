package model;

/**
 * Created by k.smotrov on 10.05.2017.
 */
public class DocForLoad {
    public String typeDoc;
    public String typeAgs;
    public String year;
    public String typeZags;
    public String fNum;
    public String lNum;



    public String getTypeDoc() {

        return typeDoc;
    }

    public String getTypeAgs() {
        return typeAgs;
    }

    public String getYear() {
        return year;
    }

    public String getTypeZags() {
        return typeZags;
    }

    public String getfNum() {
        return fNum;
    }

    public String getlNum() {
        return lNum;
    }

    public void setfNum(String fNum) {
        this.fNum = fNum;
    }

    public void setlNum(String lNum) {
        this.lNum = lNum;
    }

    public void setTypeDoc(String typeDoc) {
        this.typeDoc = typeDoc;
    }

    public void setTypeAgs(String typeAgs) {
        this.typeAgs = typeAgs;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setTypeZags(String typeZags) {
        this.typeZags = typeZags;
    }

    public DocForLoad(String typeZags, String typeAgs, String year, String typeDoc, String fNum, String lNum) {

        this.typeDoc = typeDoc;
        this.typeAgs = typeAgs;
        this.year = year;
        this.typeZags = typeZags;
        this.fNum = fNum;
        this.lNum = lNum;
    }

    @Override
    public String toString() {
        return "DocForLoad{" +
                "typeDoc='" + typeDoc + '\'' +
                ", typeAgs='" + typeAgs + '\'' +
                ", year='" + year + '\'' +
                ", typeZags='" + typeZags + '\'' +
                ", fNum='" + fNum + '\'' +
                ", lNum='" + lNum + '\'' +
                '}';
    }

}
