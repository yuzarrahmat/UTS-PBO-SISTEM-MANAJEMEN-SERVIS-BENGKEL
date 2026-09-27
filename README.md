# UTS-PBO-SISTEM-MANAJEMEN-SERVIS-BENGKEL
Nama : Yuzar Rahmat Rafi Alhaq, NIM : 2509116025, Sistem Informasi A '2025
---

## 1. Deskripsi Proyek

Sistem Manajemen Servis Bengkel adalah aplikasi berbasis *Command Line Interface* (CLI) yang dibangun menggunakan bahasa pemrograman Java dengan menerapkan prinsip Pemrograman Berorientasi Objek (OOP). Aplikasi ini dirancang untuk mengelola operasional bengkel kendaraan, mencakup pendaftaran antrean servis, pemilihan kategori layanan (servis rutin, ganti oli, hingga perbaikan berat), kalkulasi biaya otomatis, pemberian diskon member, serta pemrosesan penyelesaian transaksi.

---

## 2. Alur Program & Petunjuk Eksekusi

### Alur Kerja Sistem:
1. **Menu 1 (Tampilkan Daftar Antrean):** Menampilkan seluruh daftar kendaraan yang sedang di-servis beserta kodenya.
2. **Menu 2 (Tambah Antrean Servis Ringan / Ganti Oli):** Mendaftarkan kendaraan untuk servis rutin atau ganti oli.
3. **Menu 3 (Tambah Antrean Perbaikan Berat):** Mendaftarkan kendaraan dengan keluhan kerusakan berat dan estimasi sparepart.
4. **Menu 4 (Selesaikan Servis & Hitung Total Biaya):** Memproses pembayaran berdasarkan kode antrean, menghitung diskon member, lalu menghapus data dari antrean.
5. **Menu 5 (Keluar):** Menghentikan jalannya program CLI.

---

## 3. Penerapan Konsep OOP (target uts)

### A. Inheritance (2 Tipe)
* **Hierarchical Inheritance:** Class abstrak `LayananServis` diwarisi secara langsung oleh `ServisRutin` dan `PerbaikanBerat`.
* **Multilevel Inheritance:** Class `LayananServis` $\rightarrow$ diwarisi oleh `ServisRutin` $\rightarrow$ diwarisi oleh `ServisRutinGantiOli`.

### B. Polymorphism
* **Method Overriding:** Method abstrak `getKategoriServis()`, `getDetailServis()`, dan `hitungTotalBiaya()` pada superclass `LayananServis` di-override pada masing-masing subclass untuk menyesuaikan kriteria transaksi.
* **Method Overloading:** Method `hitungDiskon()` pada `LayananServis` didefinisikan dengan dua parameter berbeda:
  - `hitungDiskon(double persenDiskon)` untuk hitung persentase manual.
  - `hitungDiskon(boolean isMember)` untuk potongan otomatis member 10%.

---

## 4. Penjelasan Gambar

1. 
<img width="1920" height="1020" alt="image" src="https://github.com/user-attachments/assets/77333d3f-0d30-403c-9ff0-92e2ca267199" />

- Menunjukkan kondisi awal program saat dijalankan, menampilkan pilihan menu utama aplikasi berbasis CLI (Command Line Interface), serta hasil eksekusi Menu 1 yang memuat daftar antrean servis awal (dummy data) kendaraan.   

2. 
<img width="1920" height="1020" alt="image" src="https://github.com/user-attachments/assets/9c517f68-c475-43c1-813f-005ef5d39a6b" />

- Menampilkan proses interaksi pada Menu 2 untuk mendaftarkan antrean baru kategori Servis Rutin + Ganti Oli. Pengguna memasukkan plat nomor, nama pemilik, jenis oli beserta harganya, dan sistem secara otomatis menambahkan data ke dalam daftar antrean.

3. 
<img width="1920" height="1020" alt="image" src="https://github.com/user-attachments/assets/ffdc66fb-abdd-45f1-b3e7-1abb5a04067d" />

- Menampilkan proses eksekusi Menu 3 untuk menambahkan data servis dengan kategori Perbaikan Berat (seperti penanganan kerusakan berat dan biaya sparepart). Data baru berhasil dimasukkan dan ter-update secara dinamis ke dalam sistem antrean.

4. 
<img width="1920" height="1020" alt="image" src="https://github.com/user-attachments/assets/23b7d502-db9e-4cc4-bfcf-ab9ffaeff11b" />

- Menampilkan eksekusi Menu 4 untuk menyelesaikan transaksi servis berdasarkan kode antrean. Pada tahap ini, sistem menerapkan konsep Polymorphism Method Overloading untuk menghitung potongan diskon member secara otomatis, menampilkan rincian total biaya akhir, serta menghapus data kendaraan dari antrean setelah transaksi selesai.
