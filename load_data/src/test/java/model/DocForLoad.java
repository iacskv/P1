package model;

/**
 * Created by k.smotrov on 10.05.2017.
 */
public class DocForLoad {
    public final String type_doc;
    public final String type_ags;
    public final String year;
    public final String type_zags;
    public final String f_num;
    public final String l_num;

    public DocForLoad(String type_doc, String type_ags, String year, String type_zags, String f_num, String l_num) {

        this.type_doc = type_doc;
        this.type_ags = type_ags;
        this.year = year;
        this.type_zags = type_zags;
        this.f_num = f_num;
        this.l_num = l_num;
    }
}
