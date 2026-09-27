package com.mycompany.bengkelsystem.main;

public class ServisRutinGantiOli extends ServisRutin {
    private String merkOli;
    private double hargaOli;

    public ServisRutinGantiOli(String kodeAntrean, String platNomor, String namaPemilik, double biayaDasar, double biayaPemeriksaan, String merkOli, double hargaOli) {
        super(kodeAntrean, platNomor, namaPemilik, biayaDasar, biayaPemeriksaan);
        this.merkOli = merkOli;
        this.hargaOli = hargaOli;
    }

    public String getMerkOli() { return merkOli; }
    public double getHargaOli() { return hargaOli; }

    @Override
    public String getKategoriServis() {
        return "Servis Rutin + Ganti Oli";
    }

    @Override
    public String getDetailServis() {
        return "Merk Oli: " + merkOli + " | Harga Oli: Rp " + hargaOli;
    }

    @Override
    public double hitungTotalBiaya() {
        return super.hitungTotalBiaya() + hargaOli;
    }
}