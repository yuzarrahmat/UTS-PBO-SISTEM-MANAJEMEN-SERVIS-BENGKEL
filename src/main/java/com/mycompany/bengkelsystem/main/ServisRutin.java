package com.mycompany.bengkelsystem.main;

public class ServisRutin extends LayananServis {
    private double biayaPemeriksaan;

    public ServisRutin(String kodeAntrean, String platNomor, String namaPemilik, double biayaDasar, double biayaPemeriksaan) {
        super(kodeAntrean, platNomor, namaPemilik, biayaDasar);
        this.biayaPemeriksaan = biayaPemeriksaan;
    }

    public double getBiayaPemeriksaan() { return biayaPemeriksaan; }

    @Override
    public String getKategoriServis() {
        return "Servis Rutin";
    }

    @Override
    public String getDetailServis() {
        return "Biaya Cek Ringan: Rp " + biayaPemeriksaan;
    }

    @Override
    public double hitungTotalBiaya() {
        return getBiayaDasar() + biayaPemeriksaan;
    }
}