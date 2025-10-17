package model;

public class Student {

    private int id;
    private String name;
    private String pSurname;
    private String mSurname;
    private String email;
    private String ci;
    private int years;
    private String subject;

    public Student(int id, String name, String pSurname, String mSurname, String email, String ci, int years, String subject) {
        this.id = id;
        this.name = name;
        this.pSurname = pSurname;
        this.mSurname = mSurname;
        this.email = email;
        this.ci = ci;
        this.years = years;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpSurname() {
        return pSurname;
    }

    public void setpSurname(String pSurname) {
        this.pSurname = pSurname;
    }

    public String getmSurname() {
        return mSurname;
    }

    public void setmSurname(String mSurname) {
        this.mSurname = mSurname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return " | id=" + id +
                " | name=" + name +
                " | pSurname=" + pSurname +
                " | mSurname=" + mSurname +
                " | email=" + email +
                " | ci=" + ci +
                " | years=" + years +
                " | subject=" + subject + '|';
    }

    public String toCSV() {
        return id + "," +
                name + "," +
                pSurname + "," +
                mSurname + "," +
                email + "," +
                ci + "," +
                years + "," +
                subject;
    }
}
