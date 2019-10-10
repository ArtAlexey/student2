package entity;

import java.util.ArrayList;
import java.util.List;

public class Semestr {
    private int id;
    private String semestr;
    private String duration;
    private int status = 1;
    private List<Discipline> discipline = new ArrayList<>();


    public Semestr() {
    }

    public Semestr(int id, String semestr, String duration, int status, List<Discipline> discipline) {
        this.id = id;
        this.semestr = semestr;
        this.duration = duration;
        this.status = status;
        this.discipline = discipline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSemestr() {
        return semestr;
    }

    public void setSemestr(String semestr) {
        this.semestr = semestr;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Discipline> getDiscipline() {
        return discipline;
    }

    public void setDiscipline(List<Discipline> discipline) {
        this.discipline = discipline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Semestr semestr1 = (Semestr) o;

        if (id != semestr1.id) return false;
        if (status != semestr1.status) return false;
        if (semestr != null ? !semestr.equals(semestr1.semestr) : semestr1.semestr != null) return false;
        if (duration != null ? !duration.equals(semestr1.duration) : semestr1.duration != null) return false;
        return discipline != null ? discipline.equals(semestr1.discipline) : semestr1.discipline == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (semestr != null ? semestr.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (discipline != null ? discipline.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Semestr{" +
                "id=" + id +
                ", semestr='" + semestr + '\'' +
                ", duration='" + duration + '\'' +
                ", status=" + status +
                ", discipline=" + discipline +
                '}';
    }
}
