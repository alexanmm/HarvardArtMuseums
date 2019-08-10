
package br.com.digitalhouse.harvardartmuseums.model.object;

import com.google.gson.annotations.Expose;

public class Worktype {

    @Expose
    private String worktype;

    @Expose
    private String worktypeid;

    public String getWorktype() {
        return worktype;
    }

    public void setWorktype(String worktype) {
        this.worktype = worktype;
    }

    public String getWorktypeid() {
        return worktypeid;
    }

    public void setWorktypeid(String worktypeid) {
        this.worktypeid = worktypeid;
    }

}
