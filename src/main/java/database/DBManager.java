package database;

import entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    public static List<Discipline> getAllActiveDisciplines() {
        ArrayList<Discipline> disciplines = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_2?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC", "root", "Laptev140781");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM discipline where status = '1'");
            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setDiscipline(rs.getString("discipline"));
                disciplines.add(discipline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplines;
    }

    public static void createDiscipline(String newDisc) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_2?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC", "root", "Laptev140781");
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `discipline` (`discipline`) VALUES ('" + newDisc + "');");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Student> getAllActiveStudent() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_2?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC", "root", "Laptev140781");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student where status = '1'");
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setSurname(rs.getString("surname"));
                student.setName(rs.getString("name"));
                student.setGroup(rs.getString("group"));
                student.setDate(rs.getDate("date"));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
    public static Discipline getDisciplineById(String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_2?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC", "root", "Laptev140781");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM discipline where status = '1' and id = " + id);
            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setDiscipline(rs.getString("discipline"));
                return discipline;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void deleteDiscipline(String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_2?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC", "root", "Laptev140781");
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE discipline SET status = '0' WHERE (id = " + id + ");");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void createNewStudent(String newSurname, String newName, String newGroup, Date newDateSql) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_2?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC", "root", "Laptev140781");
            //jdbc:mysql://localhost/students_2?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC
            //jdbc:mysql://localhost/students_2?useUnicode=true&serverTimezone=UTC
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO student (`surname`, `name`, `group`, `date`) VALUES ('" + newSurname + "', '" + newName + "', '" + newGroup + "', '" + newDateSql + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudents(String idS) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_2?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC", "root", "Laptev140781");
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE student SET status = '0' WHERE (id = " + idS + ");");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void modifyDiscipline(String iDisc, String newName) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_2?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC", "root", "Laptev140781");
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE discipline SET discipline = '" + newName + "' WHERE (id = " + iDisc + ")");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Student getStudentById(String idStudent) {
        Student studentMod = new Student();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_2?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC", "root", "Laptev140781");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student where status = '1' and id = " + idStudent);
            while (rs.next()) {
                studentMod.setId(rs.getInt("id"));
                studentMod.setSurname(rs.getString("surname"));
                studentMod.setName(rs.getString("name"));
                studentMod.setGroup(rs.getString("group"));
                studentMod.setDate(rs.getDate("date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentMod;
    }

    public static void modifyStudent(String mIdMod, String mSurnameMod, String mNameMod, String mGroupMod, Date sqlDate) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_2?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC", "root", "Laptev140781");
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `student` SET `surname` = '" + mSurnameMod + "', `name` = '" + mNameMod + "', `group` = '" + mGroupMod + "', `date` = '" + sqlDate + "' WHERE (`id` = '" + mIdMod + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Account getAccount(String login, String password, String role) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_2?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC", "root", "Laptev140781");
            Statement stmt = con.createStatement();
            ResultSet rs =  stmt.executeQuery("SELECT * FROM account where login = '" + login +"' and password = '" + password + "' and role = '" + role + "'");
            while (rs.next()){
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setLogin(rs.getString("login"));
                account.setPassword(rs.getString("password"));
                account.setRole(rs.getString("role"));
                return account;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Semestr> getAllActiveSemestrs() {
        ArrayList<Semestr> semestrs = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_2?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC", "root", "Laptev140781");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from semestr where status = 1");
            while (rs.next()) {
                Semestr semestr = new Semestr();
                semestr.setId(rs.getInt("id"));
                semestr.setSemestr(rs.getString("semestr"));
                semestr.setDuration(rs.getString("duration"));
                semestrs.add(semestr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return semestrs;
    }

    public static List<Discipline> getDisciplinesInSemestr(String idSem) {
        ArrayList<Discipline> disciplinesInSemestr = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_2?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC", "root", "Laptev140781");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM semestr_discipline as sd\n" +
                    "left join discipline as d on sd.id_discipline = d.id\n" +
                    "where sd.id_semestr = " + idSem + " and d.status = '1'");

            while (rs.next()) {
                Discipline discipline = new Discipline();
                int idDisc = rs.getInt("id_discipline");
                discipline.setId(idDisc);
                discipline.setDiscipline(rs.getString("discipline"));
                disciplinesInSemestr.add(discipline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplinesInSemestr;
    }


    public static List<Mark> getMarkByStudentSemestr(String idStud, int idTerm) {
        List<Mark> marks = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_2?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC", "root", "Laptev140781");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM marks LEFT JOIN semestr on marks.id_semestr = semestr.id\n" +
                    "LEFT JOIN discipline on marks.id_discipline = discipline.id\n" +
                    "LEFT JOIN student on marks.id_student = student.id\n" +
                    "WHERE marks.id_student = '" + idStud + "' AND marks.id_semestr = '" + idTerm + "'");
            while (rs.next()) {
                Mark mark = new Mark();
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id_discipline"));
                discipline.setDiscipline(rs.getString("discipline"));
                discipline.setStatus(1);
                mark.setDiscipline(discipline);
                mark.setMark(rs.getInt("mark"));
                marks.add(mark);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return marks;

    }

    public static void createNewTerm(String term, String newTermDuration, int[] idDiscTermInt) {
        int idTerm = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_2?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC", "root", "Laptev140781");
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `students_2`.`semestr` (`semestr`, `duration`, `status`) VALUES ('" + term + "', '" + newTermDuration +"', '1')");
            ResultSet rs = stmt.executeQuery("SELECT * FROM students_2.semestr where semestr = '" + term +"'");
            while (rs.next()) {
                idTerm = rs.getInt("id");
            }
            for (int idDisc : idDiscTermInt){
                stmt.execute("INSERT INTO `students_2`.`semestr_discipline` (`id_semestr`, `id_discipline`) VALUES (" + idTerm + ", " + idDisc + ")");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void modifyTerm(int idTermG, int[] idDiscTermModifyInt) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_2?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC", "root", "Laptev140781");
            Statement stmt = con.createStatement();
            stmt.execute("DELETE FROM students_2.semestr_discipline where id_semestr = " + idTermG +"");
            for (int idDisc : idDiscTermModifyInt){
                stmt.execute("INSERT INTO `students_2`.`semestr_discipline` (`id_semestr`, `id_discipline`) VALUES (" + idTermG + ", " + idDisc + ")");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteTerm(int idDelTerm) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_2?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC", "root", "Laptev140781");
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `students_2`.`semestr` SET `status` = '0' WHERE (`id` = " + idDelTerm +")");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Semestr getTermsById(int setIdTerm) {
        Semestr semestr = new Semestr();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_2?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC", "root", "Laptev140781");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students_2.semestr WHERE semestr.id = " + setIdTerm +"");
            while (rs.next()) {
                semestr.setId(rs.getInt("id"));
                semestr.setSemestr(rs.getString("semestr"));
                semestr.setDuration(rs.getString("duration"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return semestr;
    }

    public static void setMarks(int idStudent, int idTerm, int idDiscipline1, int mark1) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_2?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC", "root", "Laptev140781");
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `students_2`.`marks` (`id_semestr`, `id_discipline`, `id_student`, `mark`) VALUES ('" + idTerm +"', '" + idDiscipline1 + "', '" + idStudent +"', '" + mark1 +"')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteMarksStudent(int idStudent, int idTerm) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_2?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC", "root", "Laptev140781");
            Statement stmt = con.createStatement();
            stmt.execute("DELETE FROM students_2.marks where id_student = '" + idStudent +"' and id_semestr = '" + idTerm +"'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getAVGmarkStudent(String idStudent) {
        String avgStudentMark = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_2?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC", "root", "Laptev140781");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT AVG(mark) FROM marks LEFT JOIN semestr on marks.id_semestr = semestr.id\n" +
                    "LEFT JOIN discipline on marks.id_discipline = discipline.id\n" +
                    "LEFT JOIN student on marks.id_student = student.id WHERE marks.id_student = '" + idStudent + "'");
            while (rs.next()) {
                avgStudentMark = rs.getString("AVG(mark)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return avgStudentMark;
    }

    public static String getAVGmarkOfTerm(String idStudent, int setIdTerm) {
        String avgStudentTerm = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_2?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC", "root", "Laptev140781");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT AVG(mark) FROM marks LEFT JOIN semestr on marks.id_semestr = semestr.id\n" +
                    "LEFT JOIN discipline on marks.id_discipline = discipline.id\n" +
                    "LEFT JOIN student on marks.id_student = student.id WHERE marks.id_student = '" + idStudent + "' AND marks.id_semestr = '" + setIdTerm + "'");
            while (rs.next()) {
                avgStudentTerm = rs.getString("AVG(mark)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return avgStudentTerm;
    }
}
