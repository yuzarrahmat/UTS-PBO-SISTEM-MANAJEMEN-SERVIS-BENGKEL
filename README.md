# UTS-PBO-SISTEM-MANAJEMEN-SERVIS-BENGKEL
Nama : Yuzar Rahmat Rafi Alhaq, NIM : 2509116025, Sistem Informasi A '2025
---

## 1. Deskripsi Proyek

AutoCare System adalah aplikasi berbasis *Command Line Interface* (CLI) yang dibangun menggunakan bahasa pemrograman Java dengan menerapkan prinsip Pemrograman Berorientasi Objek (OOP). Aplikasi ini dirancang untuk mengelola operasional bengkel kendaraan, mencakup pendaftaran antrean servis, pemilihan kategori layanan (servis rutin, ganti oli, hingga perbaikan berat), kalkulasi biaya otomatis, pemberian diskon member, serta pemrosesan penyelesaian transaksi.

---

## 2. Alur Program & Petunjuk Eksekusi

### Alur Kerja Sistem:
1. **Menu 1 (Tampilkan Daftar Antrean):** Menampilkan seluruh daftar kendaraan yang sedang di-servis beserta kodenya.
2. **Menu 2 (Tambah Antrean Servis Ringan / Ganti Oli):** Mendaftarkan kendaraan untuk servis rutin atau ganti oli.
3. **Menu 3 (Tambah Antrean Perbaikan Berat):** Mendaftarkan kendaraan dengan keluhan kerusakan berat dan estimasi sparepart.
4. **Menu 4 (Selesaikan Servis & Hitung Total Biaya):** Memproses pembayaran berdasarkan kode antrean, menghitung diskon member, lalu menghapus data dari antrean.
5. **Menu 5 (Keluar):** Menghentikan jalannya program CLI.

---

## 3. Penerapan Konsep OOP (UTS Criteria)

### A. Inheritance (2 Tipe)
* **Hierarchical Inheritance:** Class abstrak `LayananServis` diwarisi secara langsung oleh `ServisRutin` dan `PerbaikanBerat`.
* **Multilevel Inheritance:** Class `LayananServis` $\rightarrow$ diwarisi oleh `ServisRutin` $\rightarrow$ diwarisi oleh `ServisRutinGantiOli`.

### B. Polymorphism
* **Method Overriding:** Method abstrak `getKategoriServis()`, `getDetailServis()`, dan `hitungTotalBiaya()` pada superclass `LayananServis` di-override pada masing-masing subclass untuk menyesuaikan kriteria transaksi.
* **Method Overloading:** Method `hitungDiskon()` pada `LayananServis` didefinisikan dengan dua parameter berbeda:
  - `hitungDiskon(double persenDiskon)` untuk hitung persentase manual.
  - `hitungDiskon(boolean isMember)` untuk potongan otomatis member 10%.

---

## 4. Penjelasan Gambar (Tangkapan Layar Running Program)

*(Unggah dan sisipkan gambar screenshot hasil pengujian program kamu di sini)*
