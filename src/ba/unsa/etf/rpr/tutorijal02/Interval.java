package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetna_tacka, krajnja_tacka;
    boolean a, b;

    Interval(double pocetna_tacka, double krajnja_tacka, boolean a, boolean b)throws IllegalArgumentException{
        if(pocetna_tacka > krajnja_tacka) {
            throw new IllegalArgumentException("Pocetna tacka veca od krajnje!");
        }
        this.pocetna_tacka = pocetna_tacka;
        this.krajnja_tacka = krajnja_tacka;
        this.a = a;
        this.b = b;
    }
    Interval(){
        pocetna_tacka = 0;
        krajnja_tacka = 0;
        a = false;
        b = false;
    }

    boolean isNull (){
        if (this.pocetna_tacka == 0 && this.krajnja_tacka == 0 && this.a == false && this.b == false) return true;
        return false;
    }

    boolean isIn (double t){
        if (this.a == true && this.b == true && this.pocetna_tacka <= t && this.krajnja_tacka >= t) return true;
        if (this.a == false && this.b == false && this.pocetna_tacka < t && this.krajnja_tacka > t) return true;
        if (this.a == false && this.b == true && this.pocetna_tacka < t && this.krajnja_tacka >= t) return true;
        if (this.a == true && this.b == false && this.pocetna_tacka <= t && this.krajnja_tacka > t) return true;
        return false;
    }

    public Interval intersect (Interval i1){
        Interval i3 = new Interval();

        if (this.pocetna_tacka <= i1.pocetna_tacka && i1.krajnja_tacka <= this.krajnja_tacka){
            i3 = i1;
        }
        else if (this.pocetna_tacka >= i1.pocetna_tacka && this.krajnja_tacka <= i1.krajnja_tacka){
            i3 = this;
        }
        else if (this.krajnja_tacka > i1.pocetna_tacka){
            i3.pocetna_tacka = i1.pocetna_tacka;
            i3.krajnja_tacka = this.krajnja_tacka;
            i3.a = i1.a;
            i3.b = this.b;
        }
        else if (this.krajnja_tacka <= i1.pocetna_tacka) return i3;
        else if (i1.krajnja_tacka <= this.pocetna_tacka) return i3;
        else if (this.pocetna_tacka < i1.krajnja_tacka){
            i3.pocetna_tacka = this.pocetna_tacka;
            i3.krajnja_tacka = i1.krajnja_tacka;
            i3.a = this.a;
            i3.b = i1.b;
        }
        return i3;
    }

    static Interval intersect (Interval i1, Interval i2){
        Interval i3 = new Interval();
        if (i1.pocetna_tacka <= i2.pocetna_tacka && i2.krajnja_tacka <= i1.krajnja_tacka){
            i3 = i2;
        }
        else if (i1.pocetna_tacka >= i2.pocetna_tacka && i1.krajnja_tacka <= i2.krajnja_tacka){
            i3 = i1;
            if (i2.a == false) i3.a = false;
            if (i2.b == false) i3.a = false;
        }
        else if (i1.krajnja_tacka > i2.pocetna_tacka){
            i3.pocetna_tacka = i2.pocetna_tacka;
            i3.krajnja_tacka = i1.krajnja_tacka;
            i3.a = i2.a;
            i3.b = i1.b;
        }
        else if (i1.krajnja_tacka <= i2.pocetna_tacka) return i3;
        else if (i2.krajnja_tacka <= i1.pocetna_tacka) return i3;
        else if (i1.pocetna_tacka < i2.krajnja_tacka){
            i3.pocetna_tacka = i1.pocetna_tacka;
            i3.krajnja_tacka = i2.krajnja_tacka;
            i3.a = i1.a;
            i3.b = i2.b;
        }

        return i3;
    }

    public String toString (){

        String s = "";
        if(a == true) s += "[";
        else if (a == false) s += "(";

        if(pocetna_tacka == 0 && krajnja_tacka == 0 && a == false && b == false){
            return "()";
        }
        else {
            s += String.valueOf(pocetna_tacka) + "," + String.valueOf(krajnja_tacka);
        }

        if(b == true) s += "]";
        else if (b == false) s += ")";

        return s;
    }

    public boolean equals (Object o){
        if(o != null && o instanceof Interval){
            double pocetna_tacka = this.pocetna_tacka;
            double krajnja_tacka = this.krajnja_tacka;
            boolean a = this.a;
            boolean b = this.b;
            if(pocetna_tacka == ((Interval) o).pocetna_tacka && krajnja_tacka == ((Interval) o).krajnja_tacka
            && a == ((Interval) o).a && b == ((Interval) o).b) return true;
        }
        return false;
    }
}
