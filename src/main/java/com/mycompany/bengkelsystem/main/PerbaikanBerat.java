package com.mycompany.bengkelsystem.main;

public class PerbaikanBerat extends LayananServis {
    private String jenisKerusakan;
    private double biayaSparepart;

    public PerbaikanBerat(String kodeAntrean, String platNomor, String namaPemilik, double biayaDasar, String jenisKerusakan, double biayaSparepart) {
        super(kodeAntrean, platNomor, namaPemilik, biayaDasar);
        this.jenisKerusakan = jenisKerusakan;
        this.biayaSparepart = biayaSparepart;
    }

    public String getJenisKerusakan() { return jenisKerusakan; }
    public double getBiayaSparepart() { return biayaSparepart; }

    @Override
    public String getKategoriServis() {
        return "Perbaikan Berat";
    }

    @Override
    public String getDetailServis() {
        return "Kerusakan: " + jenisKerusakan + " | Biaya Sparepart: Rp " + biayaSparepart;
    }

    @Override
    public double hitungTotalBiaya() {
        return getBiayaDasar() + biayaSparepart;
    }
}