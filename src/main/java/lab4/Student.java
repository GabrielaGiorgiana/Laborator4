package lab4;

import java.io.*;
import java.util.*;

public class Student {
    protected int numarMatricol;
    protected String prenume;
    protected String nume;
    protected String formatieDeStudiu;
    protected double nota;

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
        this.nota = 0.0;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public double getNota() {
        return nota;
    }

    public int getNumarMatricol() {
        return numarMatricol;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }

    public boolean esteEgalCu(Student altStudent) {
        if (altStudent == null) return false;
        return this.prenume.equals(altStudent.prenume) &&
                this.nume.equals(altStudent.nume) &&
                this.formatieDeStudiu.equals(altStudent.formatieDeStudiu);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return numarMatricol == student.numarMatricol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numarMatricol);
    }


    @Override
    public String toString() {
        return numarMatricol + " \t " + prenume + " " + nume + " \t " + formatieDeStudiu + " \t Nota: " + nota;

    }
}