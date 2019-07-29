
package br.com.digitalhouse.harvardartmuseums.model.object;

import com.google.gson.annotations.Expose;

public class Person {

    @Expose
    private String alphasort;

    @Expose
    private String birthplace;

    @Expose
    private String culture;

    @Expose
    private String deathplace;

    @Expose
    private String displaydate;

    @Expose
    private String displayname;

    @Expose
    private Long displayorder;

    @Expose
    private String gender;

    @Expose
    private String name;

    @Expose
    private Long personid;

    @Expose
    private String prefix;

    @Expose
    private String role;

    public String getAlphasort() {
        return alphasort;
    }

    public void setAlphasort(String alphasort) {
        this.alphasort = alphasort;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getDeathplace() {
        return deathplace;
    }

    public void setDeathplace(String deathplace) {
        this.deathplace = deathplace;
    }

    public String getDisplaydate() {
        return displaydate;
    }

    public void setDisplaydate(String displaydate) {
        this.displaydate = displaydate;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public Long getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(Long displayorder) {
        this.displayorder = displayorder;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPersonid() {
        return personid;
    }

    public void setPersonid(Long personid) {
        this.personid = personid;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
