package com.mycompany.bengkelsystem.main;

import java.util.ArrayList;
import java.util.Scanner;

public class BengkelSystem {
    private static ArrayList<LayananServis> daftarAntrean = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int counterAntrean = 1;

    public static void main(String[] args) {
        // Data Awal (Dummy Data)
        daftarAntrean.add(new ServisRutinGantiOli("A01", "KT 1234 AB", "Ryu", 50000, 20000, "Shell Helix 10W-40", 85000));
        daftarAntrean.add(new PerbaikanBerat("A02", "KT 5678 CD", "Budi", 100000, "Ganti Overhaul CVT", 350000));

        boolean running = true;
        while (running) {
            System.out.println("\n==========================================");
            System.out.println("   SYSTEM MANAJEMEN SERVIS BENGKEL (AUTOCARE) ");
            System.out.println("==========================================");
            System.out.println("1. Tampilkan Daftar Antrean");
            System.out.println("2. Tambah Antrean Servis Ringan / Ganti Oli");
            System.out.println("3. Tambah Antrean Perbaikan Berat");
            System.out.println("4. Selesaikan Servis & Hitung Total Biaya");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu [1-5]: ");

            int pilihan = bacaInt();

            if (pilihan == 1) {
                tampilAntrean();
            } else if (pilihan == 2) {
                tambahServisRutin();
            } else if (pilihan == 3) {
                tambahPerbaikanBerat();
            } else if (pilihan == 4) {
                selesaikanServis();
            } else if (pilihan == 5) {
                System.out.println("\nTerima kasih telah menggunakan AutoCare System!");
                running = false;
            } else {
                System.out.println("Pilihan tidak valid! Masukkan angka 1-5.");
            }
        }
    }

    private static void tampilAntrean() {
        System.out.println("\n--- DAFTAR ANTREAN SERVIS BENGKEL ---");
        if (daftarAntrean.isEmpty()) {
            System.out.println("Tidak ada antrean servis saat ini.");
            return;
        }

        for (LayananServis item : daftarAntrean) {
            System.out.println("[" + item.getKodeAntrean() + "] " + item.getPlatNomor() + " - " + item.getNamaPemilik());
            System.out.println("    Kategori : " + item.getKategoriServis());
            System.out.println("    Detail   : " + item.getDetailServis());
            System.out.println("    Estimasi Biaya Dasar: Rp " + item.hitungTotalBiaya());
            System.out.println("------------------------------------------");
        }
    }

    private static void tambahServisRutin() {
        System.out.println("\n--- TAMBAH ANTREAN SERVIS RUTIN ---");
        String kode = "A0" + (++counterAntrean);
        
        System.out.print("Masukkan Plat Nomor: ");
        String plat = scanner.nextLine();
        System.out.print("Masukkan Nama Pemilik: ");
        String nama = scanner.nextLine();
        
        System.out.print("Apakah ada ganti oli? (y/n): ");
        String gantiOli = scanner.nextLine();

        if (gantiOli.equalsIgnoreCase("y")) {
            System.out.print("Masukkan Merk Oli: ");
            String merkOli = scanner.nextLine();
            System.out.print("Masukkan Harga Oli (Rp): ");
            double hargaOli = bacaDouble();
            
            daftarAntrean.add(new ServisRutinGantiOli(kode, plat, nama, 50000, 25000, merkOli, hargaOli));
            System.out.println("Antrean Servis Ringan + Ganti Oli berhasil ditambahkan!");
        } else {
            daftarAntrean.add(new ServisRutin(kode, plat, nama, 50000, 25000));
            System.out.println("Antrean Servis Ringan berhasil ditambahkan!");
        }
    }

    private static void tambahPerbaikanBerat() {
        System.out.println("\n--- TAMBAH ANTREAN PERBAIKAN BERAT ---");
        String kode = "A0" + (++counterAntrean);
        
        System.out.print("Masukkan Plat Nomor: ");
        String plat = scanner.nextLine();
        System.out.print("Masukkan Nama Pemilik: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Jenis Kerusakan: ");
        String kerusakan = scanner.nextLine();
        System.out.print("Masukkan Biaya Sparepart (Rp): ");
        double biayaSparepart = bacaDouble();

        daftarAntrean.add(new PerbaikanBerat(kode, plat, nama, 100000, kerusakan, biayaSparepart));
        System.out.println("Antrean Perbaikan Berat berhasil ditambahkan!");
    }

    private static void selesaikanServis() {
        System.out.println("\n--- PROSES SELESAI SERVIS & PEMBAYARAN ---");
        if (daftarAntrean.isEmpty()) {
            System.out.println("Tidak ada antrean servis untuk diproses.");
            return;
        }

        System.out.print("Masukkan Kode Antrean (contoh: A01): ");
        String kodeTarget = scanner.nextLine();

        LayananServis servisDitemukan = null;
        for (LayananServis item : daftarAntrean) {
            if (item.getKodeAntrean().equalsIgnoreCase(kodeTarget)) {
                servisDitemukan = item;
                break;
            }
        }

        if (servisDitemukan != null) {
            System.out.println("\nDetail Servis Ditemukan:");
            System.out.println("Plat Nomor   : " + servisDitemukan.getPlatNomor());
            System.out.println("Pemilik      : " + servisDitemukan.getNamaPemilik());
            System.out.println("Kategori     : " + servisDitemukan.getKategoriServis());
            
            double totalBiaya = servisDitemukan.hitungTotalBiaya();
            System.out.println("Subtotal Biaya : Rp " + totalBiaya);

            System.out.print("Apakah pelanggan memiliki Member? (y/n): ");
            String isMemberStr = scanner.nextLine();
            boolean isMember = isMemberStr.equalsIgnoreCase("y");

            // Menggunakan Polymorphism Overloading Method (hitungDiskon)
            double diskon = servisDitemukan.hitungDiskon(isMember);
            double totalBayar = totalBiaya - diskon;

            System.out.println("Diskon       : Rp " + diskon);
            System.out.println("------------------------------------------");
            System.out.println("TOTAL BAYAR  : Rp " + totalBayar);

            daftarAntrean.remove(servisDitemukan);
            System.out.println("\nStatus: Servis Selesai & Data Kendaraan Dihapus dari Antrean.");
        } else {
            System.out.println("Kode antrean tidak ditemukan!");
        }
    }

    private static int bacaInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Input harus berupa angka! Coba lagi: ");
            scanner.next();
        }
        int val = scanner.nextInt();
        scanner.nextLine();
        return val;
    }

    private static double bacaDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Input harus berupa angka desimal/nominal! Coba lagi: ");
            scanner.next();
        }
        double val = scanner.nextDouble();
        scanner.nextLine();
        return val;
    }
}