package com.mycompany.bengkelsystem.main;

public abstract class LayananServis {
    private String kodeAntrean;
    private String platNomor;
    private String namaPemilik;
    private double biayaDasar;

    public LayananServis(String kodeAntrean, String platNomor, String namaPemilik, double biayaDasar) {
        this.kodeAntrean = kodeAntrean;
        this.platNomor = platNomor;
        this.namaPemilik = namaPemilik;
        this.biayaDasar = biayaDasar;
    }

    // Getter dan Setter
    public String getKodeAntrean() { return kodeAntrean; }
    public void setKodeAntrean(String kodeAntrean) { this.kodeAntrean = kodeAntrean; }

    public String getPlatNomor() { return platNomor; }
    public void setPlatNomor(String platNomor) { this.platNomor = platNomor; }

    public String getNamaPemilik() { return namaPemilik; }
    public void setNamaPemilik(String namaPemilik) { this.namaPemilik = namaPemilik; }

    public double getBiayaDasar() { return biayaDasar; }
    public void setBiayaDasar(double biayaDasar) { this.biayaDasar = biayaDasar; }

    // Abstract Method (Persiapan Method Overriding untuk Polymorphism)
    public abstract String getKategoriServis();
    public abstract String getDetailServis();
    public abstract double hitungTotalBiaya();

    // Overloading Method 1: Hitung Diskon berdasarkan persen (0-100%)
    public double hitungDiskon(double persenDiskon) {
        return hitungTotalBiaya() * (persenDiskon / 100.0);
    }

    // Overloading Method 2: Hitung Diskon berdasarkan status member
    public double hitungDiskon(boolean isMember) {
        if (isMember) {
            return hitungTotalBiaya() * 0.10; // Diskon 10% untuk member
        }
        return 0.0;
    }
}