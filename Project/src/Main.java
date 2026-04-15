/**
 * KELAS UTAMA (MAIN CLASS): Main
 * Menjalankan simulasi sistem manajemen kendaraan.
 */
public class Main {

    // Helper: cetak pemisah
    static void baris(String judul) {
        System.out.println("\n▶ " + judul);
        System.out.println("  " + "─".repeat(40));
    }

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║    SIMULASI SISTEM MANAJEMEN KENDARAAN   ║");
        System.out.println("╚══════════════════════════════════════════╝");

        // ── 1. Buat objek Mesin (Kelas Dasar) ──────────────────────────
        baris("Membuat Mesin");
        Mesin mesinToyota = new Mesin(120, "Bensin");
        Mesin mesinBMW    = new Mesin(250, "Bensin Premium");
        System.out.println("  Mesin 1 dibuat: " + mesinToyota.getInfo());
        System.out.println("  Mesin 2 dibuat: " + mesinBMW.getInfo());

        // ── 2. Buat objek Mobil (Kelas Implementasi) ───────────────────
        baris("Membuat Mobil");
        Mobil mobilA = new Mobil("Toyota Avanza", 2022, 4, 45.0, mesinToyota);
        Mobil mobilB = new Mobil("BMW 320i",      2023, 4, 60.0, mesinBMW);
        System.out.println("  Dua mobil berhasil dibuat.");

        // ── 3. Tampilkan info (metode abstract infoKendaraan) ──────────
        baris("Info Kendaraan (metode abstract)");
        mobilA.infoKendaraan();
        System.out.println();
        mobilB.infoKendaraan();

        // ── 4. Simulasi bergerak (interface IBisaBergerak) ─────────────
        baris("Simulasi Berkendara - " + mobilA.getMerk());
        mobilA.bergerak();
        mobilA.bergerak();
        mobilA.bergerak();

        // ── 5. Simulasi pengisian BBM (interface IDapatDiisi) ──────────
        baris("Pengisian BBM di SPBU");
        System.out.println("  BBM sebelum isi: " + mobilA.getSisaBBM() + " L");
        mobilA.isi(30);  // isi 30 liter
        mobilA.isi(20);  // coba isi lagi (mungkin meluap)

        // ── 6. Simulasi berhenti ───────────────────────────────────────
        baris("Mobil Berhenti");
        mobilA.berhenti();
        mobilA.berhenti(); // panggil lagi — sudah berhenti

        // ── 7. Polimorfisme via interface ──────────────────────────────
        baris("Polimorfisme via Interface IBisaBergerak");
        IBisaBergerak[] armada = { mobilA, mobilB };
        for (IBisaBergerak k : armada) {
            System.out.println("  Menjalankan kendaraan...");
            k.bergerak();
        }

        // ── 8. Hentikan semua via interface ────────────────────────────
        baris("Menghentikan Semua Kendaraan");
        for (IBisaBergerak k : armada) {
            k.berhenti();
        }

        // ── 9. Info akhir ──────────────────────────────────────────────
        baris("Info Akhir Kendaraan A");
        mobilA.infoKendaraan();

        System.out.println("\n✅ Simulasi selesai.");
    }
}
