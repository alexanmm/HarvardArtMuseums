
package br.com.digitalhouse.harvardartmuseums.model.exhibition;

import com.google.gson.annotations.Expose;

public class PersonExhibition {

    @Expose
    private String displayname;

    @Expose
    private Long displayorder;

    @Expose
    private String name;

    @Expose
    private Long personid;

    @Expose
    private String prefix;

    @Expose
    private String role;

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
